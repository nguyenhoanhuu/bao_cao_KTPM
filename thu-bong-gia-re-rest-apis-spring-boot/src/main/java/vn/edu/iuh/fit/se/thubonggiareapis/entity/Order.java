package vn.edu.iuh.fit.se.thubonggiareapis.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private LocalDateTime orderDate;

    @Column(nullable = false)
    private double total;

    @Column(nullable = false)
    private double discount;

    @Column(nullable = false)
    private double shippingCost;

    @Column(nullable = false)
    private double subTotal;

//	@Column(nullable = false, updatable = false) //note
//	private String promotionCode;

    @ManyToOne
    @JoinColumn(name = "promotion_code")
    private Promotion promotion;


    @Column(nullable = false, columnDefinition = "NVARCHAR(500)")
    private String shippingAddress;

    @Column(columnDefinition = "NVARCHAR(1000)")
    private String shippingNote;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User approvedBy;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails = new ArrayList<>();

    public Order() {
        super();
    }

    public Order(long id) {
        this.id = id;
    }

    public Order(LocalDateTime orderDate, double total, double discount, double shippingCost, double subTotal, Promotion promotion, String shippingAddress, String shippingNote, Customer customer, List<OrderDetail> orderDetails) {
        this.orderDate = orderDate;
        this.total = total;
        this.discount = discount;
        this.shippingCost = shippingCost;
        this.subTotal = subTotal;
        this.promotion = promotion;
        this.shippingAddress = shippingAddress;
        this.shippingNote = shippingNote;
        this.customer = customer;
        this.orderDetails = orderDetails;
    }

    public Order(long id, LocalDateTime orderDate, double total, double discount, double shippingCost, double subTotal, Promotion promotion, String shippingAddress, String shippingNote, Customer customer, List<OrderDetail> orderDetails) {
        this.id = id;
        this.orderDate = orderDate;
        this.total = total;
        this.discount = discount;
        this.shippingCost = shippingCost;
        this.subTotal = subTotal;
        this.promotion = promotion;
        this.shippingAddress = shippingAddress;
        this.shippingNote = shippingNote;
        this.customer = customer;
        this.orderDetails = orderDetails;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", total=" + total +
                ", discount=" + discount +
                ", shippingCost=" + shippingCost +
                ", subTotal=" + subTotal +
                ", promotion=" + promotion +
                ", shippingAddress='" + shippingAddress + '\'' +
                ", shippingNote='" + shippingNote + '\'' +
                ", customer=" + customer +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
