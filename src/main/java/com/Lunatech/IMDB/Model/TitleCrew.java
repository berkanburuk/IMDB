package com.Lunatech.IMDB.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class TitleCrew implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(columnDefinition = "FK_TCONST")
    private TitleBasic tconst;
    //private String tconst;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(columnDefinition = "FK_Director")
    private NameBasic directors;
    //private Set<NameBasic> directors;
    //nconsts
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(columnDefinition = "FK_Writer")
    private NameBasic writers;
    //private Set<NameBasic> writers;

    public TitleCrew() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TitleBasic getTconst() {
        return tconst;
    }

    public void setTconst(TitleBasic tconst) {
        this.tconst = tconst;
    }

    public NameBasic getDirectors() {
        return directors;
    }

    public void setDirectors(NameBasic directors) {
        this.directors = directors;
    }

    public NameBasic getWriters() {
        return writers;
    }

    public void setWriters(NameBasic writers) {
        this.writers = writers;
    }

    @Override
    public String toString() {
        return "TitleCrew{" +
                "id=" + id +
                ", tconst=" + tconst +
                ", directors=" + directors +
                ", writers=" + writers +
                '}';
    }
}
