package com.egov.tendering.bidding.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BidNotFoundException extends RuntimeException {

    public BidNotFoundException(Long bidId) {
        super("Bid not found with ID: " + bidId);
    }
}