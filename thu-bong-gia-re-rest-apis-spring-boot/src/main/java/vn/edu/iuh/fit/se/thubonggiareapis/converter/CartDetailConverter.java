package vn.edu.iuh.fit.se.thubonggiareapis.converter;

import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.CartDetailDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.Cart;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.CartDetail;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.Product;

import java.util.ArrayList;
import java.util.List;

@Component
public class CartDetailConverter {
    public CartDetail toEntity(CartDetailDTO cartDetailDTO) {
        return new CartDetail(
                new Product(cartDetailDTO.getProduct()),
                new Cart(cartDetailDTO.getCart()),
                cartDetailDTO.getQuantity(),
                cartDetailDTO.getCost(),
                cartDetailDTO.getQuantity() * cartDetailDTO.getCost()
        );
    }

    public CartDetailDTO toDto(CartDetail cartDetail) {
        return new CartDetailDTO(
                cartDetail.getProduct().getId(),
                cartDetail.getCart().getToken(),
                cartDetail.getQuantity(),
                cartDetail.getCost(),
                cartDetail.getQuantity() * cartDetail.getCost()
        );
    }

    public List<CartDetailDTO> toDtos(List<CartDetail> cartDetails) {
        List<CartDetailDTO> cartDetailDTOS = new ArrayList<>();
        cartDetails.forEach(cartDetail -> {
            cartDetailDTOS.add(toDto(cartDetail));
        });
        return cartDetailDTOS;
    }
}
