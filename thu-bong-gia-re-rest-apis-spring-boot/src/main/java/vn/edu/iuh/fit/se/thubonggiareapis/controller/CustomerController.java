package vn.edu.iuh.fit.se.thubonggiareapis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.CustomerDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.service.ICustomerService;

@RestController
@RequestMapping("/customers")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("/{customerId}")
    public CustomerDTO getCustomer(@PathVariable long customerId) {
        CustomerDTO customerDTO = customerService.getCustomer(customerId);
        return customerDTO;
    }

    @PostMapping(value = {
            "", "/"
    }, consumes = {
            "application/json",
            "application/x-www-form-urlencoded"
    })
    public CustomerDTO addCustomer(@RequestBody CustomerDTO customerDTO) {

        return customerService.addCustomer(customerDTO);
    }
}
