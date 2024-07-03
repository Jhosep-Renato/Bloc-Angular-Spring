package com.merrob.bloc.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "content_section_premium")
@Getter @Setter @NoArgsConstructor
public class ContentSectionPremium {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_content_section")
    private int idContentSection;

    @Column(name = "photo_profile")
    private byte[] photoProfile;

    private String content;

    @OneToOne
    private SectionPremium sectionPremiumId;

    public ContentSectionPremium(byte[] photoProfile, String content) {
        this.photoProfile = photoProfile;
        this.content = content;
    }
}