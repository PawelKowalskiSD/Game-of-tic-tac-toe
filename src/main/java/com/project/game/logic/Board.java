package com.project.game.logic;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<BoardRow> rows = new ArrayList<>();

    public Board() {
        for (int row = 0; row < 3; row++)
            rows.add(new BoardRow());
    }
    // metoda odczytująca znak.
    public Mark getMark(int col, int row) {
        return rows.get(row).getCols().get(col);
    }

    // metoda ustawiająca znak.
    public void setMark(int col, int row, Mark mark) {
        rows.get(row).getCols().set(col, mark);
    }

    public void move(move move) {
        Mark mark = getMark(move.getSetCol(), move.getSetRow());
        setMark(move.getSetCol(), move.getSetRow(), mark);

    }

    @Override
    public String toString() {
        String s = "";
        for (int row = 0; row < 3; row++)
            s+= rows.get(row);
        return s;
    }
}
