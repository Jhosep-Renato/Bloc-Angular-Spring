package com.merrob.bloc.dao;

import com.merrob.bloc.entity.SectionFree;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  {

    SectionFree addNewSection(String title, int blocId);

}
