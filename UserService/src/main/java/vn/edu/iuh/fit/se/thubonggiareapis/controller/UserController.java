package vn.edu.iuh.fit.se.thubonggiareapis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.CustomerDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.ProductDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.UserDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
	public static final String USER_SERVICE = "userService";
	public static final String url = "http://localhost:8081/users";

	@Autowired
	@Lazy
	private RestTemplate restTemplate;
	private int attemptGetCustomer = 1;
	private int attemptAddCustomer = 1;

	@GetMapping("/{userId}")
	@Cacheable(value = "user", key = "#userId")
//	@CircuitBreaker(name = USER_SERVICE, fallbackMethod = "getCustomerAvailable")
//	@Retry(name = USER_SERVICE, fallbackMethod = "getCustomerAvailable")
//	@RateLimiter(name = USER_SERVICE)
	public UserDTO findUserById(@PathVariable long userId) {

		System.out.println("retry method called " + attemptGetCustomer++ + " times " + " at " + new Date());

		ResponseEntity<UserDTO> response = restTemplate.getForEntity(url + "/" + userId, UserDTO.class);
//		return response.getBody();
		response.getBody().setId(userId);
		return response.getBody();
	}

	public User getCustomerAvailable(Exception e) {
		User user = new User(20, "Hoàng Hoa Thuấn", "thuanne23323@gmail.com", "0978237827", "90909090");
		return user;
	}

	@PostMapping(value = { "", "/" }, consumes = { "application/json", "application/x-www-form-urlencoded" })
//	@Cacheable(value = "user", key = "#us.id")
	@CircuitBreaker(name = USER_SERVICE)
	@Retry(name = USER_SERVICE)
	@RateLimiter(name = USER_SERVICE)
	public UserDTO addUser(@RequestBody UserDTO userDTO) {

		System.out.println("retry method called " + attemptAddCustomer++ + " times " + " at " + new Date());

		UserDTO response = restTemplate.postForObject(url, userDTO, UserDTO.class);
		return response;
	}

	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable long userId) {
		System.out.println(userId);
		restTemplate.delete(url + "/" + userId, userId);
	}

	@PutMapping(value = { "", "/" }, consumes = { "application/json", "application/x-www-form-urlencoded" })
	public void updateUser(@RequestBody UserDTO model) {
		UserDTO response = restTemplate.postForObject(url + "/update", model, UserDTO.class);
		System.out.println("Successfull");
	}

//    @PostMapping(value = {
//            "", "/"
//    }, consumes = {
//            "application/json",
//            "application/x-www-form-urlencoded"
//    })
//    public ResponseEntity<HashMap<String, Object>> addUser(@RequestBody UserDTO model) {
//        try {
//            if (model.getPassword().isEmpty())
//                throw new Exception("Password is required");
//            UserDTO user = userService.addUser(model);
//            HashMap<String, Object> response = HashMapConverter.toHashMap(user);
//            response.remove("password");
//            return new ResponseEntity<>(response, HttpStatus.OK);
//        } catch (Exception e) {
//            if (e.getMessage().equals("Password is required")) {
//                HashMap<String, Object> res = new HashMap<>();
//                res.put("message", e.getMessage());
//                return new ResponseEntity<>(
//                        res,
//                        HttpStatus.BAD_REQUEST
//                );
//            }
//
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//
//    @GetMapping(value = {
//            "", "/"
//    })
//    public ResponseEntity<List<HashMap<String, Object>>> getUsers() {
//        try {
//            List<UserDTO> users = userService.getUsers();
//            List<HashMap<String, Object>> response = new ArrayList<>();
//            for (UserDTO user : users) {
//                HashMap<String, Object> userResponse = HashMapConverter.toHashMap(user);
//                userResponse.remove("password");
//                userResponse.put("id", user.getId());
//                response.add(userResponse);
//            }
//            return new ResponseEntity<>(response, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @GetMapping("/{userId}")
//    public ResponseEntity<HashMap<String, Object>> getUser(@PathVariable long userId) {
//        try {
//            UserDTO user = userService.getUser(userId);
//            if (user == null) {
//                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            }
//            HashMap<String, Object> response = HashMapConverter.toHashMap(user);
//            response.remove("password");
//            return new ResponseEntity<>(response, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @PutMapping(value = {
//            "", "/"
//    }, consumes = {
//            "application/json",
//            "application/x-www-form-urlencoded"
//    })
//    public void updateUser(@RequestBody UserDTO model) {
//        userService.updateUser(model);
//    }
//
//    @DeleteMapping("/{userId}")
//    public void deleteUser(@PathVariable long userId) {
//        userService.deleteUser(userId);
//    }

}
