package com.appgame.dslist.dto;

public class ReplacementGameDTO {
    private final int sourceIndex;
    private final int targetIndex;

    public ReplacementGameDTO(int sourceIndex, int targetIndex) {
        this.sourceIndex = sourceIndex;
        this.targetIndex = targetIndex;
    }

    public int getSourceIndex() {
        return sourceIndex;
    }

    public int getTargetIndex() {
        return targetIndex;
    }
}
