package com.coditas.ThirdInterview.entities;


import javafx.beans.DefaultProperty;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import javax.persistence.*;


@Entity
@Data
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id", nullable = false)
    private Long playerId;

    @Column(name = "player_email",nullable = false)
    private String email;

    @Column(name = "player_name", nullable = false)
    private String playerName;

    @ColumnDefault("0")
    @Column(name = "player_score", nullable = false)
    private int playerScore;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "game_game_id")
    private Game game;



}
