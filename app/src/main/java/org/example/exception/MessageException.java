package org.example.exception;

public class MessageException extends Exception{

    public MessageException(String e){
        super(e);
    }

    public String getMessage() {
        return super.getMessage();
    }
}
