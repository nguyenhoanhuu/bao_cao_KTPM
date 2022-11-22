package vn.edu.iuh.fit.se.thubonggiareapis.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
public class Product implements Serializable {

    @Column
    private final String measuredUnit = "cm";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, columnDefinition = "NVARCHAR(255)")
    private String name;
    @Column
    private double cost;
    @Column(columnDefinition = "NVARCHAR(500)")
    private String description;
    @Column(columnDefinition = "NVARCHAR(255)")
    private String origin;
    @Column(columnDefinition = "NVARCHAR(255)")
    private String brand;
    @Column
    private int rate;
    @Column(columnDefinition = "NVARCHAR(255)")
    private String category;
    @Column(columnDefinition = "NVARCHAR(255)")
    private String material;
    @Column
    private double weight;
    @Column
    private double height;
    @Column
    private double width;
    @Column
    private String image;

    @OneToMany(mappedBy = "product")
    private List<CartDetail> cartDetails = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails = new ArrayList<>();

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private ProductInventory productInventory;

    public Product() {
        super();
    }

    public Product(long id) {
        super();
        this.id = id;
    }

    public Product(String name, double cost, String description, String origin, String brand, int rate, String category,
                   String material, double weight, double height, double width, String image) {
        super();
        this.name = name;
        this.cost = cost;
        this.description = description;
        this.origin = origin;
        this.brand = brand;
        this.rate = rate;
        this.category = category;
        this.material = material;
        this.weight = weight;
        this.height = height;
        this.width = width;
        this.image = image;
    }

    public Product(String name, double cost, String description, String origin, String brand, int rate, String category,
                   String material, double weight, double height, double width, String image,
                   ProductInventory productInventory) {
        super();
        this.name = name;
        this.cost = cost;
        this.description = description;
        this.origin = origin;
        this.brand = brand;
        this.rate = rate;
        this.category = category;
        this.material = material;
        this.weight = weight;
        this.height = height;
        this.width = width;
        this.image = image;
        this.productInventory = productInventory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<CartDetail> getCartDetails() {
        return cartDetails;
    }

    public void setCartDetails(List<CartDetail> cartDetails) {
        this.cartDetails = cartDetails;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public ProductInventory getProductInventory() {
        return productInventory;
    }

    public void setProductInventory(ProductInventory productInventory) {
        this.productInventory = productInventory;
    }

    public long getId() {
        return id;
    }

    public String getMeasuredUnit() {
        return measuredUnit;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", cost=" + cost + ", description=" + description + ", origin="
                + origin + ", brand=" + brand + ", rate=" + rate + ", category=" + category + ", material=" + material
                + ", weight=" + weight + ", height=" + height + ", width=" + width + ", measuredUnit=" + measuredUnit
                + ", image=" + image + "]";
    }


}
