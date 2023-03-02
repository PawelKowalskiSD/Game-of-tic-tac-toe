package com.project.game;

import com.project.game.logic.*;
import com.project.game.ui.text.UserDialogs;

public class App {
    public static void main(String[] args) {
        Board board = new Board(true, CharacterSelection.CIRCLE, 5);
        System.out.println(board);
        while (true) {
            Move move = UserDialogs.getNextMove(board);
            if (move.isRestart()) {
            } else if (board.move(move)) {
                if (board.isGameWithComputer() && !board.isWinner(board) && !board.thereAreNoEmptyFields()) {
                    Move computerMove = AI.getBestMove(board);
                    board.move(computerMove);
                }
                if (board.isWinner(board) || board.thereAreNoEmptyFields()) {
                    System.out.println(board);
                    System.out.println();
                    break;
                }
            }
            System.out.println(board);

        }
    }
}
