package vn.edu.iuh.fit.se.thubonggiareapis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.edu.iuh.fit.se.thubonggiareapis.converter.CartDetailConverter;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.CartDetailDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.ProductInventoryDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.CartDetail;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.CartDetailPK;
import vn.edu.iuh.fit.se.thubonggiareapis.repository.CartDetailRepository;
import vn.edu.iuh.fit.se.thubonggiareapis.service.ICartDetailService;
import vn.edu.iuh.fit.se.thubonggiareapis.service.IProductInventoryService;

import java.util.List;

@Service
public class CartDetailServiceImpl implements ICartDetailService {

    @Autowired
    private CartDetailRepository cartDetailRepository;

    @Autowired
    private CartDetailConverter cartDetailConverter;

    @Autowired
    private IProductInventoryService productInventoryService;

    @Override
    public boolean addProductsToCart(CartDetailDTO cartDetailDTO) {
        ProductInventoryDTO productInventoryDTO = productInventoryService.getProductInventory(cartDetailDTO.getProduct());
        if (productInventoryDTO.getQuantity() - cartDetailDTO.getQuantity() > 0) {
            boolean isExisted = cartDetailRepository.existsById(new CartDetailPK(cartDetailDTO.getCart(), cartDetailDTO.getProduct()));
            if (isExisted) {
                CartDetail cartDetail = cartDetailRepository.getById(new CartDetailPK(cartDetailDTO.getCart(), cartDetailDTO.getProduct()));
                cartDetail.setQuantity(cartDetail.getQuantity() + cartDetailDTO.getQuantity());
                cartDetail.setTotalLine(cartDetail.getQuantity() * cartDetail.getCost());
                cartDetailRepository.save(cartDetail);
                return true;
            }
            CartDetail cartDetail = cartDetailConverter.toEntity(cartDetailDTO);
            System.out.println(cartDetail);
            cartDetailRepository.save(cartDetail);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public void deleteProductWithToken(String token, long productId) {
        cartDetailRepository.deleteByCart_TokenAndProduct_Id(token, productId);
    }

    @Override
    @Transactional
    public void deleteAllProductsByToken(String token) {
        cartDetailRepository.deleteAllByCart_Token(token);
    }


    @Override
    public List<CartDetailDTO> getCartDetailsByToken(String token) {
        List<CartDetail> cartDetails = cartDetailRepository.findCartDetailByCartToken(token);
        return cartDetailConverter.toDtos(cartDetails);
    }
}
