package vn.edu.iuh.fit.se.thubonggiareapis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.ProductDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.service.IProductService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {
	@Autowired
	private IProductService productService;

	@PostMapping(value = { "", "/" }, consumes = { "application/json", "application/x-www-form-urlencoded" })
	public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO model) {
		try {
			ProductDTO result = productService.addProduct(model);
			return new ResponseEntity<>(result, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = { "", "/" })
	public ResponseEntity<List<ProductDTO>> getProducts(
			@RequestParam(name = "id", required = false) Optional<List<Long>> ids,
			@RequestParam(name = "sortBy", required = false) Optional<String> sortBy,
			@RequestParam(name = "sort", required = false) Optional<String> sort,
			@RequestParam(name = "name", required = false) Optional<String> name,
			@RequestParam(name = "category", required = false) Optional<String> category) {
		try {
			List<ProductDTO> result;

			if (category.isPresent()) {
				result = productService.getProductsByCategory(category.get());
				return result.size() > 0 ? new ResponseEntity<>(result, HttpStatus.OK)
						: new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

			if (ids.isPresent()) {
				result = productService.getProductsByIds(ids.get());
				return result.size() > 0 ? new ResponseEntity<>(result, HttpStatus.OK)
						: new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

			if (sortBy.isPresent()) {
				if (!sort.isPresent()) {
					result = productService.getProductSortByCost("ASC");
					return new ResponseEntity<List<ProductDTO>>(result, HttpStatus.OK);
				}
				if (sort.get().equals("asc")) {
					result = productService.getProductSortByCost("ASC");
					return new ResponseEntity<List<ProductDTO>>(result, HttpStatus.OK);
				}
				if (sort.get().equals("desc")) {
					result = productService.getProductSortByCost("DESC");
					return new ResponseEntity<List<ProductDTO>>(result, HttpStatus.OK);
				}
			}
			if (name.isPresent()) {
				result = productService.findProductByName(name.get());
				return new ResponseEntity<List<ProductDTO>>(result, HttpStatus.OK);
			}

			List<ProductDTO> products = productService.getProducts();
			if (products.size() == 0) {
				return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
			}
			return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
		try {
			ProductDTO result = productService.getProductById(id);
			if (result == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(value = { "/update" }, consumes = { "application/json", "application/x-www-form-urlencoded" })
	public void updateProduct(@RequestBody ProductDTO productDTO) {
		productService.updateProduct(productDTO);
	}

	@GetMapping({ "/categories", "/categories" })
	public List<String> getCategories() {
		return productService.getCategories();
	}

	@GetMapping({ "/stats", "/stats/" })
	public ResponseEntity<HashMap<String, Object>> getStats() {
		HashMap<String, Object> response = new HashMap<>();
		try {
			response.put("totalProduct", productService.getTotalProduct());
			response.put("totalCategory", productService.getTotalCategory());
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
