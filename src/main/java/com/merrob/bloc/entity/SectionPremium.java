package com.merrob.bloc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "section_premium")
public class SectionPremium extends Section {

    @OneToOne
    @JoinColumn(name = "bloc_id")
    private BlocPremium blocId;

    public SectionPremium() {
    }

    public SectionPremium(String title) {
        super(title);
    }

    public BlocPremium getBlocId() {
        return blocId;
    }

    public void setBlocId(BlocPremium blocId) {
        this.blocId = blocId;
    }
}