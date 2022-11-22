package vn.edu.iuh.fit.se.thubonggiareapis.dto;

import java.io.Serializable;

public class CartDetailDTO implements Serializable {
    private long product;
    private String cart;
    private int quantity;
    private double cost;
    private double totalLine;

    public CartDetailDTO() {
    }

    public CartDetailDTO(String cart, int quantity, double cost, double totalLine) {
        this.cart = cart;
        this.quantity = quantity;
        this.cost = cost;
        this.totalLine = totalLine;
    }

    public CartDetailDTO(long product, String cart, int quantity, double cost, double totalLine) {
        this.product = product;
        this.cart = cart;
        this.quantity = quantity;
        this.cost = cost;
        this.totalLine = totalLine;
    }

    public long getProduct() {
        return product;
    }

    public String getCart() {
        return cart;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getCost() {
        return cost;
    }

    public double getTotalLine() {
        return totalLine;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "productProduct = " + product + ", " +
                "cartCart = " + cart + ", " +
                "quantity = " + quantity + ", " +
                "cost = " + cost + ", " +
                "totalLine = " + totalLine + ")";
    }
}
