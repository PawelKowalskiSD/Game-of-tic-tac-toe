package com.project.game.logic;

import com.project.game.logic.mark.Circle;
import com.project.game.logic.mark.Cross;
import com.project.game.logic.mark.None;

public class MarkFactory {
    public static Mark createMarkCopy(Mark mark) {
        Symbol symbol = mark.getSymbol();
        if(mark instanceof Circle)
            return new Circle(symbol);
        if(mark instanceof Cross)
            return new Cross(symbol);
        if(mark instanceof None)
            return new None();
        throw new RuntimeException("Bad Symbol has been found on Board");
    }
}
