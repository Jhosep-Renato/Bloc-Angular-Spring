package com.merrob.bloc.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "section_free")
@Getter @Setter @NoArgsConstructor
public class SectionFree extends Section {

    @ManyToOne
    @JoinColumn(name = "bloc_id")
    private BlocFree blocId;

    public SectionFree(String title) {
        super(title);
    }
}