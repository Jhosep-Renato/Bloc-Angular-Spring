package com.merrob.bloc.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "bloc_free")
@Getter @Setter @ToString
public class BlocFree implements EditSection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bloc")
    private int idBlocFree;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User userId;

    @Override
    public void addSection(Section section) {

    }

    @Override
    public void editSection(Section section) {

    }

    @Override
    public void removeSection(Section section) {

    }
}
