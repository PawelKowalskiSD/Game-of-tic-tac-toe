package com.project.game.logic;

public class MoveWithScore {
    private Move move;
    private Score score;

    public MoveWithScore(Move move, Score score) {
        this.move = move;
        this.score = score;
    }

    public Move getMove() {
        return move;
    }

    public Score getScore() {
        return score;
    }
}
