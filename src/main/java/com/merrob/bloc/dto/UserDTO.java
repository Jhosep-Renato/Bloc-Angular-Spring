package com.merrob.bloc.dto;

public record UserDTO(
        String nickname,
        String password,
        byte[] profilePicture,
        int privilege
) { }