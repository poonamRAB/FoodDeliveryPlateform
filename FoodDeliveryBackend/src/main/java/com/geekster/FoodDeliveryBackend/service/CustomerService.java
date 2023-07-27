package com.geekster.FoodDeliveryBackend.service;

import com.geekster.FoodDeliveryBackend.model.AuthenticationToken;
import com.geekster.FoodDeliveryBackend.model.Customer;
import com.geekster.FoodDeliveryBackend.model.dto.SignInInput;
import com.geekster.FoodDeliveryBackend.model.dto.SignUpOutput;
import com.geekster.FoodDeliveryBackend.repository.ICustomerRepo;
import com.geekster.FoodDeliveryBackend.service.utility.emailUtility.EmailHandler;
import com.geekster.FoodDeliveryBackend.service.utility.hashingUtility.PasswordEncrypter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    ICustomerRepo customerRepo;

    @Autowired
    AuthenticationService authService;


    public SignUpOutput signUpCustomer(Customer customer) {
        boolean signUpStatus = true;
        String signUpMsg = null;

        String newEmail = customer.getCustomerEmail();

        if(newEmail == null){
            signUpMsg = "Invalid email!!";
            signUpStatus = false;

            return new SignUpOutput(signUpStatus,signUpMsg);
        }

        //check if customer's mail already exists
        Customer existingCustomer = customerRepo.findFirstByCustomerEmail(newEmail);

        if(existingCustomer != null){
            signUpMsg = "This email is already registered!!";
            signUpStatus = false;
            return new SignUpOutput(signUpStatus,signUpMsg);
        }

        //hashing the password : encrypt password
        try{
            String encryptedPassword = PasswordEncrypter.encryptPassword(customer.getCustomerPassword());
            //saving appointment of customer with encrypted password
            customer.setCustomerPassword(encryptedPassword);
            customerRepo.save(customer);
            return new SignUpOutput(signUpStatus,"Customer registered successfully!!");
        }
        catch(Exception e){
            signUpMsg = "Due to internal error you are failed to sign up, please try again!!";
            signUpStatus = false;

            return new SignUpOutput(signUpStatus,signUpMsg);
        }
    }

    public String signInCustomer(SignInInput signInInput) {
        String signInMsg = null;
        String signInEmail = signInInput.getEmail();

        if(signInEmail == null){
            signInMsg = "Invalid email!!";
            return signInMsg;
        }

        Customer existingCustomer = customerRepo.findFirstByCustomerEmail(signInEmail);

        if(existingCustomer == null){
            signInMsg = "This email is not registered!!";
            return signInMsg;
        }

        try{
            String encryptedPassword = PasswordEncrypter.encryptPassword(signInInput.getPassword());

            if(existingCustomer.getCustomerPassword().equals(encryptedPassword)){
                AuthenticationToken authToken = new AuthenticationToken(existingCustomer);
                authService.saveAuthToken(authToken);

                EmailHandler.sendEmail("poonamapchundakar56@gmail.com","testing", authToken.getTokenValue());
                return "Token sent to your email, please check your email!!";
            }
            else{
                signInMsg = "Invalid credentials!!";
                return signInMsg;
            }
        }
        catch(Exception e){
            signInMsg = "Internal error occurred during sign in!!";
            return signInMsg;
        }

    }

    public String signOutCustomer(String email) {
        Customer customer = customerRepo.findFirstByCustomerEmail(email);
        AuthenticationToken token = authService.findFirstByCustomer(customer);
        authService.removeToken(token);
        return "Customer signed out successfully!!";

    }
}
