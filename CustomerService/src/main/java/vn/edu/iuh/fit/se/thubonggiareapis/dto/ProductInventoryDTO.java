package vn.edu.iuh.fit.se.thubonggiareapis.dto;

import java.time.LocalDateTime;

public class ProductInventoryDTO extends AbstractDTO {
    private int quantity;
    private double cost;
    private LocalDateTime createdAt;
    private Long product;

    public ProductInventoryDTO() {
        super();
    }

    public ProductInventoryDTO(long id, int quantity) {
        super(id);
        this.quantity = quantity;
    }

    public ProductInventoryDTO(int quantity, double cost, LocalDateTime createdAt, Long product) {
        super();
        this.quantity = quantity;
        this.cost = cost;
        this.createdAt = createdAt;
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Long getProduct() {
        return product;
    }

    public void setProduct(Long product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductInventoryDTO [quantity=" + quantity + ", cost=" + cost + ", createdAt=" + createdAt
                + ", product=" + product + "]";
    }


}
