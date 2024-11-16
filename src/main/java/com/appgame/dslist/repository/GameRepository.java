package com.appgame.dslist.repository;

import com.appgame.dslist.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {}
