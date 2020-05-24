package com.Lunatech.IMDB.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class TitlePrincipal implements Serializable {
    @Id
    //@GeneratedValue(strategy=GenerationType.SEQUENCE)
    @GeneratedValue
    private int id;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    private TitleAkas titleAkas;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(columnDefinition = "nconst_name")
    private NameBasic nconst;

    private String category;
    private String job;
    private String characterr;


    public TitlePrincipal() {
    }

    public TitlePrincipal(int id, TitleAkas titleAkas, NameBasic nconst, String category, String job, String characterr) {
        this.id = id;
        this.titleAkas = titleAkas;
        this.nconst = nconst;
        this.category = category;
        this.job = job;
        this.characterr = characterr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TitleAkas getTitleAkas() {
        return titleAkas;
    }

    public void setTitleAkas(TitleAkas titleAkas) {
        this.titleAkas = titleAkas;
    }

    public NameBasic getNconst() {
        return nconst;
    }

    public void setNconst(NameBasic nconst) {
        this.nconst = nconst;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getCharacterr() {
        return characterr;
    }

    public void setCharacterr(String characterr) {
        this.characterr = characterr;
    }

    @Override
    public String toString() {
        return "TitlePrincipal{" +
                "id=" + id +
                ", titleAkas=" + titleAkas +
                ", nconst=" + nconst +
                ", category='" + category + '\'' +
                ", job='" + job + '\'' +
                ", characterr='" + characterr + '\'' +
                '}';
    }
}
