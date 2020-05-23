package com.Lunatech.IMDB.Repository;

import com.Lunatech.IMDB.Model.TitleBasic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TitleBasicRepository extends JpaRepository<TitleBasic,String> {
}
