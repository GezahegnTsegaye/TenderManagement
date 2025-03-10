package com.egov.tendering.document.exception;

/**
 * Exception thrown when there's an error storing or retrieving a document
 */
public class DocumentStorageException extends RuntimeException {

    public DocumentStorageException(String message) {
        super(message);
    }

    public DocumentStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}