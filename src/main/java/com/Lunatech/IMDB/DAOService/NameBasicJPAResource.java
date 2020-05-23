package com.Lunatech.IMDB.DAOService;

import com.Lunatech.IMDB.Model.NameBasic;
import com.Lunatech.IMDB.Repository.NameBasicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class NameBasicJPAResource {

    @Autowired
    private NameBasicRepository nameBasicRepository;

    @GetMapping("/nameBasic/{name}")
    public Optional<NameBasic> getNameFromUser(@PathVariable String name){
        Optional<NameBasic> nameBasicOptinal = nameBasicRepository.findById(name);
        if (!nameBasicOptinal.isPresent()){
            throw new RuntimeException();
        }

        //nameBasicOptinal.
        return nameBasicOptinal;
    }


    @GetMapping("/nameBasic")
    public List<NameBasic> retrieveAllName(){
        return nameBasicRepository.findAll();
    }

    @GetMapping("nameBasic/{id}")
    public Optional<NameBasic> retrieveOneName(@PathVariable String name){
            Optional<NameBasic> nameBasicOptinal = nameBasicRepository.findById(name);
            if (!nameBasicOptinal.isPresent()){
                throw new RuntimeException();
            }
            return nameBasicOptinal;
    }


}
