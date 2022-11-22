package vn.edu.iuh.fit.se.thubonggiareapis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {
        SecurityAutoConfiguration.class
})
public class ThuBongGiaReRestApisSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThuBongGiaReRestApisSpringBootApplication.class, args);
    }


}
