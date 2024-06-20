package com.merrob.bloc.dao;

import com.merrob.bloc.dto.UserDTO;
import com.merrob.bloc.entity.BlocFree;
import com.merrob.bloc.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class AuthRepositoryImpl implements AuthRepository {

    private final EntityManager entityManager;

    public AuthRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void createUser(User theUser) {

        BlocFree theBlocFree = new BlocFree();
        theBlocFree.setUserId(theUser);

        Query query = entityManager.createQuery("FROM User");

        List<User> theListUser = query.getResultList();

        Optional<User> userOptional = theListUser.stream()
                        .filter(u -> u.getNickname().equals(theUser.getNickname())).findFirst();

        if (userOptional.isEmpty()) {
            theUser.addBlocFree(theBlocFree);

            entityManager.persist(theUser);
        }
    }

    @Override
    public UserDTO login(User theUser) {

        final String HQL = "FROM User WHERE nickname = :nickname AND password = :password";

        TypedQuery<User> typedQuery = entityManager.createQuery(HQL, User.class);

        typedQuery.setParameter("nickname", theUser.getNickname());
        typedQuery.setParameter("password", theUser.getPassword());

        UserDTO tempUserDTO;
        try {
            theUser = typedQuery.getSingleResult();

            tempUserDTO = new UserDTO(theUser.getNickname(), theUser.getPassword(),
                    theUser.getProfilePicture(), theUser.getPrivilegeId().getIdPrivilege());

        } catch (NoResultException noResultException) {
            throw new NoResultException("The User with nickname and password is incorrect");
        }
        return tempUserDTO;
    }
}
