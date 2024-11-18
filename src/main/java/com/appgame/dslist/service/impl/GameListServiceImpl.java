package com.appgame.dslist.service.impl;

import com.appgame.dslist.dto.GameListDTO;
import com.appgame.dslist.dto.GameMinDTO;
import com.appgame.dslist.projection.GameMinProjection;
import com.appgame.dslist.repository.GameListRepository;
import com.appgame.dslist.repository.GameRepository;
import com.appgame.dslist.service.GameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListServiceImpl implements GameListService {
    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        return gameListRepository.findAll().stream().map(GameListDTO::new).toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int targetIndex) {
        List<GameMinProjection> list = gameRepository.findByList(listId);

        GameMinProjection game = list.remove(sourceIndex);
        list.add(targetIndex, game);

        int minIndex = Math.min(sourceIndex, targetIndex);
        int maxIndex = Math.max(sourceIndex, targetIndex);

        for (int i = minIndex; i <= maxIndex; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
}
