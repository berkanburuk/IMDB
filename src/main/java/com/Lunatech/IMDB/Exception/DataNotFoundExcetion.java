package com.Lunatech.IMDB.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DataNotFoundExcetion extends RuntimeException {
    private String message;
    public DataNotFoundExcetion(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return message;
    }
}
