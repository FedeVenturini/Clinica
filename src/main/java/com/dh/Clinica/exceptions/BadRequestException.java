package com.dh.Clinica.exceptions;

public class BadRequestException extends Exception{

    public BadRequestException(String massage){
        super(massage);
    }

}
