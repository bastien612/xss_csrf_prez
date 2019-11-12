package com.laboratoire.xss_csrf.controller.customer;

import com.laboratoire.xss_csrf.dto.CustomerDto;
import com.laboratoire.xss_csrf.model.CustomerModel;
import com.laboratoire.xss_csrf.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    private CustomerRepository customerRepository;

    @Autowired
    CustomerController(CustomerRepository customerRepo){
        customerRepository = customerRepo;
    }

    @PostMapping()
    public CustomerDto createCustomer(String login, String password) {
        CustomerModel model = new CustomerModel();
        model.setLogin(login);
        model.setPassword(password);
        model = customerRepository.save(model);
        return new CustomerDto(model);
    }
}
