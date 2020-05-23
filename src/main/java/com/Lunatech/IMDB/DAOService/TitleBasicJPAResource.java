package com.Lunatech.IMDB.DAOService;

import com.Lunatech.IMDB.Model.TitleBasic;
import com.Lunatech.IMDB.Repository.TitleBasicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class TitleBasicJPAResource {

    @Autowired
    private TitleBasicRepository titleBasicRepository;

    @GetMapping("/titlebasic")
    public List<TitleBasic> retrieveAllName(){
        return titleBasicRepository.findAll();
    }

    @GetMapping("titlebasic/{id}")
    public Optional<TitleBasic> retrieveOneName(@PathVariable String name){
            Optional<TitleBasic> nameBasicOptinal = titleBasicRepository.findById(name);
            if (!nameBasicOptinal.isPresent()){
                throw new RuntimeException();
            }
            return nameBasicOptinal;
    }


}
