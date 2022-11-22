package vn.edu.iuh.fit.se.thubonggiareapis.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CartDetailPK implements Serializable {
    private String cart;
    private Long product;

    public CartDetailPK() {
        super();
    }

    public CartDetailPK(String cart, Long product) {
        this.cart = cart;
        this.product = product;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cart, product);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CartDetailPK other = (CartDetailPK) obj;
        return Objects.equals(cart, other.cart) && Objects.equals(product, other.product);
    }


}
