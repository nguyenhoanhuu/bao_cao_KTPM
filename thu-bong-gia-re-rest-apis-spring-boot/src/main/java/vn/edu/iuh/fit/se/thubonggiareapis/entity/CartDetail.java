package vn.edu.iuh.fit.se.thubonggiareapis.entity;

import javax.persistence.*;

@Entity
@IdClass(CartDetailPK.class)
@Table(name = "cartDetails")
public class CartDetail {

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Id
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    private int quantity;
    private double cost;
    private double totalLine;

    public CartDetail() {
        super();
    }

    public CartDetail(Product product, Cart cart, int quantity, double cost, double totalLine) {
        super();
        this.product = product;
        this.cart = cart;
        this.quantity = quantity;
        this.cost = cost;
        this.totalLine = totalLine;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
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
        return "CartDetail [product=" + product + ", cart=" + cart + ", quantity=" + quantity + ", cost=" + cost
                + ", totalLine=" + totalLine + "]";
    }


}
