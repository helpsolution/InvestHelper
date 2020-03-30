package com.investhelper.app.domain.service;

import com.investhelper.app.domain.ex.EmailExistsException;
import com.investhelper.app.domain.ex.UsernameExistsException;
import com.investhelper.app.domain.model.User;
import com.investhelper.app.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class RegistrationManager {

    private final UserRepository userRepository;

    public User register(String username, String password, String email) {
        log.info("Registering new user with username='{}', email='{}'", username, email);

        if (userRepository.findByUsername(username).isPresent()) {
            log.error("Username already exists");
            throw new UsernameExistsException();
        }

        if (userRepository.findByEmail(email).isPresent()) {
            log.error("Email already exists");
            throw new EmailExistsException();
        }

        var newUser = User.create(username, password, email);
        userRepository.save(newUser);

        return newUser;
    }

}
