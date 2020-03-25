package com.taskhelper.app.web.payload;


import com.taskhelper.app.domain.commands.RegistrationCommand;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationPayload {

    @NotEmpty
    private String email;

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    public RegistrationCommand toCommand(){
        return new RegistrationCommand(
                username,
                password,
                email);
    }

}
