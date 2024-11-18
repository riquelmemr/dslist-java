package com.appgame.dslist.service;

import com.appgame.dslist.dto.GameListDTO;

import java.util.List;

public interface GameListService {
    List<GameListDTO> findAll();
    void move(Long listId, int sourceIndex, int targetIndex);
}
