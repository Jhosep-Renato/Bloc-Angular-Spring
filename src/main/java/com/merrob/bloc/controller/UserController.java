package com.merrob.bloc.controller;

import com.merrob.bloc.dto.CreateSectionDTO;
import com.merrob.bloc.dto.SectionFreeDTO;
import com.merrob.bloc.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-free")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create-section")
    public ResponseEntity<SectionFreeDTO> addNewSection(@RequestBody CreateSectionDTO createSectionDTO) {

        String title = createSectionDTO.title();
        int blocId = createSectionDTO.blocId();

        SectionFreeDTO tempSection = userService.addNewSection(title, blocId);

        return new ResponseEntity<>(tempSection, null, HttpStatus.CREATED);
    }
}
