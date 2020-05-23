package com.Lunatech.IMDB.Model;

import javax.persistence.*;

@Entity
public class TitleRating {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(columnDefinition = "FK_TCONST")
    private TitleBasic tconst;
    //private String tconst;
    @Column(nullable=true)
    private double averageRating;
    @Column(nullable=true)
    private int numVotes;


    public TitleRating() {

    }


    public TitleRating(int id, TitleBasic tconst, double averageRating, int numVotes) {
        this.id = id;
        this.tconst = tconst;
        this.averageRating = averageRating;
        this.numVotes = numVotes;
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

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public int getNumVotes() {
        return numVotes;
    }

    public void setNumVotes(int numVotes) {
        this.numVotes = numVotes;
    }
}
