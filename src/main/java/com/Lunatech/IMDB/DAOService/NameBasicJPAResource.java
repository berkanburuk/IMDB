package com.Lunatech.IMDB.DAOService;

import com.Lunatech.IMDB.Controller.NameBasicController;
import com.Lunatech.IMDB.Controller.TitleBasicController;
import com.Lunatech.IMDB.Exception.DataNotFoundExcetion;
import com.Lunatech.IMDB.Model.NameBasic;
import com.Lunatech.IMDB.Model.TitleBasic;
import com.Lunatech.IMDB.Repository.NameBasicRepository;
import com.Lunatech.IMDB.Repository.TitleBasicRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class NameBasicJPAResource {
    private static final Logger logger = LoggerFactory.getLogger(NameBasicJPAResource.class);

    @Autowired
    private NameBasicRepository nameBasicRepository;
    @Autowired
    private TitleBasicRepository titleBasicRepository;
    @Autowired
    NameBasicController nameBasicController;
    @Autowired
    TitleBasicController titleBasicController;


    @GetMapping("/nameBasic/typeCasting")
    public String getTypecastingByName(@RequestParam String fullName) {
        List<NameBasic> nameBasicList = nameBasicRepository.findIdByName(fullName);
        if (nameBasicList.size() == 0 || nameBasicList == null) {
            throw new DataNotFoundExcetion("Data Not Found");
        }
        List<TitleBasic> titleBasicList = titleBasicRepository.findGenresByTitleId(nameBasicList.get(0).getKnownForTitles().split(","));
        String result = nameBasicController.getTypecasted(titleBasicList);
        if (result.length() == 0) {
            throw new DataNotFoundExcetion("Person has no typecast character.");
        }
        result += fullName + " typecast is " + result;
        return result;
    }


    public List<NameBasic> getIdFromPersonName(String name){
        return nameBasicRepository.findIdByName(name);
    }

    @GetMapping("/nameBasic/coincidence")
    public String findCoincedence(@RequestParam String firstName, String secondName) {

        List<NameBasic> firstPerson = getIdFromPersonName(firstName);
        List<NameBasic> secondPerson = getIdFromPersonName(secondName);
        if (firstPerson == null || firstPerson.size() == 0 || secondPerson == null || secondPerson.size() == 0) {
            throw new DataNotFoundExcetion("First or Second person could not found in the server!");
        }

        List<String> firstKnownTitles = Arrays.asList(firstPerson.get(0).getKnownForTitles().split(","));
        List<String> secondKnownTitles = Arrays.asList(secondPerson.get(0).getKnownForTitles().split(","));

        Set<String> ids = titleBasicController.findCommonElements(firstKnownTitles,secondKnownTitles);
        if (ids.size()==0) {
            throw new DataNotFoundExcetion(firstName + " and "+ secondName +" have no common movie or series.");
        }

        List<TitleBasic> titleBasicList = new ArrayList<>();
        ids.forEach((String id) -> {
            titleBasicList.add(titleBasicRepository.getOne(id));
        });

        String result = titleBasicController.printToScreen(titleBasicList,firstName,secondName);

        return result;
    }

}
