package com.coditas.ThirdInterview.repository;

import com.coditas.ThirdInterview.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player,Long> {
    Player findByEmail(String email);

    List<Player> findByOrderByPlayerScoreDesc();

}
