package com.Lunatech.IMDB.Controller;

import com.Lunatech.IMDB.Model.TitleBasic;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class TitleBasicController {
    public Set<String> findCommonElements(List<String> first, List<String> second){
        Set<String> ids = first.stream()
                .distinct()
                .filter(second::contains)
                .collect(Collectors.toSet());
        return ids;
    }

    public String printToScreen(List<TitleBasic> titleBasicList, String firstName, String secondName){
        String result = firstName + " and " + secondName+" have such movies/series together as ";
        for (int i=0;i<titleBasicList.size();i++){
    //        result += titleBasicList.get(i).getOriginalTitle()+ "\n";
        }
        return result;
    }

}
