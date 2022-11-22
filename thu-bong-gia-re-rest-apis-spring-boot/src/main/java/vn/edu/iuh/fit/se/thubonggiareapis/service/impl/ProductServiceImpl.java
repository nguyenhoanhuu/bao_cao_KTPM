package vn.edu.iuh.fit.se.thubonggiareapis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.se.thubonggiareapis.converter.ProductConverter;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.ProductDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.ProductInventoryDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.Product;
import vn.edu.iuh.fit.se.thubonggiareapis.repository.ProductRepository;
import vn.edu.iuh.fit.se.thubonggiareapis.service.IProductInventoryService;
import vn.edu.iuh.fit.se.thubonggiareapis.service.IProductService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductConverter productConverter;

    @Autowired
    private IProductInventoryService productInventoryService;

    @Override
    public ProductDTO addProduct(ProductDTO productDTO) {
        Product product = productConverter.toEntity(productDTO);
        product = productRepository.save(product);

        ProductInventoryDTO productInventoryDTO = new ProductInventoryDTO(0, productDTO.getCost(), LocalDateTime.now(), product.getId());

        productInventoryService.addProductInventory(productInventoryDTO);

        return productConverter.toDto(product);
    }

    @Override
    public List<ProductDTO> getProducts() {
        List<ProductDTO> productDTOs = new ArrayList<>();
        List<Product> products = productRepository.findAll();

        if (products.size() == 0) {
            return new ArrayList<>();
        }
        for (Product product : products) {
            ProductDTO productDTO = productConverter.toDto(product);
            productDTOs.add(productDTO);
        }

        return productDTOs;
    }

    @Override
    public List<ProductDTO> getProductsByIds(List<Long> ids) {
        List<Product> products = productRepository.findAllById(ids);
        List<ProductDTO> productDTOS = new ArrayList<>();

        if (products.size() == 0) {
            return new ArrayList<>();
        }

        products.forEach(product -> {
            productDTOS.add(productConverter.toDto(product));
        });

        return productDTOS;
    }

    @Override
    public ProductDTO getProductById(Long productId) {
        Product product = productRepository.findById(productId).orElse(null);
        if (Objects.isNull(product)) {
            return null;
        }
        return productConverter.toDto(product);
    }

    @Override
    public List<ProductDTO> findProductByName(String keyword) {
        List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
        List<Product> products = productRepository.findByNameContaining(keyword);
        for (Product product : products) {
            ProductDTO productDTO = productConverter.toDto(product);
            productDTOs.add(productDTO);
        }
        return productDTOs;
    }

    @Override
    public List<ProductDTO> getProductSortByCost(String type) {
        List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
        List<Product> products;
        if (type.equals("ASC"))
            products = productRepository.findAll(Sort.by(Sort.Direction.ASC, "cost"));
        else
            products = productRepository.findAll(Sort.by(Sort.Direction.DESC, "cost"));
        for (Product product : products) {
            ProductDTO productDTO = productConverter.toDto(product);
            productDTOs.add(productDTO);
        }
        return productDTOs;
    }

    @Override
    public void updateProduct(ProductDTO productDTO) {
        Product product = productConverter.toEntity(productDTO);
        productRepository.save(product);
    }

    @Override
    public List<String> getCategories() {
        return productRepository.getCategories();
    }

    @Override
    public List<ProductDTO> getProductsByCategory(String category) {
        return productConverter.toDtos(productRepository.findAllByCategory(category));
    }

    @Override
    public Long getTotalProduct() {
        return productRepository.count();
    }

    @Override
    public Long getTotalCategory() {
        return (long) getCategories().size();
    }

}
