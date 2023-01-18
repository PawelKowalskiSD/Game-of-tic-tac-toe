package com.project.game.logic;

public class Score {
    private int crossScore;
    private int circleScore;

    public Score(int crossScore, int circleScore) {
        this.crossScore = crossScore;
        this.circleScore = circleScore;
    }

    public int getCrossScore() {
        return crossScore;
    }

    public int getCircleScore() {
        return circleScore;
    }
}
