package vn.edu.iuh.fit.se.thubonggiareapis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.CartDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.CartDetailDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.service.ICartDetailService;
import vn.edu.iuh.fit.se.thubonggiareapis.service.ICartService;

import java.util.HashMap;
import java.util.Objects;

@RestController
@RequestMapping("/carts")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CartController {

    @Autowired
    private ICartService cartService;

    @Autowired
    private ICartDetailService cartDetailService;

    @PostMapping(value = {
            "", "/"
    }, consumes = {
            "application/json",
            "application/x-www-form-urlencoded"
    })
    public ResponseEntity<String> createCart(@RequestBody CartDTO cartDTO) {
        cartService.createCart(cartDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping(value = {"detail", "/detail"}, consumes = {
            "application/json",
            "application/x-www-form-urlencoded"
    })
    public ResponseEntity<CartDetailDTO> addProductToCart(@RequestBody CartDetailDTO cartDetailDTO) {
        try {
            boolean result = cartDetailService.addProductsToCart(cartDetailDTO);
            if (result)
                return new ResponseEntity<>(HttpStatus.CREATED);
            else return new ResponseEntity<>(HttpStatus.CONFLICT);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = {
            "detail", "/detail"
    }, consumes = {
            "application/json",
            "application/x-www-form-urlencoded"
    })
    public ResponseEntity<String> deleteProductInCart(@RequestBody HashMap<String, Object> request) {
        try {
            cartDetailService.deleteProductWithToken(
                    (String) request.get("token"),
                    Long.valueOf((Integer) request.get("product"))
            );
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = {
            "detail/{token}",
            "detail/{token}/"
    })
    public ResponseEntity<HashMap<String, Object>> deleteAllItemInCart(@PathVariable String token) {
        try {
            cartDetailService.deleteAllProductsByToken(token);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping(value = {"{token}", "/{token}"})
    public ResponseEntity<CartDTO> getCartByToken(@PathVariable String token) {
        try {
            CartDTO cartDTO = cartService.getCartByToken(token);
            if (Objects.isNull(cartDTO)) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(cartDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
