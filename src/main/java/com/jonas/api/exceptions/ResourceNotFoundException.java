package com.jonas.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    /**
     * long - serialVersionUID.
     */                                          
    private static final long serialVersionUID = 2769609283135520674L;

}
