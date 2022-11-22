package vn.edu.iuh.fit.se.thubonggiareapis.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.ProductDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.Product;

@RestController
@RequestMapping("/products")

public class ProductController {

	public static final String PRODUCT_SERVICE = "customerService";
	public static final String url = "http://localhost:8081/products";

	@Autowired
	@Lazy
	private RestTemplate restTemplate;
	private int attemptCount = 1;
	private int attemptGetProduct = 1;
	private int attemptGetProducts = 1;
	private int attemptUpdateProduct = 1;



	@GetMapping({ "", "/" })
//	@CircuitBreaker(name = PRODUCT_SERVICE, fallbackMethod = "getProductAvailable")
//	@Retry(name = PRODUCT_SERVICE, fallbackMethod = "getProductsAvailable")
//	@RateLimiter(name = PRODUCT_SERVICE)
	public Product[] getProducts() {
		System.out.println("retry method called " + attemptGetProducts++ + " times " + " at " + new Date());
		ResponseEntity<Product[]> response = restTemplate.getForEntity(url, Product[].class);
		Product[] products = response.getBody();
		return products;
	}

	@GetMapping("/{productId}")
	@Cacheable(value = "product", key = "#productId")
	@CircuitBreaker(name = PRODUCT_SERVICE, fallbackMethod = "getProductAvailable")
	@Retry(name = PRODUCT_SERVICE, fallbackMethod = "getProductAvailable")
//	@RateLimiter(name = PRODUCT_SERVICE)
	public Product findProductById(@PathVariable String productId) {

		System.out.println("retry method called " + attemptGetProduct++ + " times " + " at " + new Date());

		ResponseEntity<Product> response = restTemplate.getForEntity(url + "/" + productId, Product.class);
		return response.getBody();
	}

	public Product getProductAvailable(Exception e) {
		Product product = new Product(20l, PRODUCT_SERVICE, attemptCount, PRODUCT_SERVICE, PRODUCT_SERVICE,
				PRODUCT_SERVICE, attemptCount, PRODUCT_SERVICE, url, attemptCount, attemptCount, attemptCount,
				PRODUCT_SERVICE);
		return product;
	}

	@GetMapping({ "/categories", "/categories" })
	public ResponseEntity<String[]> getCategories() {

		ResponseEntity<String[]> response = restTemplate.getForEntity(url + "/" + "categories", String[].class);
		List<String> getCategories = new ArrayList<String>();

		return response;
	}

	@PostMapping("")
	@CachePut(value = "product", key = "#productDTO.id")
	public String addProduct(@RequestBody ProductDTO productDTO) {

		try {
			ProductDTO response = restTemplate.postForObject(url, productDTO, ProductDTO.class);
			return "Thêm thành công";
		} catch (Exception e) {
			// TODO: handle exception
			return "Thêm thất bại";

		}

	}

	@PutMapping(value = { "", "/" }, consumes = { "application/json", "application/x-www-form-urlencoded" })
//	@CachePut(value = "product", key = "#productDTO.id")
	@Retry(name = PRODUCT_SERVICE)
	public String updateProduct(@RequestBody ProductDTO productDTO) {
		System.out.println("retry method called " + attemptUpdateProduct++ + " times " + " at " + new Date());
		ProductDTO response = restTemplate.postForObject(url + "/update", productDTO, ProductDTO.class);
		return "thành công";

	}

//	@Autowired
//	private IProductService productService;
//
//	@PostMapping(value = { "", "/" }, consumes = { "application/json", "application/x-www-form-urlencoded" })
//	public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO model) {
//		try {
//			ProductDTO result = productService.addProduct(model);
//			return new ResponseEntity<>(result, HttpStatus.CREATED);
//		} catch (Exception e) {
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
//
//	@GetMapping(value = { "", "/" })
//	public ResponseEntity<List<ProductDTO>> getProducts(
//			@RequestParam(name = "id", required = false) Optional<List<Long>> ids,
//			@RequestParam(name = "sortBy", required = false) Optional<String> sortBy,
//			@RequestParam(name = "sort", required = false) Optional<String> sort,
//			@RequestParam(name = "name", required = false) Optional<String> name,
//			@RequestParam(name = "category", required = false) Optional<String> category) {
//		try {
//			List<ProductDTO> result;
//
//			if (category.isPresent()) {
//				result = productService.getProductsByCategory(category.get());
//				return result.size() > 0 ? new ResponseEntity<>(result, HttpStatus.OK)
//						: new ResponseEntity<>(HttpStatus.NOT_FOUND);
//			}
//
//			if (ids.isPresent()) {
//				result = productService.getProductsByIds(ids.get());
//				return result.size() > 0 ? new ResponseEntity<>(result, HttpStatus.OK)
//						: new ResponseEntity<>(HttpStatus.NOT_FOUND);
//			}
//
//			if (sortBy.isPresent()) {
//				if (!sort.isPresent()) {
//					result = productService.getProductSortByCost("ASC");
//					return new ResponseEntity<List<ProductDTO>>(result, HttpStatus.OK);
//				}
//				if (sort.get().equals("asc")) {
//					result = productService.getProductSortByCost("ASC");
//					return new ResponseEntity<List<ProductDTO>>(result, HttpStatus.OK);
//				}
//				if (sort.get().equals("desc")) {
//					result = productService.getProductSortByCost("DESC");
//					return new ResponseEntity<List<ProductDTO>>(result, HttpStatus.OK);
//				}
//			}
//			if (name.isPresent()) {
//				result = productService.findProductByName(name.get());
//				return new ResponseEntity<List<ProductDTO>>(result, HttpStatus.OK);
//			}
//
//			List<ProductDTO> products = productService.getProducts();
//			if (products.size() == 0) {
//				return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
//			}
//			return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
//
//	@GetMapping("/{id}")
//	@Cacheable(value = "product", key = "#id")
//	public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
//		try {
//			ProductDTO result = productService.getProductById(id);
//			if (result == null) {
//				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//			}
//			return new ResponseEntity<>(result, HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
//
//	@PutMapping(value = { "", "/" }, consumes = { "application/json", "application/x-www-form-urlencoded" })
//	@CachePut(value = "product", key = "#customer.customerId")
//	public void updateProduct(@RequestBody ProductDTO productDTO) {
//		productService.updateProduct(productDTO);
//	}
//
//	@GetMapping({ "/categories", "/categories" })
//	public List<String> getCategories() {
//		return productService.getCategories();
//	}
//
//	@GetMapping({ "/stats", "/stats/" })
//	public ResponseEntity<HashMap<String, Object>> getStats() {
//		HashMap<String, Object> response = new HashMap<>();
//		try {
//			response.put("totalProduct", productService.getTotalProduct());
//			response.put("totalCategory", productService.getTotalCategory());
//			return new ResponseEntity<>(response, HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
}
