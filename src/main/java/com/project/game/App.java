package com.project.game;

import com.project.game.logic.AI;
import com.project.game.logic.Board;
import com.project.game.logic.CharacterSelection;
import com.project.game.logic.Move;
import com.project.game.ui.text.UserDialogs;

public class App {
    public static void main(String[] args) {
        Board board = new Board(true, CharacterSelection.CIRCLE);
        System.out.println(board);
        while (true) {
            Move move = UserDialogs.getNextMove();
            if(move.isRestart()) {

            } else if (board.move(move)) {
                if(board.isGameWithComputer()) {
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
