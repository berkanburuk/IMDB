package com.Lunatech.IMDB.Controller;

import com.Lunatech.IMDB.Model.TitleBasic;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class NameBasicController {
    public String getTypecasted(List<TitleBasic> titleBasicList){
        //parseGenre
        List<String> genreArrayList = parseGenre(titleBasicList);
        //Count the genres
        Map<String, Long> counters = countGenres(genreArrayList);
        //Typecasted one
        String result = findTheTypecast(counters);

        return result;
    }

    public List<String> parseGenre(List<TitleBasic> titleBasicList){
        List<String> genreArrayList = new ArrayList<>();
        for(TitleBasic tb : titleBasicList){
            String[] genreList = tb.getGenres().split(",");
            for (String in : genreList){
                genreArrayList.add(in);
            }
        }
        return genreArrayList;
    }

    public Map<String, Long> countGenres(List<String> genreArrayList){
        //Counting the most played genres(typecast)
        Map<String, Long> counters = genreArrayList.stream()
                .collect(Collectors.groupingBy(tb -> tb,
                        Collectors.counting()));
        return counters;
    }

    public String findTheTypecast(Map<String, Long> counters){
        String typeCas ="";
        Long num = -1L;
        for (String key: counters.keySet()) {
            Long number = counters.get(key);
            if (num<=number){
                num=number;
                typeCas = key;
            }
        }
        return typeCas;
    }

}
