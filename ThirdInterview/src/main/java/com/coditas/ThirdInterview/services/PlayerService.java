package com.coditas.ThirdInterview.services;

import com.coditas.ThirdInterview.entities.Player;
import com.coditas.ThirdInterview.entities.Position;
import com.coditas.ThirdInterview.model.requestDto.PlayerRequestDto;
import com.coditas.ThirdInterview.model.responseDto.PlayerResponseDto;

import java.util.List;

public interface PlayerService {


    Player addPlayer(PlayerRequestDto playerRequestDto);

    List<Player> fetchPlayers();

     List<Player> viewLeaderBoard();

    boolean Fire(Position position);


}
