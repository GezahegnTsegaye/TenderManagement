package com.egov.tendering.audit.exceptions;


/**
 * 
 */
public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String messages){
        super(messages);
    }

}
