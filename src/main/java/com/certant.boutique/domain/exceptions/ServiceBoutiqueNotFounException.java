package com.certant.boutique.domain.exceptions;

public class ServiceBoutiqueNotFounException extends RuntimeException{
    public ServiceBoutiqueNotFounException(String message){
        super(message);
    }
}
