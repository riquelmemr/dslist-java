package com.appgame.dslist.dto;

import com.appgame.dslist.model.GameList;

public class GameListDTO {
    private final Long id;
    private final String name;

    public GameListDTO(GameList gameList) {
        this.id = gameList.getId();
        this.name = gameList.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
