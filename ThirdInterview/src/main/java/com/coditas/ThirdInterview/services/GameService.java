package com.coditas.ThirdInterview.services;

import com.coditas.ThirdInterview.entities.Game;
import com.coditas.ThirdInterview.model.requestDto.GameRequestDto;

public interface GameService {

    Game addGame(GameRequestDto gameRequestDto);


}
