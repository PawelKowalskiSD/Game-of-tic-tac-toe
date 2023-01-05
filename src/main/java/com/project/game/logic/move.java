package com.project.game.logic;

public class move {

    private final int setCol;
    private final int setRow;

    public move(int setCol, int setRow) {
        this.setCol = setCol;
        this.setRow = setRow;
    }

    public int getSetCol() {
        return setCol;
    }

    public int getSetRow() {
        return setRow;
    }
}
