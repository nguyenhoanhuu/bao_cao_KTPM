package vn.edu.iuh.fit.se.thubonggiareapis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.se.thubonggiareapis.converter.CartConverter;
import vn.edu.iuh.fit.se.thubonggiareapis.converter.CartDetailConverter;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.CartDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.Cart;
import vn.edu.iuh.fit.se.thubonggiareapis.repository.CartRepository;
import vn.edu.iuh.fit.se.thubonggiareapis.service.ICartDetailService;
import vn.edu.iuh.fit.se.thubonggiareapis.service.ICartService;

import java.util.Objects;

@Service
public class CartServiceImpl implements ICartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartConverter cartConverter;

    @Autowired
    private ICartDetailService cartDetailService;

    @Autowired
    private CartDetailConverter cartDetailConverter;

    @Override
    public void createCart(CartDTO cartDTO) {
        Cart cart = cartConverter.toEntity(cartDTO);
        cartRepository.save(cart);
    }

    @Override
    public CartDTO getCartByToken(String token) {
        Cart cart = cartRepository.findById(token).orElse(null);
        if (Objects.isNull(cart)) {
            return null;
        }
        CartDTO cartDTO = cartConverter.toDto(cart);
        cartDTO.setCartDetails(cartDetailService.getCartDetailsByToken(token));
        System.out.println(cartDTO);
        return cartDTO;
    }
}
