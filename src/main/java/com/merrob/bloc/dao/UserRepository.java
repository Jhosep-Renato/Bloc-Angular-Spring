package com.merrob.bloc.dao;

import com.merrob.bloc.entity.SectionFree;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  {

    void addNewSection(SectionFree theSectionFree, int blocId);

}
