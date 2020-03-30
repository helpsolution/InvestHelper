package com.investhelper.app.domain.service;

import com.investhelper.app.domain.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RegistrationManager {

    public User register(String username, String password, String email){
        log.info("Registering new user");
        return User.create(username, password, email);
    }

}
