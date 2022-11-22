package vn.edu.iuh.fit.se.thubonggiareapis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.CartDetail;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.CartDetailPK;

import java.util.List;

@Repository
public interface CartDetailRepository extends JpaRepository<CartDetail, CartDetailPK> {
    void deleteByCart_TokenAndProduct_Id(@Param("cart_id") String cartId, @Param("product_id") Long productId);

    void deleteAllByCart_Token(@Param("cart_id") String cartId);

    List<CartDetail> findCartDetailByCartToken(@Param("cart_id") String token);
}
