package com.coditas.ThirdInterview.services;

import com.coditas.ThirdInterview.entities.Player;
import com.coditas.ThirdInterview.entities.Position;
import com.coditas.ThirdInterview.exception.NoPlayersFound;
import com.coditas.ThirdInterview.exception.PlayerAlreadyExists;
import com.coditas.ThirdInterview.model.requestDto.PlayerRequestDto;
import com.coditas.ThirdInterview.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PlayerServiceImplementation implements PlayerService{

    @Autowired
    PlayerRepository playerRepository;


    @Override
    public Player addPlayer(PlayerRequestDto playerRequestDto) {

        System.out.println(playerRequestDto);
        Player player = new Player();
        Player foundPlayer=playerRepository.findByEmail(playerRequestDto.getEmail());

        if(foundPlayer!= null){
         throw new PlayerAlreadyExists();
        }else {
            player.setPlayerId(playerRequestDto.getPlayerId());
            player.setEmail(playerRequestDto.getEmail());
            player.setPlayerName(playerRequestDto.getPlayerName());
            System.out.println(player);
            return playerRepository.save(player);
        }
    }

    @Override
    public List<Player> fetchPlayers() {
        List<Player> players = playerRepository.findAll();

        if (players.size() == 0){
            throw new NoPlayersFound();
        }else
      return players;
    }


   public List<Player> viewLeaderBoard(){
        List<Player> leaderboard = playerRepository.findByOrderByPlayerScoreDesc();

        if (leaderboard.size() ==0){
            throw new NoPlayersFound();
        }else
            return leaderboard;
    }

    @Override
    public boolean Fire(Position position) {
        return false;
    }


}
