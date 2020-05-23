package com.Lunatech.IMDB.DAOService;

import com.Lunatech.IMDB.Model.TitleBasic;
import com.Lunatech.IMDB.Model.TitlePrincipal;
import com.Lunatech.IMDB.Repository.TitlePrincipalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class TitlePrincipalJPAResource {

    @Autowired
    private TitlePrincipalRepository titlePrincipalRepository;

    @GetMapping("/titlePrincipalByName")
    public List<TitlePrincipal> retrieveAllName(){
        return titlePrincipalRepository.findAll();
    //findBy NConst

    }

    @GetMapping("titlebasic/{id}")
    public Optional<TitlePrincipal> retrieveOneName(@PathVariable String name){
        /*
        Optional<TitlePrincipal> nameBasicOptinal = titlePrincipalRepository.findById(name);
            if (!nameBasicOptinal.isPresent()){
                throw new RuntimeException();
            }
            return nameBasicOptinal;

         */
        return null;
    }


}
