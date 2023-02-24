package com.project.game.logic;

import com.project.game.logic.mark.None;

import java.util.ArrayList;
import java.util.List;

public class BoardRow {

    private final List<Mark> cols = new ArrayList<>();

    public BoardRow(int boardSize) {
            for (int col = 0; col < boardSize ; col++)
                cols.add(new None());
    }

    public List<Mark> getCols() {
        return cols;
    }

    @Override
    public String toString() {
        String s = "|";
        for (int col = 0; col < cols.size(); col++)
            s += cols.get(col) + "|";
        s += "\n";
        return s;
    }
}
