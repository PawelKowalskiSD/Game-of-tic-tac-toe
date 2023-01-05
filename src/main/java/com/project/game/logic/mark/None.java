package com.project.game.logic.mark;

import com.project.game.logic.Mark;
import com.project.game.logic.MarkMove;
import com.project.game.logic.Symbol;

import java.util.List;

public class None implements Mark {

    @Override
    public Symbol getSymbol() {
        return Symbol.NONE;
    }

    @Override
    public List<MarkMove> getPossibleMoves() {
        return null;
    }

    @Override
    public String toString() {
        return " ";
    }
}
