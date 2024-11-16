package com.appgame.dslist.service;

import com.appgame.dslist.dto.GameDTO;
import com.appgame.dslist.dto.GameMinDTO;

import java.util.List;

public interface GameService {
    List<GameMinDTO> findAll();
    GameDTO findById(Long id);
    List<GameMinDTO> findByList(Long id);
}
