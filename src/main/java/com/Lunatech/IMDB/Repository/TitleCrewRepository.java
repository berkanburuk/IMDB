package com.Lunatech.IMDB.Repository;

import com.Lunatech.IMDB.Model.TitleCrew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TitleCrewRepository extends JpaRepository<TitleCrew, Integer> {
}
