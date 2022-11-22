package vn.edu.iuh.fit.se.thubonggiareapis.converter;

import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.CustomerDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.Customer;

@Component
public class CustomerConverter {

    public Customer toEntity(CustomerDTO customerDTO) {
        Customer customer = new Customer();

        if (customerDTO.getId() != 0) {
            customer.setId(customerDTO.getId());
        }

        customer.setEmail(customerDTO.getEmail());
        customer.setName(customerDTO.getName());
        customer.setPhoneNumber(customerDTO.getPhoneNumber());

        return customer;
    }

    public CustomerDTO toDto(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();

        if (customer.getId() != 0) {
            customerDTO.setId(customer.getId());
        }

        customerDTO.setEmail(customer.getEmail());
        customerDTO.setName(customer.getName());
        customerDTO.setPhoneNumber(customer.getPhoneNumber());

        return customerDTO;
    }
}
