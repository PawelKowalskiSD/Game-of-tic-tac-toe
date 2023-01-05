package com.project.game.logic;

public class NextMark {
    private final int col;
    private final int row;

    public NextMark(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    @Override
    public String toString() {
        return "NextMark{" +
                "col=" + col +
                ", row=" + row +
                '}';
    }
}
