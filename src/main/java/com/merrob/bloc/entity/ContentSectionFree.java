package com.merrob.bloc.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "content_section_free")
@Getter @Setter @NoArgsConstructor
public class ContentSectionFree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_content_section")
    private int idContentSection;

    @Column(name = "photo_profile")
    private byte[] photoProfile;

    private String content;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "section_free_id")
    private SectionFree sectionFree;

    public ContentSectionFree(byte[] photoProfile, String content) {
        this.photoProfile = photoProfile;
        this.content = content;
    }
}