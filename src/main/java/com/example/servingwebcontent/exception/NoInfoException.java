package com.example.servingwebcontent.exception;

public class NoInfoException extends RuntimeException{
    public NoInfoException(String message){
        super(message);
        //TODO Возвращать ResponseEntity с кодом ошибки

    }
}
