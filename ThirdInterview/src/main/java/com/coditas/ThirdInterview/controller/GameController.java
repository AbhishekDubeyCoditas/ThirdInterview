package com.coditas.ThirdInterview.controller;

import com.coditas.ThirdInterview.model.requestDto.GameRequestDto;
import com.coditas.ThirdInterview.model.requestDto.PlayerRequestDto;
import com.coditas.ThirdInterview.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    GameService gameService;


    @PostMapping("addGame")
    public ResponseEntity addGame(@RequestBody GameRequestDto gameRequestDto){
        try {
            return new ResponseEntity(Optional.of(gameService.addGame(gameRequestDto)), HttpStatus.CREATED);
        }catch (Exception exception){
            return new ResponseEntity(exception, HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
