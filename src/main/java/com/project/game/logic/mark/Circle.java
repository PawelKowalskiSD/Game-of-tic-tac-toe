package com.project.game.logic.mark;

import com.project.game.logic.Mark;
import com.project.game.logic.MarkMove;
import com.project.game.logic.Symbol;

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
    public List<MarkMove> getPossibleMoves() {
        return null;
    }

    @Override
    public String toString() {
        return "O";
    }

}
