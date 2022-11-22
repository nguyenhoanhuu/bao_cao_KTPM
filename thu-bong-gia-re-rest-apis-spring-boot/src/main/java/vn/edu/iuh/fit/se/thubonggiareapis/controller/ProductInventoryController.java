package vn.edu.iuh.fit.se.thubonggiareapis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.ProductInventoryDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.service.IProductInventoryService;

@RestController
@RequestMapping(value = { "/productInventory" })
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductInventoryController {

	@Autowired
	private IProductInventoryService productInventoryService;

	@GetMapping(value = "/{id}")
	public ProductInventoryDTO getProductInventoryByProductId(@PathVariable Long id) {
		return productInventoryService.getProductInventory(id);
	}

	@PostMapping(value = { "", "/" }, consumes = { "application/x-www-form-urlencoded", "application/json" })
	public void updateProductInventory(@RequestBody ProductInventoryDTO productInventoryDTO) {
		productInventoryService.updateProductInventory(productInventoryDTO);

	}
}
