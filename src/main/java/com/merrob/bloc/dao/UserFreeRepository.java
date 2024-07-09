package com.merrob.bloc.dao;

import com.merrob.bloc.entity.BlocFree;
import com.merrob.bloc.entity.SectionFree;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserFreeRepository implements UserRepository {

    private final EntityManager entityManager;

    public UserFreeRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void addNewSection(SectionFree theSectionFree, int blocId) {

        BlocFree tempBlocFree;

        tempBlocFree = entityManager.find(BlocFree.class, blocId);

        if (tempBlocFree == null) {
            throw new NullPointerException("There was an error with your pad");
        }
        theSectionFree.setBlocId(tempBlocFree);
        tempBlocFree.searchEqualsSections(theSectionFree.getTitle());
        tempBlocFree.addSectionFree(theSectionFree);

        entityManager.persist(tempBlocFree);
    }
}
