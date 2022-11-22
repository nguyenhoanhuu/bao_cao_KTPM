package vn.edu.iuh.fit.se.thubonggiareapis.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "promotions")
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false, columnDefinition = "VARCHAR(30)")
    private String promotionCode; //note

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User createdBy;

    @Column(nullable = false, updatable = false)
    private LocalDateTime expiredDate;

    @Column(nullable = false, updatable = false)
    private double deducted;

    @Column(nullable = false)
    private int limit;

    @OneToMany(mappedBy = "promotion")
    private List<Order> orders = new ArrayList<Order>();

    public Promotion() {
        super();
    }

    public Promotion(long id) {
        super();
        this.id = id;
    }

    public Promotion(String promotionCode) {
        this.promotionCode = promotionCode;
    }

    public Promotion(String promotionCode, User createdBy, LocalDateTime expiredDate, double deducted, int limit) {
        super();
        this.promotionCode = promotionCode;
        this.createdBy = createdBy;
        this.expiredDate = expiredDate;
        this.deducted = deducted;
        this.limit = limit;
    }

    public Promotion(long id, String promotionCode, User createdBy, LocalDateTime expiredDate, double deducted,
                     int limit) {
        super();
        this.id = id;
        this.promotionCode = promotionCode;
        this.createdBy = createdBy;
        this.expiredDate = expiredDate;
        this.deducted = deducted;
        this.limit = limit;
    }

    public String getPromotionCode() {
        return promotionCode;
    }

    public void setPromotionCode(String promotionCode) {
        this.promotionCode = promotionCode;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(LocalDateTime expiredDate) {
        this.expiredDate = expiredDate;
    }

    public double getDeducted() {
        return deducted;
    }

    public void setDeducted(double deducted) {
        this.deducted = deducted;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Promotion [id=" + id + ", promotionCode=" + promotionCode + ", createdBy=" + createdBy
                + ", expiredDate=" + expiredDate + ", deducted=" + deducted + ", limit=" + limit + "]";
    }


}
