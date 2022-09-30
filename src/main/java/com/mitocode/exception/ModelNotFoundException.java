package com.mitocode.exception;


//@ResponseStatus(HttpStatus.NOT_FOUND)
@SuppressWarnings("serial")
public class ModelNotFoundException extends RuntimeException {

    public ModelNotFoundException(String msg){
        super(msg);
    }
}

