package vn.edu.iuh.fit.se.thubonggiareapis.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "carts")
public class Cart {

    @Id
    private String token;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false, updatable = false)
    private LocalDateTime expiredAt;

    @OneToMany(mappedBy = "cart")
    private List<CartDetail> cartDetails = new ArrayList<CartDetail>();

    public Cart() {
        super();
    }

    public Cart(String token) {
        super();
        this.token = token;
    }

    public Cart(String token, LocalDateTime createdAt, LocalDateTime expiredAt, List<CartDetail> cartDetails) {
        super();
        this.token = token;
        this.createdAt = createdAt;
        this.expiredAt = expiredAt;
        this.cartDetails = cartDetails;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getExpiredAt() {
        return expiredAt;
    }

    public void setExpiredAt(LocalDateTime expiredAt) {
        this.expiredAt = expiredAt;
    }

    public List<CartDetail> getCartDetails() {
        return cartDetails;
    }

    public void setCartDetails(List<CartDetail> cartDetails) {
        this.cartDetails = cartDetails;
    }

    @Override
    public String toString() {
        return "Cart [token=" + token + ", createdAt=" + createdAt + ", expiredAt=" + expiredAt + ", cartDetails="
                + cartDetails + "]";
    }


}
