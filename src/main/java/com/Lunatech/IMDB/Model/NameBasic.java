package com.Lunatech.IMDB.Model;

import com.sun.istack.Nullable;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class NameBasic  {
    @Id
    private String nconst;

    private String primaryName;
    //@Value("${some.key:-1}")
    @Column(nullable=true)
    private Integer birthYear;
    //@Value("${some.key:-1}")
    @Column(nullable=true)
    private Integer deathYear;

    private String primaryProfession;
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

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(Integer deathYear) {
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

    @Override
    public String toString() {
        return "NameBasic{" +
                "nconst='" + nconst + '\'' +
                ", primaryName='" + primaryName + '\'' +
                ", birthYear=" + birthYear +
                ", deathYear=" + deathYear +
                ", primaryProfession='" + primaryProfession + '\'' +
                ", knownForTitles='" + knownForTitles + '\'' +
                '}';
    }
}

