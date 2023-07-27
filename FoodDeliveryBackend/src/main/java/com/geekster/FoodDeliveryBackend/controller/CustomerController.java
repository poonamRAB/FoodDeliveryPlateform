package com.geekster.FoodDeliveryBackend.controller;

import com.geekster.FoodDeliveryBackend.model.Customer;
import com.geekster.FoodDeliveryBackend.model.dto.SignInInput;
import com.geekster.FoodDeliveryBackend.model.dto.SignUpOutput;
import com.geekster.FoodDeliveryBackend.service.AuthenticationService;
import com.geekster.FoodDeliveryBackend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@Validated
@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @Autowired
    AuthenticationService authService;

    // customer sign up, sign in, sign out
    @PostMapping("customer/signup")
    public SignUpOutput signUpCustomer(@RequestBody Customer customer){
        return customerService.signUpCustomer(customer);
    }

    //customer sign in
    @PostMapping("customer/signin")
    public String signInCustomer(@RequestBody SignInInput signInInput){
        return customerService.signInCustomer(signInInput);
    }

    //sign out customer
    @DeleteMapping("customer/signout")
    public String signOutCustomer(String email,String token){
        if(authService.authenticate(email, token)){
            return customerService.signOutCustomer(email);
        }
        else{
            return "non-authenticated customer's are not allowed to perform this operation!! ";
        }
    }





}
