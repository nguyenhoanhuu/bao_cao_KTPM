package vn.edu.iuh.fit.se.thubonggiareapis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.se.thubonggiareapis.converter.ProductInventoryConvert;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.ProductInventoryDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.Product;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.ProductInventory;
import vn.edu.iuh.fit.se.thubonggiareapis.repository.ProductInventoryRepository;
import vn.edu.iuh.fit.se.thubonggiareapis.repository.ProductRepository;
import vn.edu.iuh.fit.se.thubonggiareapis.service.IProductInventoryService;

import java.util.Objects;

@Service
public class ProductInventoryServiceImpl implements IProductInventoryService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductInventoryRepository productInventoryRepository;

    @Autowired
    private ProductInventoryConvert productInventoryConvert;

    @Override
    public void addProductInventory(ProductInventoryDTO productInventoryDTO) {
        ProductInventory productInventory = productInventoryConvert.toEntity(productInventoryDTO);
        Product product = productRepository.getById(productInventoryDTO.getProduct());
        productInventory.setProduct(product);
        productInventoryRepository.save(productInventory);

    }

    @Override
    public void updateProductInventory(ProductInventoryDTO productInventoryDTO) {
//		ProductInventory productInventory = productInventoryConvert.toProductInventoryEntity(productInventoryDTO);
        ProductInventory productInventory = productInventoryRepository.getById(productInventoryDTO.getId());

        if (productInventory.getQuantity() + productInventoryDTO.getQuantity() >= 0) {
            productInventory.setQuantity(productInventory.getQuantity() + productInventoryDTO.getQuantity());
            productInventory = productInventoryRepository.save(productInventory);
        }

    }

    @Override
    public ProductInventoryDTO getProductInventory(long id) {
        ProductInventory productInventory = productInventoryRepository.findById(id).orElse(null);

        if (Objects.isNull(productInventory)) {
            return null;
        }
        return productInventoryConvert.toDto(productInventory);
    }

}
