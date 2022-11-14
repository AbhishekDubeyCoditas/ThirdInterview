package com.coditas.ThirdInterview.repository;

import com.coditas.ThirdInterview.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game,Long> {
    Game findByGameName(String gameName);


}
