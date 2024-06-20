package com.merrob.bloc.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "bloc_premium")
public class BlocPremium implements EditSection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bloc")
    private int idBlocFree;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User userId;

    private String password;

    @Column(name = "password_delete")
    private String passwordDelete;

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
