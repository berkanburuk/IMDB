package com.Lunatech.IMDB.Model;

import javax.persistence.*;

@Entity
public class TitleEpisode {
     @Id
    private String id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(columnDefinition = "FK_Episode_tconst")
    private TitleBasic tconst;
    //private String tconst;

    //alphanumeric identifier of the parent TV Series
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(columnDefinition = "FK_Episode_parentTConst")
    private TitleBasic parentTconst;
    //private String parentTconst;
    private int seasonNumber;
    private int episodeNumber;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TitleBasic getTconst() {
        return tconst;
    }

    public void setTconst(TitleBasic tconst) {
        this.tconst = tconst;
    }

    public TitleBasic getParentTconst() {
        return parentTconst;
    }

    public void setParentTconst(TitleBasic parentTconst) {
        this.parentTconst = parentTconst;
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(int seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(int episodeNumber) {
        this.episodeNumber = episodeNumber;
    }
}
