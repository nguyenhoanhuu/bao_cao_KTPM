package vn.edu.iuh.fit.se.thubonggiareapis.entity;

import javax.persistence.*;

@Entity
@IdClass(OrderDetailPK.class)
@Table(name = "orderDetails")
public class OrderDetail {
    @Id
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(nullable = false, updatable = false)
    private int quantity;

    @Column(nullable = false, updatable = false)
    private double cost;

    @Column(nullable = false, updatable = false)
    private double totalLine;

    public OrderDetail() {
        super();
    }

    public OrderDetail(Order order, Product product, int quantity, double cost, double totalLine) {
        super();
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.cost = cost;
        this.totalLine = totalLine;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
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

    public double getTotalLine() {
        return totalLine;
    }

    public void setTotalLine(double totalLine) {
        this.totalLine = totalLine;
    }

    @Override
    public String toString() {
        return "OrderDetail [order=" + order + ", product=" + product + ", quantity=" + quantity + ", cost=" + cost
                + ", totalLine=" + totalLine + "]";
    }


}
