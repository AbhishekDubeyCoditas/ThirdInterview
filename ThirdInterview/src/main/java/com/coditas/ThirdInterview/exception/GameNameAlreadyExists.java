package com.coditas.ThirdInterview.exception;

public class GameNameAlreadyExists extends RuntimeException {

    public  GameNameAlreadyExists(){
        super("Game Name Already Exists, change game name");
    }

}
