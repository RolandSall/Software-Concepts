package com.rolandsall.customer.api.customer;


import com.rolandsall.customer.models.Customer;
import com.rolandsall.customer.services.ICustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    private ICustomerService iCustomerService;

    @Autowired
    public CustomerController(ICustomerService iCustomerService) {
        this.iCustomerService = iCustomerService;
    }

    @PostMapping
    public ResponseEntity Register(@RequestBody CustomerRegistrationRequest request){
        log.info(String.valueOf(request));
        try {
            iCustomerService.Register(BuildRequestFromRequest(request));
            return ResponseEntity.ok("Created");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Customer>> GetUsers(){
        List<Customer> customerList = iCustomerService.GetUsers();
        return ResponseEntity.ok().body(customerList);
    }

    private Customer BuildRequestFromRequest(CustomerRegistrationRequest request) {
        return Customer.builder()
                .email(request.getEmail())
                .lastName(request.getLastName())
                .firstName(request.getFirstName())
                .build();
    }

}
