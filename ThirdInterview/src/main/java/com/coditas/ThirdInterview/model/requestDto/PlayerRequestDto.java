package com.coditas.ThirdInterview.model.requestDto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Data
public class PlayerRequestDto {

    private Long playerId;

    private String playerName;

    private String email;
}
