package vn.edu.iuh.fit.se.thubonggiareapis.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "productInventory")
public class ProductInventory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false, updatable = false)
    private double cost;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @OneToOne
    @MapsId
    @JoinColumn(name = "product_id")
    private Product product;

    public ProductInventory() {
        super();
    }

    public ProductInventory(int quantity, double cost, LocalDateTime createdAt) {
        super();
        this.quantity = quantity;
        this.cost = cost;
        this.createdAt = createdAt;
    }

    public ProductInventory(long id, int quantity, double cost, LocalDateTime createdAt) {
        super();
        this.id = id;
        this.quantity = quantity;
        this.cost = cost;
        this.createdAt = createdAt;
    }

    public ProductInventory(long id) {
        super();
        this.id = id;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ProductInventory [id=" + id + ", quantity=" + quantity + ", cost=" + cost + ", createdAt=" + createdAt
                + "]";
    }


}
