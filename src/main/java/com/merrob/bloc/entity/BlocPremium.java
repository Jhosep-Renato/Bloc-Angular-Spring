package com.merrob.bloc.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "bloc_premium")
@Data
public class BlocPremium {

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
}
