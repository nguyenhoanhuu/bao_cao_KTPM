package vn.edu.iuh.fit.se.thubonggiareapis.service;

import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.UserDTO;

import java.util.List;

@Service
public interface IUserService {
    UserDTO addUser(UserDTO userDTO);

    List<UserDTO> getUsers();

    UserDTO getUser(long id);

    void updateUser(UserDTO userDTO);

    void deleteUser(long id);

    UserDTO getUserByEmail(String email);
}
