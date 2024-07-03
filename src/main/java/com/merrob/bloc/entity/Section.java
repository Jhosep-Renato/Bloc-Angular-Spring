package com.merrob.bloc.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter @Setter @ToString @NoArgsConstructor
abstract public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_section")
    private int idSection;

    private String title;

    public Section(String title) {
        this.title = title;
    }

    public SectionFree searchAndPersist(BlocFree theBlocFree, String theTitle,
                                           EntityManager entityManager) {

        final String HQL = "FROM SectionFree WHERE title = :title AND blocId = :bloc";

        TypedQuery<SectionFree> typedQuery = entityManager
                .createQuery(HQL, SectionFree.class);

        typedQuery.setParameter("title", theTitle);
        typedQuery.setParameter("bloc", theBlocFree);

        SectionFree tempSectionFree = null;

        try {
            tempSectionFree = typedQuery.getSingleResult();
        } catch (Exception ignored) {
        }
        return tempSectionFree;
    }
}