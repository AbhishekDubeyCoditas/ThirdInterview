package com.coditas.ThirdInterview.services;

import com.coditas.ThirdInterview.entities.Game;
import com.coditas.ThirdInterview.entities.Player;
import com.coditas.ThirdInterview.exception.GameNameAlreadyExists;
import com.coditas.ThirdInterview.exception.PlayerNotFound;
import com.coditas.ThirdInterview.model.requestDto.GameRequestDto;
import com.coditas.ThirdInterview.repository.GameRepository;
import com.coditas.ThirdInterview.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class GameServiceImplementation implements GameService {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    PlayerRepository playerRepository;

    @Override
    public Game addGame(GameRequestDto gameRequestDto) {

        System.out.println(gameRequestDto);
     Game game = new Game();
     Game foundGame = gameRepository.findByGameName(gameRequestDto.getGameName());

     if(foundGame != null){
         throw new GameNameAlreadyExists();
     }else {
         game.setGameId(gameRequestDto.getGameId());
         game.setGameName(gameRequestDto.getGameName());

         Player playerOne =playerRepository.findById(gameRequestDto.getPlayerOneId()).orElse(null);
         Player playerTwo = playerRepository.findById(gameRequestDto.getPlayerTwoId()).orElse(null);

         if (playerOne == null || playerTwo == null){
             throw  new PlayerNotFound();
         }else {
             List<Player> inGamePlayersList = new ArrayList<>();
             inGamePlayersList.add(playerOne);
             inGamePlayersList.add(playerTwo);
             game.setPlayers(inGamePlayersList);
         }
     }
        System.out.println(game);
     return gameRepository.save(game);
    }


}
