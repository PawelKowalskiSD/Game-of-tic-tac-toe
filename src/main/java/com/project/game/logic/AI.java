package com.project.game.logic;

import com.project.game.logic.mark.None;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class AI {
    static Move move;
    public static Move getBestMove(Board board) {
        // 1. zbudowanie listy wszystkich możliwości ruchu komputera
        // 2. Uzupełnie listy ruchów komputera o scoring
        Symbol computerSymbol = (board.getCharacterSelection() == CharacterSelection.CIRCLE) ?
                Symbol.CIRCLE : Symbol.CROSS;

        Random randomGenerator = new Random();
        List<MoveWithScore> allPossibleMoves = new ArrayList<>();
        for (int col = 0; col < 3; col++) {
            for (int row = 0; row < 3; row++) {

                if (computerSymbol != Symbol.CROSS) {
                    addPossibleMoves(col, row, allPossibleMoves, board);

                }

            }
        }
//         move = new Move(randomGenerator.nextInt(2), randomGenerator.nextInt(2));
        for (int i = 1; i < allPossibleMoves.size(); i++)
               move = allPossibleMoves.get(randomGenerator.nextInt(i)).getMove();

        System.out.println(move.getCol() + "" + move.getRow());

        // 3. posortować listę ruchów komputera wg scoringu
        // 4. zwrócić ruch który ma maksymalnąróźnicę punktów na korzyść komputera
        // 5. napisać 3 poziomy trudności komputera


        return move;
    }
    private static void addPossibleMoves(int col, int row, List<MoveWithScore> allPossibleMoves, Board board) {


        if (board.getMark(col, row) instanceof None) {

            Board boardCopy = board.deepCopy();
            Move moveToCheck = new Move(col, row);
            if (boardCopy.move(moveToCheck)) {
                Score score = calculateScore(boardCopy);
                allPossibleMoves.add(new MoveWithScore(moveToCheck, score));
            }
        }
    }

    private static Score calculateScore(Board board) {
        int crossScore = 0;
        int circleScore = 0;
        for (int col = 0; col < 3; col++) {
            for (int row = 0; row < 3; row++) {
                Mark mark = board.getMark(col, row);
                int score = calculateScoreForMark(mark);
                if (mark.getSymbol() == Symbol.CROSS) {
                    crossScore += score;
                } else if (mark.getSymbol() == Symbol.CIRCLE) {
                    circleScore += score;
                }
            }
        }
        return new Score(crossScore, circleScore);
    }

    private static int calculateScoreForMark(Mark mark) {
        Map<String, Integer> markScores = Map.of(
                "com.project.game.logic.mark.Cross", 1,
                "com.project.game.logic.mark.Circle", 1
        );
        return markScores.getOrDefault(mark.getClass().getName(), 0);
    }

//    private static int minimax(int depth, Board board) {
//        // Base case: game over or maximum depth reached
//        if (board.isWinner() || depth == 0) {
//            return score();
//        }
//
//        int bestScore;
//        if ( ==1){
//            bestScore = Integer.MIN_VALUE;
//        } else{
//            bestScore = Integer.MAX_VALUE;
//        }
//
//        for (int i = 0; i < possibleMoves().size(); i++) {
//            if (posibleMoves().get(i) == new None()) {
//                if (player == 1) {
//                    possibleMOves().get(i) = new Cross(Symbol.CROSS);
//                } else {
//                    possibleMoves().get(i) = new Circle(Symbol.CIRCLE);
//                }
//            }
//
//            int score = minimax(depth - 1, -player);
//
//            if (player == 1) {
//                if (score > bestScore) {
//                    bestScore = score;
//                }
//            } else {
//                if (score < bestScore) {
//                    bestScore = score;
//                }
//            }
//
//            possibleMoves().get(i) = new None;
//        }
//
//        return bestScore;
//    }
}
