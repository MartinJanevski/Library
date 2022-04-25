package com.example.library.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class NoCopiesLeftException extends RuntimeException{
    public NoCopiesLeftException(Long id) {
        super(String.format("Book with id: %d has no copies left", id));
    }
}
