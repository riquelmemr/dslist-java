package com.appgame.dslist.service.impl;

import com.appgame.dslist.dto.GameDTO;
import com.appgame.dslist.dto.GameMinDTO;
import com.appgame.dslist.model.Game;
import com.appgame.dslist.exception.EntityNotFoundException;
import com.appgame.dslist.repository.GameRepository;
import com.appgame.dslist.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {
    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        return gameRepository.findAll().stream().map(GameMinDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity with ID " + id + " not found."));

        return new GameDTO(game);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long id) {
        return gameRepository.findByList(id).stream().map(GameMinDTO::new).toList();
    }
}
