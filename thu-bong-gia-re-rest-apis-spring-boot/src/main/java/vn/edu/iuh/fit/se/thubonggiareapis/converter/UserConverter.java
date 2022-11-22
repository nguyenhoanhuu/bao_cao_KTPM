package vn.edu.iuh.fit.se.thubonggiareapis.converter;

import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.UserDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.User;

@Component
public class UserConverter {
    public User toEntity(UserDTO userDTO) {
        User user = new User();
        if (userDTO.getId() != 0) {
            user.setId(userDTO.getId());
        }
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setPassword(userDTO.getPassword());

        return user;
    }

    public UserDTO toDto(User user) {
        UserDTO userDTO = new UserDTO();

        if (user.getId() != 0) {
            userDTO.setId(user.getId());
        }

        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setPassword(user.getPassword());

        return userDTO;
    }
}
