package vn.edu.iuh.fit.se.thubonggiareapis.dto;

public class CustomerDTO extends AbstractDTO {
    private String name;
    private String email;
    private String phoneNumber;

    public CustomerDTO() {
        // TODO Auto-generated constructor stub
    }

    public CustomerDTO(String name, String email, String phoneNumber) {
        super();
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
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

    @Override
    public String toString() {
        return "CustomerDTO [name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber + "]";
    }


}
