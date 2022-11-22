package vn.edu.iuh.fit.se.thubonggiareapis.dto;

import java.time.LocalDateTime;
import java.util.List;

public class OrderDTO extends AbstractDTO {
    private LocalDateTime orderDate;
    private double total;
    private double discount;
    private double shippingCost;

    private String promotionCode;
    private double subTotal;
    private String shippingAddress;
    private String shippingNote;

    private Long customer;

    private List<OrderDetailDTO> details;

    public OrderDTO() {
        super();
    }

    public OrderDTO(LocalDateTime orderDate, double total, double discount, double shippingCost, double subTotal, String promotionCode, String shippingAddress, String shippingNote, Long customer, List<OrderDetailDTO> details) {
        super();
        this.orderDate = orderDate;
        this.total = total;
        this.discount = discount;
        this.shippingCost = shippingCost;
        this.subTotal = subTotal;
        this.promotionCode = promotionCode;
        this.shippingAddress = shippingAddress;
        this.shippingNote = shippingNote;
        this.customer = customer;
        this.details = details;
    }


    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }

    public String getPromotionCode() {
        return promotionCode;
    }

    public void setPromotionCode(String promotionCode) {
        this.promotionCode = promotionCode;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getShippingNote() {
        return shippingNote;
    }

    public void setShippingNote(String shippingNote) {
        this.shippingNote = shippingNote;
    }

    public Long getCustomer() {
        return customer;
    }

    public void setCustomer(Long customer) {
        this.customer = customer;
    }

    public List<OrderDetailDTO> getDetails() {
        return details;
    }

    public void setDetails(List<OrderDetailDTO> details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderDate=" + orderDate +
                ", total=" + total +
                ", discount=" + discount +
                ", shippingCost=" + shippingCost +
                ", promotionCode='" + promotionCode + '\'' +
                ", subTotal=" + subTotal +
                ", shippingAddress='" + shippingAddress + '\'' +
                ", shippingNote='" + shippingNote + '\'' +
                ", customer=" + customer +
                ", details=" + details +
                '}';
    }
}
