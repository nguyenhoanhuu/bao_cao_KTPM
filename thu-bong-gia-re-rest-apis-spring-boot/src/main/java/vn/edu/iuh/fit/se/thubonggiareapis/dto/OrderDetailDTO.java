package vn.edu.iuh.fit.se.thubonggiareapis.dto;

public class OrderDetailDTO {
    private long order;
    private long product;
    private int quantity;
    private double cost;

    private double totalLine;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(long order, long product, int quantity, double cost, double totalLine) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.cost = cost;
        this.totalLine = totalLine;
    }

    public long getOrder() {
        return order;
    }

    public void setOrder(long order) {
        this.order = order;
    }

    public long getProduct() {
        return product;
    }

    public void setProduct(long product) {
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
        return "OrderDetailDTO{" +
                "order=" + order +
                ", product=" + product +
                ", quantity=" + quantity +
                ", cost=" + cost +
                ", totalLine=" + totalLine +
                '}';
    }
}
