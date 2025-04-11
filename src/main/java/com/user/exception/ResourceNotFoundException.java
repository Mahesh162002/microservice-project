package com.user.exception;

//Extra properties the you want to mange

public class ResourceNotFoundException extends RuntimeException{

    public  ResourceNotFoundException(){
        super("Resouce not found Server !! ");
    }

    public ResourceNotFoundException(String message){
        super("message");
    }
}
