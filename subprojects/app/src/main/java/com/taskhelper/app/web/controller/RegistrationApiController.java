package com.taskhelper.app.web.controller;

import com.taskhelper.app.domain.ex.EmailExistsException;
import com.taskhelper.app.domain.ex.UserExistsException;
import com.taskhelper.app.domain.service.UserService;
import com.taskhelper.app.web.payload.RegistrationPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/registrations")
@RequiredArgsConstructor
public class RegistrationApiController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<?> register(@RequestBody @Valid RegistrationPayload payload) {
        try {
            userService.register(payload.toCommand());
        } catch (UserExistsException ex) {
            return ResponseEntity.badRequest().body("Username already exists");
        } catch (EmailExistsException ex) {
            return ResponseEntity.badRequest().body("Email already exists");
        }
        return ResponseEntity.ok().build();
    }

}
