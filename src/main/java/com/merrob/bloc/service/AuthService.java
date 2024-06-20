package com.merrob.bloc.service;

import com.merrob.bloc.dto.UserDTO;

import java.io.IOException;

public interface AuthService {

    void createUser(UserDTO theUserDTO) throws IOException;

    UserDTO login(UserDTO theUserDTO);
}
