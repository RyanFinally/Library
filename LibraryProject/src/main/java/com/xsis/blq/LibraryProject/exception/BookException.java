package com.xsis.blq.LibraryProject.exception;

import lombok.Data;

@Data
public class BookException extends RuntimeException{
    private String errorCode;
    public BookException(String message, String errorCode){
        super(message);
        this.errorCode = errorCode;
    }
}
