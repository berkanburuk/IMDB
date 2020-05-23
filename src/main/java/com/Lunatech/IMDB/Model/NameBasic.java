package com.Lunatech.IMDB.Model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class NameBasic  {
    @Id
    private String nconst;

    private String primaryName;
    private int birthYear;
    private int deathYear;


    //private String[] primaryProfession;
    private String primaryProfession;
    //tconsts – titles the person is known for
    //private String[] knownForTitles;
    private String knownForTitles;


    public NameBasic() {
    }
    public NameBasic(String nconst, String primaryName, int birthYear, int deathYear, String primaryProfession, String knownForTitles) {
        this.nconst = nconst;
        this.primaryName = primaryName;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
        this.primaryProfession = primaryProfession;
        this.knownForTitles = knownForTitles;
    }

    public String getNconst() {
        return nconst;
    }

    public void setNconst(String nconst) {
        this.nconst = nconst;
    }

    public String getPrimaryName() {
        return primaryName;
    }

    public void setPrimaryName(String primaryName) {
        this.primaryName = primaryName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(int deathYear) {
        this.deathYear = deathYear;
    }

    public String getPrimaryProfession() {
        return primaryProfession;
    }

    public void setPrimaryProfession(String primaryProfession) {
        this.primaryProfession = primaryProfession;
    }

    public String getKnownForTitles() {
        return knownForTitles;
    }

    public void setKnownForTitles(String knownForTitles) {
        this.knownForTitles = knownForTitles;
    }
}

