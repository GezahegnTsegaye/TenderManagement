package com.egov.tendering.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



@ResponseStatus(HttpStatus.NOT_FOUND)
public class OrganizationNotFoundException extends RuntimeException {

    public OrganizationNotFoundException(Long organizationId) {
        super("Organization not found with ID: " + organizationId);
    }

    public OrganizationNotFoundException(String message) {
        super(message);
    }
}
