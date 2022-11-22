package vn.edu.iuh.fit.se.thubonggiareapis.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, columnDefinition = "NVARCHAR(255)")
    private String name;

    @Column(nullable = false, unique = true, columnDefinition = "VARCHAR(50)")
    private String email;

    @Column(nullable = false, unique = true, columnDefinition = "VARCHAR(10)")
    private String phoneNumber;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders = new ArrayList<Order>();

    public Customer() {
        super();
    }

    public Customer(long id) {
        super();
        this.id = id;
    }

    public Customer(String name, String email, String phoneNumber) {
        super();
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Customer(long id, String name, String email, String phoneNumber) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber + "]";
    }


}
