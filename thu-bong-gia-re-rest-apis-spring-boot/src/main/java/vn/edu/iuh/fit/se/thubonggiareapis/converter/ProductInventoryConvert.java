package vn.edu.iuh.fit.se.thubonggiareapis.converter;

import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.ProductInventoryDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.ProductInventory;

@Component
public class ProductInventoryConvert {
    public ProductInventory toEntity(ProductInventoryDTO productInventoryDTO) {
        ProductInventory productInventory;
        if (productInventoryDTO.getId() != 0) {
            productInventory = new ProductInventory(productInventoryDTO.getId());
        } else {
            productInventory = new ProductInventory();
        }

        productInventory.setCost(productInventoryDTO.getCost());
        productInventory.setCreatedAt(productInventoryDTO.getCreatedAt());
        productInventory.setQuantity(productInventoryDTO.getQuantity());
        return productInventory;
    }

    public ProductInventoryDTO toDto(ProductInventory productInventory) {
        ProductInventoryDTO productInventoryDTO = new ProductInventoryDTO();
        if (productInventory.getId() != 0) {
            productInventoryDTO.setId(productInventory.getId());
        }

        productInventoryDTO.setCost(productInventory.getCost());
        productInventoryDTO.setCreatedAt(productInventory.getCreatedAt());
        productInventoryDTO.setProduct(productInventory.getProduct().getId());
        productInventoryDTO.setQuantity(productInventory.getQuantity());
        return productInventoryDTO;
    }
}
