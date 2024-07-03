package com.merrob.bloc.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "privilege")
@Data @NoArgsConstructor
public class Privilege {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_privilege")
    private int idPrivilege;

    private String privilege;

    public Privilege(int idPrivilege, String privilege) {
        this.idPrivilege = idPrivilege;
        this.privilege = privilege;
    }
}
