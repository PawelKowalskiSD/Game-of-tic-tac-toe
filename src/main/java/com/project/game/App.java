package com.project.game;

import com.project.game.logic.*;
import com.project.game.ui.text.UserDialogs;

public class App {
    public static void main(String[] args) {
        Board board = new Board(false, CharacterSelection.CIRCLE, 10);
        System.out.println(board);
        while (true) {
            Move move = UserDialogs.getNextMove();
            if(move.isRestart()) {

            } else if (board.move(move)) {
                if(board.isGameWithComputer() && !board.isWinner() && !board.thereAreNoEmptyFields()) {
                    Move computerMove = AI.getBestMove(board);
                    board.move(computerMove);
                }
                if(board.isWinner() ||  board.thereAreNoEmptyFields()) {
                    System.out.println(board);
                    System.out.println();
                    break;
                }
            }
                System.out.println(board);

        }
    }
}
