package com.appgame.dslist.controller;

import com.appgame.dslist.dto.GameListDTO;
import com.appgame.dslist.dto.GameMinDTO;
import com.appgame.dslist.dto.ReplacementGameDTO;
import com.appgame.dslist.service.GameListService;
import com.appgame.dslist.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll() {
        return gameListService.findAll();
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId) {
        return gameService.findByList(listId);
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementGameDTO body) {
        gameListService.move(listId, body.getSourceIndex(), body.getTargetIndex());
    }
}
