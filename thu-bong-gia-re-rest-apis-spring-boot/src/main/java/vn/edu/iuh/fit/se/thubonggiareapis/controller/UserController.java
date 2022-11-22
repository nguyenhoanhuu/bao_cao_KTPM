package vn.edu.iuh.fit.se.thubonggiareapis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.UserDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.service.IUserService;
import vn.edu.iuh.fit.se.thubonggiareapis.util.HashMapConverter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
	@Autowired
	private IUserService userService;

	@PostMapping(value = { "", "/" }, consumes = { "application/json", "application/x-www-form-urlencoded" })
	public ResponseEntity<HashMap<String, Object>> addUser(@RequestBody UserDTO model) {
		try {
			if (model.getPassword().isEmpty())
				throw new Exception("Password is required");
			UserDTO user = userService.addUser(model);
			HashMap<String, Object> response = HashMapConverter.toHashMap(user);
			response.remove("password");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			if (e.getMessage().equals("Password is required")) {
				HashMap<String, Object> res = new HashMap<>();
				res.put("message", e.getMessage());
				return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
			}

			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = { "", "/" })
	public ResponseEntity<List<HashMap<String, Object>>> getUsers() {
		try {
			List<UserDTO> users = userService.getUsers();
			List<HashMap<String, Object>> response = new ArrayList<>();
			for (UserDTO user : users) {
				HashMap<String, Object> userResponse = HashMapConverter.toHashMap(user);
				userResponse.remove("password");
				userResponse.put("id", user.getId());
				response.add(userResponse);
			}
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{userId}")
	public ResponseEntity<HashMap<String, Object>> getUser(@PathVariable long userId) {
		try {
			UserDTO user = userService.getUser(userId);
			if (user == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			HashMap<String, Object> response = HashMapConverter.toHashMap(user);
			response.remove("password");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(value = { "/update" }, consumes = { "application/json", "application/x-www-form-urlencoded" })
	public void updateUser(@RequestBody UserDTO model) {
		userService.updateUser(model);
	}

	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable long userId) {
		userService.deleteUser(userId);
	}

}
