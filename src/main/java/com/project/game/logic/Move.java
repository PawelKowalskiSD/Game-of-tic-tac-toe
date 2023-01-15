package com.project.game.logic;

public class Move {

    private final int col;
    private final  int row;
    private  final boolean isRestart;

    public Move(int col, int row, boolean isRestart) {
        this.col = col;
        this.row = row;
        this.isRestart = isRestart;
    }

    public Move(int col, int row) {

        this(col, row, false);
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public boolean isRestart() {
        return isRestart;
    }
}
