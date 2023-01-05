package com.project.game;

import com.project.game.logic.Board;
import com.project.game.logic.Move;
import com.project.game.ui.text.UserDialogs;

public class App {
    public static void main(String[] args) {
        Board board = new Board();
        System.out.println(board);
        while (true) {
            Move move = UserDialogs.getNextMove();
            if (board.move(move)) {

            }
            System.out.println(board);
        }
    }

}
