package com.egov.tendering.contract.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ContractNotFoundException extends RuntimeException {

    public ContractNotFoundException(String message) {
        super(message);
    }
}
