package vn.edu.iuh.fit.se.thubonggiareapis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.UserDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.service.IPasswordService;
import vn.edu.iuh.fit.se.thubonggiareapis.service.IUserService;

import java.util.HashMap;
import java.util.Objects;

@RestController
@RequestMapping("/creds")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CredentialsController {

    @Autowired
    private IPasswordService passwordService;

    @Autowired
    private IUserService userService;

    @PostMapping(value = {
            "", "/"
    }, consumes = {
            "application/json",
            "application/x-www-form-urlencoded"
    })
    public ResponseEntity<HashMap<String, Object>> requestLogin(@RequestBody HashMap<String, Object> creds) {
        HashMap<String, Object> response = new HashMap<>();
        try {
            UserDTO userDTO = userService.getUserByEmail(creds.get("email").toString());

            if (!Objects.isNull(userDTO)) {
                if (passwordService.checkPassword(creds.get("password").toString(), userDTO.getPassword())) {
                    response.put("userId", userDTO.getId());
                    return new ResponseEntity<>(response, HttpStatus.OK);
                }

                response.put("message", "Email or Password does not match on our server");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            response.put("message", "Email or Password does not match on our server");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = {
            "", "/"
    }, consumes = {
            "application/json",
            "application/x-www-form-urlencoded"
    })
    public ResponseEntity<HashMap<String, Object>> requestChangePassword(@RequestBody HashMap<String, Object> creds) {
        HashMap<String, Object> response = new HashMap<>();
        try {
            UserDTO userDTO = userService.getUserByEmail(creds.get("email").toString());

            if (Objects.isNull(userDTO)) {
                response.put("status", "error");
                response.put("message", "Email does not match on our server");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }

            String currentPassword = creds.get("currentPassword").toString();
            String newPassword = creds.get("newPassword").toString();


            if (Objects.isNull(currentPassword) || Objects.isNull(newPassword)) {
                response.put("status", "error");
                response.put("message", "Current password and new password are required");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }

            if (currentPassword.isEmpty() || newPassword.isEmpty()) {
                response.put("status", "error");
                response.put("message", "Current password and new password are required");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }

            if (!passwordService.checkPassword(currentPassword, userDTO.getPassword())) {
                response.put("status", "error");
                response.put("message", "Your password does not match on our server");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }

            if (passwordService.checkPassword(
                    newPassword, userDTO.getPassword()
            )) {
                response.put("status", "error");
                response.put("message", "New password is the same as your current password");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }

            userDTO.setPassword(newPassword);
            userService.updateUser(userDTO);
            response.put("status", "success");
            response.put("message", "Change password successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
