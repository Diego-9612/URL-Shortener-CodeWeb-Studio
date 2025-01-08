package com.codeweb_studio.urlshortener.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CodeNotFoundException extends RuntimeException{
    private final String code;

    public CodeNotFoundException(String code) {
        this.code = code;
    }
}
