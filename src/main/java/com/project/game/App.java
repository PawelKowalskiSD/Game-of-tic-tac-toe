package com.project.game;

import com.project.game.logic.Board;
import com.project.game.logic.Symbol;
import com.project.game.logic.mark.Circle;
import com.project.game.logic.mark.Cross;

public class App {
    public static void main(String[] args) {
        Board board = new Board();
        System.out.println(board);
        board.setMark(0, 0, new Cross(Symbol.CROSS));
        System.out.println(board);
        board.setMark(0, 1, new Circle(Symbol.CIRCLE));
        System.out.println(board);
    }
}
