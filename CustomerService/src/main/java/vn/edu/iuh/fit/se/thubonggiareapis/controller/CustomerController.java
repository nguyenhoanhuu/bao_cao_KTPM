package vn.edu.iuh.fit.se.thubonggiareapis.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.CustomerDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.Customer;

@RestController
@RequestMapping("/customers")

public class CustomerController {

	public static final String CUSTOMER_SERVICE = "customerService";
	public static final String url = "http://localhost:8081/customers";

	@Autowired
	@Lazy
	private RestTemplate restTemplate;
	private int attemptGetCustomer = 1;
	private int attemptAddCustomer = 1;

	@GetMapping("/{customerId}")
	@Cacheable(value = "customer", key = "#customerId")
	@CircuitBreaker(name = CUSTOMER_SERVICE, fallbackMethod = "getCustomerAvailable")
	@Retry(name = CUSTOMER_SERVICE, fallbackMethod = "getCustomerAvailable")
	@RateLimiter(name = CUSTOMER_SERVICE)
	public Customer findProductById(@PathVariable String customerId) {

		System.out.println("retry method called " + attemptGetCustomer++ + " times " + " at " + new Date());

		ResponseEntity<Customer> response = restTemplate.getForEntity(url + "/" + customerId, Customer.class);
		return response.getBody();
	}

	public Customer getCustomerAvailable(Exception e) {
		Customer customer = new Customer(20l, "Nguyễn Hoàn Hữu", "huu@gmail.com", "0968172111");
		return customer;
	}

	
	@PostMapping({"","/"})
	@Cacheable(value = "customer", key = "#customerDTO.id")
	@CircuitBreaker(name = CUSTOMER_SERVICE)
	@Retry(name = CUSTOMER_SERVICE)
	@RateLimiter(name = CUSTOMER_SERVICE)
	public CustomerDTO addCustomer(@RequestBody CustomerDTO customerDTO) {

		System.out.println("retry method called " + attemptAddCustomer++ + " times " + " at " + new Date());

		CustomerDTO response = restTemplate.postForObject(url ,customerDTO, CustomerDTO.class);
		return response;
	}

}
