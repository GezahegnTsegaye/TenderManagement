package com.tms.exceptions;


/**
 * 
 */
public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String messages){
        super(messages);
    }

}
