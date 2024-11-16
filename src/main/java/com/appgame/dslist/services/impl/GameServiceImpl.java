package com.appgame.dslist.services.impl;

import com.appgame.dslist.dto.GameDTO;
import com.appgame.dslist.dto.GameMinDTO;
import com.appgame.dslist.entities.Game;
import com.appgame.dslist.exceptions.EntityNotFoundException;
import com.appgame.dslist.repositories.GameRepository;
import com.appgame.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {
    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll() {
        return gameRepository.findAll().stream().map(GameMinDTO::new).toList();
    }

    public GameDTO findById(Long id) {
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity with ID " + id + " not found."));

        return new GameDTO(game);
    }
}