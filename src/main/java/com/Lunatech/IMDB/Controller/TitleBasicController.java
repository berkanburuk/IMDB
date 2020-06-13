package com.Lunatech.IMDB.Controller;

import com.Lunatech.IMDB.Model.TitleBasic;
import com.Lunatech.IMDB.Repository.TitleBasicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TitleBasicController {

    @Autowired
    private TitleBasicRepository titleBasicRepository;

    @GetMapping("/titlebasic")
    public List<TitleBasic> retrieveAllName(){
        return titleBasicRepository.findAll();
    }

    public Set<String> findCommonElements(List<String> first, List<String> second){
        Set<String> ids = first.stream()
                .distinct()
                .filter(second::contains)
                .collect(Collectors.toSet());
        return ids;
    }

    public String printToScreen(List<TitleBasic> titleBasicList, String firstName, String secondName){
        final String[] result = {firstName + " and " + secondName + " have such movies/series together as "};
        titleBasicList.stream().forEach(tb->{
            result[0] += tb.getOriginalTitle()+ "\n";
        });
        return result[0];
    }
}
