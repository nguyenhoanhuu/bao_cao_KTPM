package vn.edu.iuh.fit.se.thubonggiareapis.dto;

import java.time.LocalDateTime;
import java.util.List;

public class CartDTO {
    private String token;
    private LocalDateTime createdAt;
    private LocalDateTime expiredAt;

    private List<CartDetailDTO> cartDetails;

    public CartDTO() {
        super();
    }

    public CartDTO(String token) {
        super();
        this.token = token;
    }


    public CartDTO(String token, LocalDateTime createdAt, LocalDateTime expiredAt, List<CartDetailDTO> cartDetails) {
        super();
        this.token = token;
        this.createdAt = createdAt;
        this.expiredAt = expiredAt;
        this.cartDetails = cartDetails;
    }


    public LocalDateTime getExpiredAt() {
        return expiredAt;
    }


    public void setExpiredAt(LocalDateTime expiredAt) {
        this.expiredAt = expiredAt;
    }


    public String getToken() {
        return token;
    }


    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public List<CartDetailDTO> getCartDetails() {
        return cartDetails;
    }

    public void setCartDetails(List<CartDetailDTO> cartDetails) {
        this.cartDetails = cartDetails;
    }

    @Override
    public String toString() {
        return "CartDTO{" +
                "token='" + token + '\'' +
                ", createdAt=" + createdAt +
                ", expiredAt=" + expiredAt +
                ", cartDetails=" + cartDetails +
                '}';
    }
}
