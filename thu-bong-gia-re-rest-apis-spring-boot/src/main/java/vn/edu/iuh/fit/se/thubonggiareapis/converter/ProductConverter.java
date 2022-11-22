package vn.edu.iuh.fit.se.thubonggiareapis.converter;

import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.ProductDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.Product;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductConverter {

    public Product toEntity(ProductDTO productDTO) {
        Product product;
        if (productDTO.getId() != 0) {
            product = new Product(productDTO.getId());
        } else {
            product = new Product();
        }

        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setOrigin(productDTO.getOrigin());
        product.setBrand(productDTO.getBrand());
        product.setRate(productDTO.getRate());
        product.setCategory(productDTO.getCategory());
        product.setMaterial(productDTO.getMaterial());
        product.setWeight(productDTO.getWeight());
        product.setHeight(productDTO.getHeight());
        product.setWidth(productDTO.getWidth());
        product.setImage(productDTO.getImage());
        product.setCost(productDTO.getCost());
        return product;
    }

    public ProductDTO toDto(Product product) {
        ProductDTO productDTO = new ProductDTO();
        if (product.getId() != 0) {
            productDTO.setId(product.getId());
            ;
        }

        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setOrigin(product.getOrigin());
        productDTO.setBrand(product.getBrand());
        productDTO.setRate(product.getRate());
        productDTO.setCategory(product.getCategory());
        productDTO.setMaterial(product.getMaterial());
        productDTO.setWeight(product.getWeight());
        productDTO.setHeight(product.getHeight());
        productDTO.setWidth(product.getWidth());
        productDTO.setImage(product.getImage());
        productDTO.setCost(product.getCost());


        return productDTO;
    }

    public List<ProductDTO> toDtos(List<Product> products) {
        List<ProductDTO> productDTOS = new ArrayList<>();
        products.forEach(product -> {
            productDTOS.add(this.toDto(product));
        });
        return productDTOS;
    }

}
