package com.coditas.ThirdInterview.exception;



public class PlayerAlreadyExists extends RuntimeException{
    public PlayerAlreadyExists() {
        super("Player Already Exists" );
    }
}
