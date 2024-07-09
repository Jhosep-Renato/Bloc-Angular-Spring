package com.merrob.bloc.entity;

import com.merrob.bloc.exceptions.GeneralRepeathException;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Entity
@Table(name = "bloc_free")
@Data
public class BlocFree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bloc")
    private int idBlocFree;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User userId;

    @OneToMany(mappedBy = "blocId", cascade = CascadeType.ALL)
    private Set<SectionFree> theSectionsFree;

    public void addSectionFree(SectionFree theSectionFree) {
        if (theSectionFree == null) {
            theSectionsFree = new HashSet<>();
        }
        theSectionsFree.add(theSectionFree);
    }

    public void searchEqualsSections(String title) {
        theSectionsFree = this.getTheSectionsFree();

        Optional<SectionFree> sectionFreeOptional = theSectionsFree.stream()
                                    .filter(s -> Objects.equals(s.getTitle(), title))
                                    .findFirst();

        if (sectionFreeOptional.isPresent()) {
            throw new GeneralRepeathException(title.concat(" is repeat"));
        }
    }
}