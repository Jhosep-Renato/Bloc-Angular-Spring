package com.merrob.bloc.entity;

import jakarta.persistence.*;
import lombok.*;

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
}