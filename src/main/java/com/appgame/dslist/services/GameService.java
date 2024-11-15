package com.appgame.dslist.services;

import com.appgame.dslist.dto.GameMinDTO;
import com.appgame.dslist.entities.Game;
import com.appgame.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll() {
        return gameRepository.findAll().stream().map(GameMinDTO::new).toList();
    }
}
