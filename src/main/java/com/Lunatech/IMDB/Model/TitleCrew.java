package com.Lunatech.IMDB.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class TitleCrew implements Serializable {

    @Id
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(columnDefinition = "FK_TCONST")
    private TitleBasic tconst;
    //private String tconst;
    //nconsts

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(columnDefinition = "FK_Director")
    private NameBasic directors;
    //private Set<NameBasic> directors;
    //nconsts
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(columnDefinition = "FK_Writer")
    private NameBasic writers;
    //private Set<NameBasic> writers;

    public TitleCrew() {
    }

    public TitleCrew(int id, TitleBasic tconst, NameBasic directors, NameBasic writers) {
        this.id = id;
        this.tconst = tconst;
        this.directors = directors;
        this.writers = writers;
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
}
