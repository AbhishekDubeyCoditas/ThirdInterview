package com.coditas.ThirdInterview.controller;


import com.coditas.ThirdInterview.model.requestDto.PlayerRequestDto;
import com.coditas.ThirdInterview.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("player")
public class PlayerController {

    @Autowired
    PlayerService playerService;


    @PostMapping("registerPlayer")
    public ResponseEntity registerPlayer(@RequestBody PlayerRequestDto playerRequestDto){
        try {
            return new ResponseEntity(Optional.of(playerService.addPlayer(playerRequestDto)), HttpStatus.CREATED);
        }catch (Exception exception){
          return new ResponseEntity(exception, HttpStatus.NOT_ACCEPTABLE);
        }
    }


    @GetMapping("getPlayers")
    public ResponseEntity getPlayers(){
        try {
            return new ResponseEntity(Optional.of(playerService.fetchPlayers()), HttpStatus.FOUND);
        }catch (Exception exception){
            return new ResponseEntity(exception,HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("viewLeaderBoard")
    public ResponseEntity viewLeaderBoard(){
        try {
            return new ResponseEntity(Optional.of(playerService.viewLeaderBoard()),HttpStatus.FOUND);
        }catch (Exception exception){
            return new ResponseEntity(exception,HttpStatus.NOT_FOUND);
        }
    }


}
