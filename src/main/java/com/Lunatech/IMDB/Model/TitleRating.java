package com.Lunatech.IMDB.Model;

import javax.persistence.*;

@Entity
public class TitleRating {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(columnDefinition = "FK_TCONST")
    private TitleBasic tconst;

    @Column(nullable=true)
    private double averageRating;
    @Column(nullable=true)
    private Integer numVotes;


    public TitleRating() {
    }


    public TitleRating(int id, TitleBasic tconst, double averageRating, int numVotes) {
        this.id = id;
        this.tconst = tconst;
        this.averageRating = averageRating;
        this.numVotes = numVotes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getNumVotes() {
        return numVotes;
    }

    public void setNumVotes(Integer numVotes) {
        this.numVotes = numVotes;
    }

    @Override
    public String toString() {
        return "TitleRating{" +
                "id=" + id +
                ", tconst=" + tconst +
                ", averageRating=" + averageRating +
                ", numVotes=" + numVotes +
                '}';
    }
}
