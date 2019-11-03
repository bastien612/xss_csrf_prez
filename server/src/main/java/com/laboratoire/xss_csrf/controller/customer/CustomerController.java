package com.laboratoire.xss_csrf.controller.customer;

import com.laboratoire.xss_csrf.dao.CustomerDao;
import com.laboratoire.xss_csrf.model.CustomerModel;
import com.laboratoire.xss_csrf.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/customer")
public class CustomerController {

    private CustomerRepository customerRepository;

    @Autowired
    CustomerController(CustomerRepository customerRepo){
        customerRepository = customerRepo;
    }

    @PostMapping()
    public CustomerDao createCustomer(String login, String password) {
        CustomerModel model = new CustomerModel();
        model.setLogin(login);
        model.setPassword(password);
        model = customerRepository.save(model);
        return new CustomerDao(model);
    }
}
