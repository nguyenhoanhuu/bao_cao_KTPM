package vn.edu.iuh.fit.se.thubonggiareapis.service;

import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.ProductDTO;

import java.util.List;

@Service
public interface IProductService {
    ProductDTO addProduct(ProductDTO productDTO);

    List<ProductDTO> getProducts();

    List<ProductDTO> getProductsByIds(List<Long> ids);

    ProductDTO getProductById(Long productId);

    List<ProductDTO> findProductByName(String keyword);

    List<ProductDTO> getProductSortByCost(String type);

    void updateProduct(ProductDTO productDTO);

    List<String> getCategories();

    List<ProductDTO> getProductsByCategory(String category);

    Long getTotalProduct();

    Long getTotalCategory();
}
