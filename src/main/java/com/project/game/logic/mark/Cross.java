package com.project.game.logic.mark;

import com.project.game.logic.Mark;
import com.project.game.logic.NextMark;
import com.project.game.logic.Symbol;

import java.util.ArrayList;
import java.util.List;

public class Cross implements Mark {

    private Symbol symbol;

    public Cross(Symbol symbol) {
        this.symbol = symbol;
    }

    @Override
    public Symbol getSymbol() {
        return symbol;
    }

    @Override
    public List<NextMark> getPossibleMoves() {
        List<NextMark> nextMarks = new ArrayList<>();
        addNextCross(nextMarks, true);
        addNextCross(nextMarks, false);
        return nextMarks;
    }

    private static void addNextCross(List<NextMark> nextMarks, boolean canBePlaced) {
        for (int col = 0; col < 3; col++) {
            for (int row = 0; row < 3; row++)
                nextMarks.add(new NextMark(col, row));
        }
    }

    @Override
    public String toString() {
        return "X";
    }
}
