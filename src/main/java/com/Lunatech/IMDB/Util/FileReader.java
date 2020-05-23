package com.Lunatech.IMDB.Util;

import com.Lunatech.IMDB.ImdbApplication;
import com.Lunatech.IMDB.Model.NameBasic;

import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class FileReader {
    String fileName=null;
    ClassLoader classLoader;
    public FileReader(String fileName) {
        this.fileName = fileName;
         classLoader = new ImdbApplication().getClass().getClassLoader();
    }

    public List<NameBasic> getNameBasicFromFile(){
        File file = new File(classLoader.getResource("static/"+fileName).getFile());
        if (file==null){
                return null;
        }
        String content = "";
        BufferedReader bufferedReader;
        List<NameBasic> nameBasicList=new ArrayList<>();
        try {
            bufferedReader = new BufferedReader(new java.io.FileReader(file));
            int i=0;
            content = bufferedReader.readLine();
            content = bufferedReader.readLine();
            while (content!=null){
                String[] str =content.split("\t");
                int bYear=-1;
                int dYear=-1;
                if (str[2].equals("\\N")){
                    str[2]=null;
                }else{
                    bYear = Integer.parseInt(str[2]);
                }
                if (str[3].equals("\\N")){
                    str[3]=null;
                }else{
                    dYear = Integer.parseInt(str[3]);
                }
                NameBasic nameBasic=
                        new NameBasic(str[0],str[1],bYear,dYear,str[4],str[5]);
                nameBasicList.add(nameBasic);
                content = bufferedReader.readLine();
                i++;
                if(i>1000){
                    break;
                }
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nameBasicList;
    }

    public List<NameBasic> getEpisodeFromFile(){
        File file = new File(classLoader.getResource("static/"+fileName).getFile());
        if (file==null){
            return null;
        }
        String content = "";
        BufferedReader bufferedReader;
        List<NameBasic> nameBasicList=new ArrayList<>();
        try {
            bufferedReader = new BufferedReader(new java.io.FileReader(file));
            int i=0;
            content = bufferedReader.readLine();
            content = bufferedReader.readLine();
            while (content!=null){
                String[] str =content.split("\t");
                int bYear=-1;
                int dYear=-1;
                if (str[2].equals("\\N")){
                    str[2]=null;
                }else{
                    bYear = Integer.parseInt(str[2]);
                }
                if (str[3].equals("\\N")){
                    str[3]=null;
                }else{
                    dYear = Integer.parseInt(str[3]);
                }
                NameBasic nameBasic=
                        new NameBasic(str[0],str[1],bYear,dYear,str[4],str[5]);
                nameBasicList.add(nameBasic);
                content = bufferedReader.readLine();
                i++;
                if(i>1000){
                    break;
                }
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nameBasicList;
    }


}
