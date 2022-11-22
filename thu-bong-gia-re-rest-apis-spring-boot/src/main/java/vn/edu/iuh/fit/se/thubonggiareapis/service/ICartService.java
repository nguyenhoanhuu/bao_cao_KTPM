package vn.edu.iuh.fit.se.thubonggiareapis.service;

import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.CartDTO;

@Service
public interface ICartService {
    void createCart(CartDTO cartDTO);

    CartDTO getCartByToken(String token);
}
