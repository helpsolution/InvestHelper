package com.taskhelper.app.domain.service;

import com.taskhelper.app.domain.commands.RegistrationCommand;

public interface UserService {
    void register(RegistrationCommand command);
}
