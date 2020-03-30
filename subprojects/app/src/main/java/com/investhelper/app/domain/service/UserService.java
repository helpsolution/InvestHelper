package com.investhelper.app.domain.service;

import com.investhelper.app.domain.commands.RegistrationCommand;

public interface UserService {
    void register(RegistrationCommand command);
}
