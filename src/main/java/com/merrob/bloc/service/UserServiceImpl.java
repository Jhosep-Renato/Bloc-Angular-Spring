package com.merrob.bloc.service;

import com.merrob.bloc.dao.UserRepository;
import com.merrob.bloc.dto.SectionFreeDTO;
import com.merrob.bloc.entity.SectionFree;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public SectionFreeDTO addNewSection(String title, int blocId) {

        SectionFreeDTO tempSectionDTO = null;

        if (title.isEmpty() || blocId == 0) {
            return tempSectionDTO;
        }

        SectionFree tempSectionFree = userRepository.addNewSection(title, blocId);

        tempSectionDTO = new SectionFreeDTO(tempSectionFree.getIdSection(),
                tempSectionFree.getTitle());

        return tempSectionDTO;
    }
}
