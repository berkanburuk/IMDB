package com.Lunatech.IMDB.Repository;

import com.Lunatech.IMDB.Model.TitleEpisode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TitleEpisodeRepository extends JpaRepository<TitleEpisode,Integer> {
}
