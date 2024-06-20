package com.merrob.bloc.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "user")
@Getter @Setter @ToString @NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private int idUser;

    private String nickname;

    private String password;

    @Column(name = "profile_picture")
    private byte[] profilePicture;

    @OneToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "privilege_id")
    private Privilege privilegeId;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "userId")
    private BlocFree blocFree;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "userId")
    private BlocPremium blocPremium;

    public User(String nickname, String password, Privilege privilegeId) {
        this.nickname = nickname;
        this.password = password;
        this.privilegeId = privilegeId;
    }

    public User(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;
    }
    
    public void addBlocFree(BlocFree blocFree) {

        if (blocFree != null) {

            this.blocFree = blocFree;
            this.blocFree.setUserId(this);
        }
    }
}
