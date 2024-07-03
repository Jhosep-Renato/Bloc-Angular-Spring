package com.merrob.bloc.service;

import com.merrob.bloc.dto.SectionFreeDTO;

public interface UserService {

    SectionFreeDTO addNewSection(String title, int blocId);
}
