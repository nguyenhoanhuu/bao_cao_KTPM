package vn.edu.iuh.fit.se.thubonggiareapis.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderDetailPK implements Serializable {
    private Long order;
    private Long product;

    public OrderDetailPK() {
        super();
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, product);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OrderDetailPK other = (OrderDetailPK) obj;
        return Objects.equals(order, other.order) && Objects.equals(product, other.product);
    }


}
