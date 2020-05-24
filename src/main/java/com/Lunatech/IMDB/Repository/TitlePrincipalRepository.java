package com.Lunatech.IMDB.Repository;

import com.Lunatech.IMDB.Model.NameBasic;
import com.Lunatech.IMDB.Model.TitleAkasPrincipal;
import com.Lunatech.IMDB.Model.TitlePrincipal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TitlePrincipalRepository extends JpaRepository<TitlePrincipal, TitleAkasPrincipal> {



}
