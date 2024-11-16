package com.appgame.dslist.repository;

import com.appgame.dslist.model.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {}
