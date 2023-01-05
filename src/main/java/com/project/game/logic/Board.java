package com.project.game.logic;

import com.project.game.logic.mark.Circle;
import com.project.game.logic.mark.Cross;
import com.project.game.logic.mark.None;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private Symbol whoStarts = Symbol.CROSS;
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
    public Symbol oppositeMove(Symbol symbol) {
        return (symbol == Symbol.CROSS ? Symbol.CIRCLE : Symbol.CROSS);
    }

    public boolean move(Move move) {
        boolean result = true;
        if(result) {
            Mark markCross = new Cross(Symbol.CROSS);
            Mark markCircle = new Circle(Symbol.CIRCLE);
            if (whoStarts.equals(markCross.getSymbol())) {
                setMark(move.getCol(), move.getRow(), markCross);
                whoStarts = oppositeMove(whoStarts);
            } else if (whoStarts.equals(markCircle.getSymbol())) {
                setMark(move.getCol(), move.getRow(), markCircle);
                whoStarts = oppositeMove(whoStarts);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        String s = "";
        for (int row = 0; row < 3; row++)
            s+= rows.get(row);
        s += "Next move: " + whoStarts;
        return s;
    }

}
