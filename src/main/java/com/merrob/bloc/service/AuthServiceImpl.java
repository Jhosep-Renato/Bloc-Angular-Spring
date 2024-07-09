package com.merrob.bloc.service;

import com.merrob.bloc.dao.AuthRepository;
import com.merrob.bloc.dto.UserDTO;
import com.merrob.bloc.entity.Privilege;
import com.merrob.bloc.entity.User;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import static com.merrob.bloc.entity.PrivlegeConst.*;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthRepository authRepository;

    public AuthServiceImpl(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    @Override
    public void createUser(UserDTO theUserDTO) throws IOException {

        byte[] profilePicture = theUserDTO.profilePicture();

        User tempUser = new User();

        userValidate(theUserDTO, tempUser);

        tempUser.setPrivilegeId(new Privilege(FREE.getId(), FREE.getPrivilege()));

        if (profilePicture == null) {

            String path = "/static/image/unknowna.png";
            BufferedImage bufferImage;

            try (InputStream is = getClass().getResourceAsStream(path)) {
                if (is == null) {
                    throw new IOException("Resource not found: " + path);
                }
                bufferImage = ImageIO.read(is);
            }
            ByteArrayOutputStream imgByte = new ByteArrayOutputStream();

            ImageIO.write(bufferImage, "png", imgByte);
            imgByte.flush();
            profilePicture = imgByte.toByteArray();
            imgByte.close();

            tempUser.setProfilePicture(profilePicture);
        } else {
            tempUser.setProfilePicture(profilePicture);
        }
        authRepository.createUser(tempUser);
    }

    @Override
    public UserDTO login(UserDTO theUserDTO) {

        User tempUser = new User();

        userValidate(theUserDTO, tempUser);

        return authRepository.login(tempUser);
    }

    private static void userValidate(UserDTO theUserDTO, User theUser) {

        String nickname = theUserDTO.nickname();
        String password = theUserDTO.password();

        if (nickname.isEmpty() || password.isEmpty()) {
            throw new NullPointerException("Nickname or password is null");
        }
        theUser.setNickname(nickname);
        theUser.setPassword(password);
    }
}