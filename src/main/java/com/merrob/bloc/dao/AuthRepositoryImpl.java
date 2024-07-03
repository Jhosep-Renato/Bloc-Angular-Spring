package com.merrob.bloc.dao;

import com.merrob.bloc.dto.UserDTO;
import com.merrob.bloc.entity.BlocFree;
import com.merrob.bloc.entity.User;
import com.merrob.bloc.exceptions.UserNotFoundException;
import com.merrob.bloc.exceptions.UserRepeatException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Repository
public class AuthRepositoryImpl implements AuthRepository {

    private final EntityManager entityManager;

    public AuthRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void createUser(User theUser) {

        final String HQL = "FROM User WHERE nickname =: nickname";
        BlocFree tempBlocFree = new BlocFree();
        tempBlocFree.setUserId(theUser);
        theUser.setBlocFree(tempBlocFree);

        try {
            TypedQuery<User> typedQuery = entityManager
                    .createQuery(HQL, User.class);
            typedQuery.setParameter("nickname", theUser.getNickname());

            typedQuery.getSingleResult();

            throw new UserRepeatException();
        } catch (NoResultException ignored) {
            entityManager.persist(theUser);
        }
    }

    @Override
    public UserDTO login(User theUser) {

        final String nickname = theUser.getNickname();
        final String HQL = "FROM User WHERE nickname = :nickname AND password = :password";

        TypedQuery<User> typedQuery = entityManager.createQuery(HQL, User.class);

        typedQuery.setParameter("nickname", theUser.getNickname());
        typedQuery.setParameter("password", theUser.getPassword());

        UserDTO tempUserDTO;
        try {
            theUser = typedQuery.getSingleResult();

            validateUser(theUser, nickname);

            tempUserDTO = new UserDTO(theUser.getNickname(), theUser.getPassword(),
                    theUser.getProfilePicture(), theUser.getPrivilegeId().getIdPrivilege());

        } catch (NoResultException noResultException) {
            throw new NoResultException("The User with nickname and password is incorrect");
        }
        return tempUserDTO;
    }

    private void validateUser(User theUser, String nickname) {

        if (!Objects.equals(theUser.getNickname(), nickname)) {
            throw new UserNotFoundException("User with nickname " + nickname +
                    "does not exists");
        }
    }
}
