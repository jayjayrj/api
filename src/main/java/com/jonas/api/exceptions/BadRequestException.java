package com.jonas.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

    /**
     * long - serialVersionUID.
     */
    private static final long serialVersionUID = -2397618613544624782L;


}
