package vn.edu.iuh.fit.se.thubonggiareapis.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.Promotion;

@RestController
@RequestMapping(value = "/promotions")
public class PromotionController {

	public static final String PRODUCT_SERVICE = "customerService";
	public static final String url = "http://localhost:8081/promotions";

	@Autowired
	@Lazy
	private RestTemplate restTemplate;
	private int attemptGetPromotion = 1;
	private int attemptGetPromotionById = 1;
	private int attemptUpdatePromotion = 1;

	@GetMapping({ "", "/" })
	@CircuitBreaker(name = PRODUCT_SERVICE)
	@Retry(name = PRODUCT_SERVICE)
	@RateLimiter(name = PRODUCT_SERVICE)
	public Promotion[] getPromotions() {
		System.out.println("retry method called " + attemptGetPromotion++ + " times " + " at " + new Date());
		ResponseEntity<Promotion[]> response = restTemplate.getForEntity(url, Promotion[].class);
		Promotion[] promotions = response.getBody();
		return promotions;
	}

	@GetMapping("/{promotionId}")
	@Cacheable(value = "promotion", key = "#promotionId")
	@CircuitBreaker(name = PRODUCT_SERVICE)
	@Retry(name = PRODUCT_SERVICE)
//	@RateLimiter(name = PRODUCT_SERVICE)
	public Promotion findProductById(@PathVariable String promotionId) {

		System.out.println("retry method called " + attemptGetPromotionById++ + " times " + " at " + new Date());

		ResponseEntity<Promotion> response = restTemplate.getForEntity(url + "/" + promotionId, Promotion.class);
		return response.getBody();
	}

	@PutMapping(value = { "", "/" }, consumes = { "application/json", "application/x-www-form-urlencoded" })
	@CachePut(value = "promotion", key = "#productDTO.id")
	@Retry(name = PRODUCT_SERVICE)
	public String updatePromotion(@RequestBody Promotion promotion) {
		System.out.println("retry method called " + attemptUpdatePromotion++ + " times " + " at " + new Date());
		Promotion response = restTemplate.postForObject(url + "/promotions", promotion, Promotion.class);
		return "thành công";

	}

	@PostMapping(value = { "", "/" })
	public Promotion addPromotion(@RequestBody Promotion promotion) {
		System.out.println("retry method called " + attemptUpdatePromotion++ + " times " + " at " + new Date());
		Promotion response = restTemplate.postForObject(url , promotion, Promotion.class);
		return response;
	}

}
