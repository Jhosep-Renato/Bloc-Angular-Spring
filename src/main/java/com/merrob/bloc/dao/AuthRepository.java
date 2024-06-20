package com.merrob.bloc.dao;

import com.merrob.bloc.dto.UserDTO;
import com.merrob.bloc.entity.User;

public interface AuthRepository {

    void createUser(User theUser);

    UserDTO login(User theUser);
}
