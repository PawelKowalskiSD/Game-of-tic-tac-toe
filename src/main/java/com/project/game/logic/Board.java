package com.project.game.logic;

import com.project.game.logic.mark.Circle;
import com.project.game.logic.mark.Cross;
import com.project.game.logic.mark.None;

import java.util.ArrayList;
import java.util.List;


public class Board {

    private Symbol whoStarts = Symbol.CROSS;
    private final List<BoardRow> rows = new ArrayList<>();
    private Move move;

    public Board() {
        for (int row = 0; row < 3; row++)
            rows.add(new BoardRow());
    }

    public Mark getMark(int col, int row) {
        return rows.get(row).getCols().get(col);
    }

    public void setMark(int col, int row, Mark mark) {
        rows.get(row).getCols().set(col, mark);
    }
    public Symbol oppositeMove(Symbol symbol) {
        return (symbol == Symbol.CROSS ? Symbol.CIRCLE : Symbol.CROSS);
    }

    public boolean move(Move move) {
        boolean result = true;
        result = result && checkPossibleMove(move);
        result = result && checkSymbol(move);
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

    private boolean checkSymbol(Move move) {
        return !(getMark(move.getCol(), move.getRow()).getSymbol() == whoStarts);
    }

    private boolean checkPossibleMove(Move move) {
        try {
            if(!(getMark(move.getCol(), move.getRow()) instanceof None))
                throw new Exception();
        } catch (Exception e) {
            System.out.println("Wrong move, try again.");
        }
        return (getMark(move.getCol(), move.getRow()) instanceof None);
    }

    @Override
    public String toString() {
        String s = "";
        for (int row = 0; row < 3; row++)
            s+= rows.get(row);
        s += gameplay();
        return s;
    }

    private String gameplay() {
        if(isWinner()) {
            return "Win " + oppositeMove(whoStarts);
        } else if (thereAreNoEmptyFields()) {
            return "draw";
        }
        return "Next move: " + whoStarts;
    }

    public boolean isWinner() {
            for (int col = 0; col < 3; col++) {
                if (getMark(col, 0).getSymbol() == getMark(col, 1).getSymbol() &&
                    getMark(col, 1).getSymbol() == getMark(col, 2).getSymbol() &&
                    getMark(col, 0).getSymbol() != Symbol.NONE) {
                    return true;
                }
            }
            for (int row = 0; row < 3; row++) {
                if (getMark(0, row).getSymbol() == getMark(1, row).getSymbol() &&
                    getMark(1, row).getSymbol() == getMark(2, row).getSymbol() &&
                    getMark(0, row).getSymbol() != Symbol.NONE) {
                    return true;
                }
            }
            if (getMark(0,0).getSymbol() == getMark(1,1).getSymbol() &&
                getMark(0,0).getSymbol() == getMark(2,2).getSymbol() &&
                getMark(0,0).getSymbol() != Symbol.NONE) {
                return true;
            }
            if (getMark(0,2).getSymbol() == getMark(1,1).getSymbol() &&
                getMark(0,2).getSymbol() == getMark(2,0).getSymbol() &&
                getMark(0,2).getSymbol() != Symbol.NONE) {
                return true;
            }
            return false;
    }

    public boolean thereAreNoEmptyFields() {
        if (!(getMark(0,1).getSymbol().equals(Symbol.NONE)) &&
            !(getMark(0,2).getSymbol().equals(Symbol.NONE)) &&
            !(getMark(1,0).getSymbol().equals(Symbol.NONE)) &&
            !(getMark(1,1).getSymbol().equals(Symbol.NONE)) &&
            !(getMark(1,2).getSymbol().equals(Symbol.NONE)) &&
            !(getMark(2,0).getSymbol().equals(Symbol.NONE)) &&
            !(getMark(2,1).getSymbol().equals(Symbol.NONE)) &&
            !(getMark(2,2).getSymbol().equals(Symbol.NONE))) {
            return true;
       }
        return false;
    }
}
