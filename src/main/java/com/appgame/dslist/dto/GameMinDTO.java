package com.appgame.dslist.dto;

import com.appgame.dslist.entities.Game;

public class GameMinDTO {
    private final Long id;
    private final String title;
    private final Integer year;
    private final String imgUrl;
    private final String shortDescription;

    public GameMinDTO(Game game) {
        id = game.getId();
        title = game.getTitle();
        year = game.getYear();
        imgUrl = game.getImgUrl();
        shortDescription = game.getShortDescription();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }
}
