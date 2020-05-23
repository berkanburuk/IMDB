package com.Lunatech.IMDB.Repository;

import com.Lunatech.IMDB.Model.TitlePrincipal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TitlePrincipalRepository extends JpaRepository<TitlePrincipal,Integer> {
}
