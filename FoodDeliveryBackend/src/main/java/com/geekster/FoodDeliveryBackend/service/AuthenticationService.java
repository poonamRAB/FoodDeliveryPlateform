package com.geekster.FoodDeliveryBackend.service;

import com.geekster.FoodDeliveryBackend.model.AuthenticationToken;
import com.geekster.FoodDeliveryBackend.model.Customer;
import com.geekster.FoodDeliveryBackend.repository.IAuthenticationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    IAuthenticationRepo authRepo;

    public boolean authenticate(String email, String authTokenValue)
    {
        AuthenticationToken authToken = authRepo.findFirstByTokenValue(authTokenValue);

        if(authToken == null)
        {
            return false;
        }

        String tokenConnectedEmail = authToken.getCustomer().getCustomerEmail();

        return tokenConnectedEmail.equals(email);
    }

    public AuthenticationToken findFirstByCustomer(Customer customer) {
        return authRepo.findFirstByCustomer(customer);
    }


    public void saveAuthToken(AuthenticationToken authToken) {
        authRepo.save(authToken);

    }

    public void removeToken(AuthenticationToken token) {
        authRepo.delete(token);
    }
}
