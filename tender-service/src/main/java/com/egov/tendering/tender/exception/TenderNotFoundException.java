package com.egov.tendering.tender.exception;



import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



@ResponseStatus(HttpStatus.NOT_FOUND)
public class TenderNotFoundException extends RuntimeException {

    public TenderNotFoundException(Long tenderId) {
        super("Tender not found with ID: " + tenderId);
    }
    public TenderNotFoundException(String tenderId) {
        super("Tender not found with ID: " + tenderId);
    }
}
