package com.example.communitymember.config.exeptions;

public class CommunitySaveException extends Exception{
    public CommunitySaveException(Exception e){
        super(e.getMessage());
    }
}
