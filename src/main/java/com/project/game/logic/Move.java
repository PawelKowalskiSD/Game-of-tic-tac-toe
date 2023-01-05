package com.project.game.logic;

public class Move {

    private final int col;
    private final  int row;

    public Move(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }
}
