package com.project.game;

import com.project.game.logic.Board;
import com.project.game.logic.Symbol;
import com.project.game.logic.mark.Circle;
import com.project.game.logic.mark.Cross;
import com.project.game.logic.move;

public class App {
    public static void main(String[] args) {
        Board board = new Board();
        System.out.println(board);
        board.move(new move(0, 0));
        board.setMark(0, 0, new Cross(Symbol.CROSS));
        System.out.println(board);
        board.move(new move(0, 1));
        board.setMark(0, 1, new Circle(Symbol.CIRCLE));
        System.out.println(board);
    }
}
