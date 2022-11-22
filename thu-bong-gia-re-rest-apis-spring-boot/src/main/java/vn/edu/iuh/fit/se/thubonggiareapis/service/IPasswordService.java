package vn.edu.iuh.fit.se.thubonggiareapis.service;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public interface IPasswordService {
    @Bean
    PasswordEncoder passwordEncoder();

    boolean checkPassword(String password, String encrypted);
}
