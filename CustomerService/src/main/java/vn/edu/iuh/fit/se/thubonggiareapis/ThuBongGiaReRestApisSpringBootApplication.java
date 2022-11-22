package vn.edu.iuh.fit.se.thubonggiareapis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCaching
public class ThuBongGiaReRestApisSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThuBongGiaReRestApisSpringBootApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
