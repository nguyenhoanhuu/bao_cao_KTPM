package vn.edu.iuh.fit.se.thubonggiareapis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, String> {
    boolean existsByToken(String token);
}
