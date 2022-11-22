package vn.edu.iuh.fit.se.thubonggiareapis.dto;

public class ProductDTO extends AbstractDTO {
    private final String measuredUnit = "cm";
    private String name;
    private String description;
    private String origin;
    private String brand;
    private int rate;
    private String category;
    private String material;
    private double weight;
    private double height;
    private double width;
    private String image;
    private double cost;

    public ProductDTO() {
        super();
    }

    public ProductDTO(String name, String description, String origin, String brand, int rate, String category,
                      String material, double weight, double height, double width, String image, double cost) {
        super();
        this.name = name;
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
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getMeasuredUnit() {
        return measuredUnit;
    }

    @Override
    public String toString() {
        return "ProductDTO [name=" + name + ", description=" + description + ", origin=" + origin + ", brand=" + brand
                + ", rate=" + rate + ", category=" + category + ", material=" + material + ", weight=" + weight
                + ", height=" + height + ", width=" + width + ", measuredUnit=" + measuredUnit + ", image=" + image
                + ", cost=" + cost + "]";
    }


}
