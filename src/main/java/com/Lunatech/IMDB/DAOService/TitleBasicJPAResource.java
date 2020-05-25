package com.Lunatech.IMDB.DAOService;

import com.Lunatech.IMDB.Model.TitleBasic;
import com.Lunatech.IMDB.Repository.TitleBasicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TitleBasicJPAResource {

    @Autowired
    private TitleBasicRepository titleBasicRepository;

    @GetMapping("/titlebasic")
    public List<TitleBasic> retrieveAllName(){
        return titleBasicRepository.findAll();
    }

}
