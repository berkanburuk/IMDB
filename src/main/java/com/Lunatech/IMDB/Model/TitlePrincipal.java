package com.Lunatech.IMDB.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
//@Table(uniqueConstraints = {@UniqueConstraint(columnNames = { "id", "ordering" }) })
public class TitlePrincipal implements Serializable {
    @Id
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    private TitleAkas titleAkas;
/*
    @ManyToOne(optional = false)
    @JoinColumns({
            @JoinColumn(name = "tconst", referencedColumnName = "titleId" ),
            @JoinColumn(name = "ordering", referencedColumnName = "ordering")
    })
    private TitleAkas titleAkas;
    //private String tconst;
    //private int ordering;
*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(columnDefinition = "nconst_name")
    private NameBasic nconst;

    //private String nconst;
    private String category;
    private String job;
    private String characterr;


    public TitlePrincipal() {
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
}
