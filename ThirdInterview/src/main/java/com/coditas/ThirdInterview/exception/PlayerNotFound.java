package com.coditas.ThirdInterview.exception;

public class PlayerNotFound extends RuntimeException{

   public PlayerNotFound(){
        super("Player 0ne or Two Not Found");
    }
}
