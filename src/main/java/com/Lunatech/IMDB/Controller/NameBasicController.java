package com.Lunatech.IMDB.Controller;

import com.Lunatech.IMDB.Exception.DataNotFoundExcetion;
import com.Lunatech.IMDB.Model.NameBasic;
import com.Lunatech.IMDB.Model.TitleBasic;
import com.Lunatech.IMDB.Repository.NameBasicRepository;
import com.Lunatech.IMDB.Repository.TitleBasicRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class NameBasicController {
    private static final Logger logger = LoggerFactory.getLogger(NameBasicController.class);

    @Autowired
    private NameBasicRepository nameBasicRepository;
    @Autowired
    private TitleBasicRepository titleBasicRepository;
    @Autowired
    private TitleBasicController titleBasicController;


    @GetMapping("/nameBasic/typeCasting")
    public String getTypecastingByName(@RequestParam String fullName) {
        List<NameBasic> nameBasicList = nameBasicRepository.findIdByName(fullName);
        if (nameBasicList.size() == 0 || nameBasicList == null) {
            throw new DataNotFoundExcetion("Data Not Found");
        }
        List<TitleBasic> titleBasicList = titleBasicRepository.findGenresByTitleId(nameBasicList.get(0).getKnownForTitles().split(","));

        String typecasting = null;

            typecasting = getTypecasted(titleBasicList);

        String result = fullName + " " + typecasting;
        return result;
    }


    public List<NameBasic> getIdFromPersonName(String name) {
        return nameBasicRepository.findIdByName(name);
    }

    @GetMapping("/nameBasic/coincidence")
    public String findCoincedence(@RequestParam String firstName, String secondName) {
        //get ids' of the actors/actresses entered
        List<NameBasic> firstPerson = getIdFromPersonName(firstName);
        List<NameBasic> secondPerson = getIdFromPersonName(secondName);
        if (firstPerson == null || firstPerson.size() == 0 || secondPerson == null || secondPerson.size() == 0) {
            throw new DataNotFoundExcetion("First or Second person could not found in the server!");
        }
        //gets the played movies/films' ids.
        List<String> firstKnownTitles = Arrays.asList(firstPerson.get(0).getKnownForTitles().split(","));
        List<String> secondKnownTitles = Arrays.asList(secondPerson.get(0).getKnownForTitles().split(","));


        Set<String> ids = titleBasicController.findCommonElements(firstKnownTitles, secondKnownTitles);
        if (ids.size() == 0) {
            return firstName + " and " + secondName + " have no common movie or series.";
        }
        String[] idArray = ids.toArray(new String[ids.size()]);

        List<TitleBasic> titleBasicList;
        titleBasicList = titleBasicRepository.findTitleById(idArray);

        String result = titleBasicController.printToScreen(titleBasicList, firstName, secondName);

        return result;
    }

    public String getTypecasted(List<TitleBasic> titleBasicList) {
        //parseGenre
        List<String> genreArrayList = parseGenre(titleBasicList);
        //Count the genres
        Map<String, Long> counters = countGenres(genreArrayList);
        //Typecasted one
        String result = findTheTypecast(counters);

        return result;
    }

    public List<String> parseGenre(List<TitleBasic> titleBasicList) {
        //Parse the genres with ","
        List<String> genreList = new ArrayList<>();
        titleBasicList.stream().forEach((tb)->{
            String[] genreArr = tb.getGenres().split(",");
            Arrays.stream(genreArr).forEach(gl->{
                genreList.add(gl);
            });
        });
        return genreList;
    }

    public Map<String, Long> countGenres(List<String> genreArrayList) {
        //Count the played genres and groups them.
        Map<String, Long> counters = genreArrayList.stream()
                .collect(Collectors.groupingBy(tb -> tb,
                        Collectors.counting()));
        return counters;
    }

    public String findTheTypecast(Map<String, Long> counters){
        //Finds the most played genres and finds out if it is genres
        final String[] typeCas = {""};
        final Long[] num = {-1L};
        final double[] total = {0};
        counters.keySet().stream().forEach(key->{
            Long number = counters.get(key);
            total[0] += number;
            if (num[0] <= number) {
                num[0] = number;
                typeCas[0] = key;
            }
        });
        if (num[0] > total[0] / 2) {
            return typeCas[0];
        } else {
            if (num[0] == -1L) {
                return "is found. However, typecasting could not be found!";
            }
            return "is found. His maximum repeated character genre is " + typeCas[0] + ", " + num[0] + " times."
                    + " To be able to be typecasting, it should be at least " + (int) Math.ceil(total[0] / 2);
        }

    }

}
