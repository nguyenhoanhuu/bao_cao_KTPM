package vn.edu.iuh.fit.se.thubonggiareapis.dto;

public class UserDTO extends AbstractDTO {
    private String name;
    private String email;
    private String phoneNumber;
    private String password;

    public UserDTO() {
        super();
    }

    public UserDTO(String name, String email, String phoneNumber, String password) {
        super();
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDTO [name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber + ", password=" + password
                + "]";
    }


}
