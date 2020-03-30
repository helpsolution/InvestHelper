package com.investhelper.app.domain.service;

import com.investhelper.app.domain.commands.RegistrationCommand;
import com.investhelper.app.domain.common.mail.MailManager;
import com.investhelper.app.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
@RequiredArgsConstructor
public class DefaultUserService implements UserService {

    private final RegistrationManager registrationManager;
    private final MailManager mailManager;

    @Transactional
    @Override
    public void register(RegistrationCommand command) {
        Assert.notNull(command, "'command' must not be null");

        User registeredUser = registrationManager.register(
                command.getUsername(),
                command.getPassword(),
                command.getEmail());

        sendWelcomeMessage(registeredUser);
    }

    private void sendWelcomeMessage(User user) {
        Assert.notNull(user, "'user' must not be null");

        mailManager.send(
                user.getEmail(),
                "Welcome to TaskHelper",
                String.format("Hello, %s", user.getUsername()));
    }
}
