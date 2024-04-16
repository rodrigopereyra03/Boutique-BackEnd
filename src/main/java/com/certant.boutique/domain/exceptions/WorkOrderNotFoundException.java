package com.certant.boutique.domain.exceptions;

public class WorkOrderNotFoundException extends RuntimeException{

    public WorkOrderNotFoundException(String message){
        super(message);
    }
}
