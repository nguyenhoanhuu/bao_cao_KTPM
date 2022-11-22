package vn.edu.iuh.fit.se.thubonggiareapis.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.ProductInventory;

@RestController
@RequestMapping(value = { "/productInventory" })

public class ProductInventoryController {
	public static final String PRODUCT_SERVICE = "customerService";
	public static final String url = "http://localhost:8081/productInventory";
	private int attemptGetProducts = 1;

	@Autowired
	@Lazy
	private RestTemplate restTemplate;

	@GetMapping("/{id}")
	@Cacheable(value = "productInventory", key = "#id")
	@CircuitBreaker(name = PRODUCT_SERVICE)
//	@Retry(name = PRODUCT_SERVICE)
//	@RateLimiter(name = PRODUCT_SERVICE)
	public ProductInventory findProductById(@PathVariable String id) {
		System.out.println("retry method called " + attemptGetProducts++ + " times " + " at " + new Date());
		ResponseEntity<ProductInventory> response = restTemplate.getForEntity(url + "/" + id, ProductInventory.class);
		return response.getBody();
	}

	@PutMapping(value = { "", "/" })
//	@CachePut(value = "productInventory", key = "#productInventoryDTO.id")
	@CircuitBreaker(name = PRODUCT_SERVICE)
	@Retry(name = PRODUCT_SERVICE)
	@RateLimiter(name = PRODUCT_SERVICE)
	public ProductInventory updateProductInventory(@RequestBody ProductInventory productInventoryDTO) {

		ProductInventory response = restTemplate.postForObject(url, productInventoryDTO, ProductInventory.class);
		return response;

	}

}
