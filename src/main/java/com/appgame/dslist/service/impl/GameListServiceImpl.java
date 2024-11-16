package com.appgame.dslist.service.impl;

import com.appgame.dslist.dto.GameListDTO;
import com.appgame.dslist.repository.GameListRepository;
import com.appgame.dslist.service.GameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListServiceImpl implements GameListService {
    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        return gameListRepository.findAll().stream().map(GameListDTO::new).toList();
    }
}
