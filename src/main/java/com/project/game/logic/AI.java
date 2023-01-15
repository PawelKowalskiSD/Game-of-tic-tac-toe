package com.project.game.logic;

import java.util.ArrayList;
import java.util.List;

public class AI {
    public static Move getBestMove(Board board) {
        // 1. zbudowanie listy wszystkich możliwości ruchu komputera
        Symbol computerSymbol = (board.getCharacterSelection() == CharacterSelection.CIRCLE) ?
                Symbol.CIRCLE : Symbol.CROSS;

        List<Move> allPossibleMoves = new ArrayList<>();
        for (int col = 0; col < 3; col++) {
            for (int row = 0; row < 3; row++) {
                if (board.getMark(col, row).getSymbol() == computerSymbol) {
                    addPossibleMoves(col, row, allPossibleMoves, board);
                }
            }
        }



        // 2. Uzupełnie listy ruchów komputera o scoring
        // 3. posortować listę ruchów komputera wg scoringu
        // 4. zwrócić ruch który ma maksymalnąróźnicę punktów na korzyść komputera
        // 5. napisać 3 poziomy trudności komputera
        return null;
    }

    private static void addPossibleMoves(int col, int row, List<Move> allPossibleMoves, Board board) {
        for(NextMark potentialNextMove : board.getMark(col, row).getPossibleMoves()) {
            Board boardCopy = board.deepCopy();
            Move moveToCheck = new Move(potentialNextMove.getCol() + col, potentialNextMove.getRow() + row);
            if(boardCopy.move(moveToCheck)) {
                allPossibleMoves.add(moveToCheck);
            }
        }
    }
}
