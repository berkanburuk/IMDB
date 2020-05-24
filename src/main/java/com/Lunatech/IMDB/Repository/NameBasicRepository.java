package com.Lunatech.IMDB.Repository;

import com.Lunatech.IMDB.Model.NameBasic;
import com.Lunatech.IMDB.Model.TitleBasic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NameBasicRepository extends JpaRepository<NameBasic,String> {

    @Query(value = "SELECT * FROM name_basic where primary_name = :name", nativeQuery = true)
    public List<NameBasic> findIdByName(@Param("name") String name);




}
