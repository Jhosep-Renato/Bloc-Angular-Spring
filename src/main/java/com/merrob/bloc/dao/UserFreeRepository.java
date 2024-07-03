package com.merrob.bloc.dao;

import com.merrob.bloc.entity.BlocFree;
import com.merrob.bloc.entity.SectionFree;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserFreeRepository implements UserRepository {

    private EntityManager entityManager;

    public UserFreeRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public SectionFree addNewSection(String title, int blocId) {

        SectionFree tempSectionFree = new SectionFree();
        BlocFree tempBlocFree;

        try {
            tempBlocFree = entityManager.find(BlocFree.class, blocId);

            SectionFree existsSection =
                    tempSectionFree.searchAndPersist(tempBlocFree, title, entityManager);

            if (existsSection != null) {

            }
            entityManager.persist(tempSectionFree);
        } catch (IllegalArgumentException ignored) {
        }

        return tempSectionFree;
    }


}
