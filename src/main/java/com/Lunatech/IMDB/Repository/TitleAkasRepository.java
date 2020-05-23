package com.Lunatech.IMDB.Repository;

import com.Lunatech.IMDB.Model.NameBasic;
import com.Lunatech.IMDB.Model.TitleAkas;
import com.Lunatech.IMDB.Model.TitleAkasPrincipal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TitleAkasRepository extends JpaRepository<TitleAkas,String> {

}