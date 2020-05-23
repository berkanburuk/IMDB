package com.Lunatech.IMDB.Repository;

import com.Lunatech.IMDB.Model.TitleRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TitleRatingRepository extends JpaRepository<TitleRating,Integer> {
}

