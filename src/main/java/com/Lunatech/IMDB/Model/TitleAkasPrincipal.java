package com.Lunatech.IMDB.Model;

import java.io.Serializable;
import java.util.Objects;

public class TitleAkasPrincipal implements Serializable {
    private String titleId;
    private int ordering;

    public TitleAkasPrincipal() {
    }

    public TitleAkasPrincipal(String titleId, int ordering) {
        this.titleId = titleId;
        this.ordering = ordering;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TitleAkasPrincipal)) return false;
        TitleAkasPrincipal that = (TitleAkasPrincipal) o;
        return ordering == that.ordering &&
                Objects.equals(titleId, that.titleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titleId, ordering);
    }
}
