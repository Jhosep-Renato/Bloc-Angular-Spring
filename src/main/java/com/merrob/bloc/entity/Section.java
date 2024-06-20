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

    private String content;

    @Column(name = "photo_profile")
    private byte[] photoProfile;

    private int blocId;

    public Section(String title, String content, byte[] photoProfile, int blocId) {
        this.title = title;
        this.content = content;
        this.photoProfile = photoProfile;
        this.blocId = blocId;
    }

}