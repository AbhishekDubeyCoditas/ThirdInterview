package com.coditas.ThirdInterview.model.requestDto;


import lombok.Data;

@Data
public class GameRequestDto {

    private Long gameId;
    private String gameName;
    private Long playerOneId;
    private Long playerTwoId;
}
