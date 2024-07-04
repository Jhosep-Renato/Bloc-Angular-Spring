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
    public ResponseEntity<HttpStatus> createUser(@RequestBody UserDTO theUserDTO) throws IOException {

        authService.createUser(theUserDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/login-user")
    public UserDTO login(@RequestBody UserDTO theUserDTO) {

        return authService.login(theUserDTO);
    }
}
