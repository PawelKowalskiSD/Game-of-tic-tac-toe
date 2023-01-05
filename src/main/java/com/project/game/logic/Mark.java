package com.project.game.logic;

import java.util.List;

public interface Mark {
    Symbol getSymbol();
    List<NextMark> getPossibleMoves();
}
