package com.project.game.logic.mark;

import com.project.game.logic.Mark;
import com.project.game.logic.NextMark;
import com.project.game.logic.Symbol;

import java.util.ArrayList;
import java.util.List;

public class Circle implements Mark {

    private final Symbol symbol;

    public Circle(Symbol symbol) {
        this.symbol = symbol;
    }

    @Override
    public Symbol getSymbol() {
        return symbol;
    }

    @Override
    public List<NextMark> getPossibleMoves() {
        List<NextMark> nextMarks = new ArrayList<>();
        addNextCircle(nextMarks, true);
        addNextCircle(nextMarks, false);
        return nextMarks;
    }

    private static void addNextCircle(List<NextMark> nextMarks, boolean canBePlaced) {
        for (int col = 0; col < 3; col++) {
            for (int row = 0; row < 3; row++)
                nextMarks.add(new NextMark(col, row));
        }
    }

    @Override
    public String toString() {
        return "O";
    }

}
