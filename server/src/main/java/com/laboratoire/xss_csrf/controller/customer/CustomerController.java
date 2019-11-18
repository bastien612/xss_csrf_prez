package com.laboratoire.xss_csrf.controller.customer;

import com.laboratoire.xss_csrf.dto.CustomerDto;
import com.laboratoire.xss_csrf.model.CustomerModel;
import com.laboratoire.xss_csrf.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    Logger logger = LoggerFactory.getLogger(this.getClass().getName());
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

    @GetMapping()
    public CustomerDto getCurrent() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        logger.info("LE PRINCIPAL ::");
        logger.info(authentication.getName());

        CustomerModel model = new CustomerModel();
        model.setId(UUID.randomUUID());
        model.setLogin(authentication.getName());

        CustomerDto dto = new CustomerDto(model);
        return dto;

    }
}
