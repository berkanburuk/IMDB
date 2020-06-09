package com.Lunatech.IMDB.Repository;

import com.Lunatech.IMDB.Model.NameBasic;
import com.Lunatech.IMDB.Model.TitleBasic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TitleBasicRepository extends JpaRepository<TitleBasic,String> {

    @Query(value="SELECT * FROM title_basic where tconst in (:tconst)",nativeQuery = true)
    public List<TitleBasic> findGenresByTitleId(@Param("tconst")String[] tconst);

    @Query(value="SELECT * FROM title_basic where tconst in (:tconst)",nativeQuery = true)
    public List<TitleBasic> findTitleById(@Param("tconst")String[] tconst);
    /*
    @Query(value = "SELECT * FROM title_basic where tconst = :tconst", nativeQuery = true)
    public TitleBasic findTitleById(@Param("tconst") String tconst);
*/
}
