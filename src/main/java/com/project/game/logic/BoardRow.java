package com.project.game.logic;

import com.project.game.logic.mark.None;

import java.util.ArrayList;
import java.util.List;

public class BoardRow {

    private final List<Mark> cols = new ArrayList<>();


    public BoardRow() {
            for (int col = 0; col < 3; col++)
                cols.add(new None());
    }

    public List<Mark> getCols() {
        return cols;
    }

    @Override
    public String toString() {
           String result = getStringBoard();
        return result;
    }

    private String getStringBoard() {
        String s = "|";
        for (int col = 0; col < 3; col++)
            s += cols.get(col) + "|";
        s += "\n";
        return s;
    }
}
