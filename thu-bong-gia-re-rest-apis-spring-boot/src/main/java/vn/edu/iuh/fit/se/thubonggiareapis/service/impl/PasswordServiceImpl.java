package vn.edu.iuh.fit.se.thubonggiareapis.service.impl;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.se.thubonggiareapis.service.IPasswordService;

@Service
public class PasswordServiceImpl implements IPasswordService {
    @Override
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public boolean checkPassword(String rawPassword, String encryptedPassword) {
        return new BCryptPasswordEncoder().matches(rawPassword, encryptedPassword);
    }
}
