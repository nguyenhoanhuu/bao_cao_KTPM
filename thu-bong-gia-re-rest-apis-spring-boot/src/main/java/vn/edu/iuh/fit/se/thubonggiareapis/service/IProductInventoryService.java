package vn.edu.iuh.fit.se.thubonggiareapis.service;

import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.ProductInventoryDTO;

@Service
public interface IProductInventoryService {
    void addProductInventory(ProductInventoryDTO productInventoryDTO);

    void updateProductInventory(ProductInventoryDTO productInventoryDTO);

    ProductInventoryDTO getProductInventory(long id);
}
