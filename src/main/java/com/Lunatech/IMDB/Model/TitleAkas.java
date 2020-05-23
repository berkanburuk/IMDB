package com.Lunatech.IMDB.Model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@IdClass(TitleAkasPrincipal.class)
public class TitleAkas implements Serializable{
    @Id
    private String titleId;
    @Id
    private int ordering;


    private String title;
    private String region;
    private String language;
    // private ArrayList<String> types;
    private String types;
    //private String[] attributes;
    private String attributes;
    //0-> Not, 1->Original
    private boolean isOriginalTitle;


    public TitleAkas() {
    }

    public TitleAkas(String titleId, int ordering, String title, String region, String language, String types, String attributes, boolean isOriginalTitle) {
        this.titleId = titleId;
        this.ordering = ordering;
        this.title = title;
        this.region = region;
        this.language = language;
        this.types = types;
        this.attributes = attributes;
        this.isOriginalTitle = isOriginalTitle;
    }

    public String getTitleId() {
        return titleId;
    }

    public void setTitleId(String titleId) {
        this.titleId = titleId;
    }

    public int getOrdering() {
        return ordering;
    }

    public void setOrdering(int ordering) {
        this.ordering = ordering;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    public boolean isOriginalTitle() {
        return isOriginalTitle;
    }

    public void setOriginalTitle(boolean originalTitle) {
        isOriginalTitle = originalTitle;
    }

}
