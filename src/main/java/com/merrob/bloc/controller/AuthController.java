package com.merrob.bloc.controller;

import com.merrob.bloc.service.AuthService;
import com.merrob.bloc.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/create-user")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO theUserDTO) {

        try {
            authService.createUser(theUserDTO);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(theUserDTO, null, HttpStatus.CREATED);
    }

    @GetMapping("/login-user")
    public UserDTO login(@RequestBody UserDTO theUserDTO) {

        return authService.login(theUserDTO);
    }
}
