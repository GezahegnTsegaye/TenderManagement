package com.egov.tendering.bidding.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidBidStateException extends RuntimeException {

    public InvalidBidStateException(String message) {
        super(message);
    }
}