package com.Lunatech.IMDB.DBInitialData;
/*

import com.Lunatech.IMDB.Model.NameBasic;
import com.Lunatech.IMDB.Util.FileReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class NameBasicCommandLineRunner implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(NameBasicCommandLineRunner.class);


    @Autowired
    NameBasicRepository nameBasicRepository;

    FileReader fileReader;

    public void run(String... args) throws Exception {
        //Buraya file'dan oku ve yaz.
        fileReader = new FileReader("name_basics.tsv");
        logger.info("Okumaya başladı");
        List<NameBasic> nameBasicList = fileReader.getNameBasicFromFile();
        logger.info(nameBasicList.toString());
        nameBasicRepository.saveAll(nameBasicList);
        logger.info("okuma bitti");
    }
}
*/