package com.investhelper.app.domain.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RegistrationCommand {

    private String username;
    private String password;
    private String email;

}
