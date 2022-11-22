package vn.edu.iuh.fit.se.thubonggiareapis.converter;

import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.CartDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.Cart;

import java.util.ArrayList;

@Component
public class CartConverter {
    public Cart toEntity(CartDTO cartDTO) {
        Cart cart = new Cart(cartDTO.getToken());
        cart.setCreatedAt(cartDTO.getCreatedAt());
        cart.setExpiredAt(cartDTO.getExpiredAt());
        cart.setCartDetails(cartDTO.getCartDetails().size() > 0 ? cart.getCartDetails() : new ArrayList<>());
        return cart;
    }

    public CartDTO toDto(Cart cart) {
        return new CartDTO(
                cart.getToken(),
                cart.getCreatedAt(),
                cart.getExpiredAt(),
                new ArrayList<>()
        );
    }
}
