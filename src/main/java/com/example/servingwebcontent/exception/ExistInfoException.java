package com.example.servingwebcontent.exception;

public class ExistInfoException extends RuntimeException{
    public ExistInfoException(String message){
        super(message);
        //TODO Возвращать ResponseEntity с кодом ошибки
    }
}
