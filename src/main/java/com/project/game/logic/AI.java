package com.project.game.logic;

import com.project.game.logic.mark.None;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class AI {
    private static Move move;

    public static Move getBestMove(Board board) {
        Symbol computerSymbol = (board.getCharacterSelection() == CharacterSelection.CIRCLE) ?
                Symbol.CIRCLE : Symbol.CROSS;

        Random randomGenerator = new Random();
        List<MoveWithScore> allPossibleMoves = new ArrayList<>();
        for (int col = 0; col < board.getBoardSize(); col++) {
            for (int row = 0; row < board.getBoardSize(); row++) {
                if (computerSymbol != Symbol.CROSS) {
                    addPossibleMoves(col, row, allPossibleMoves, board);
                }
            }
        }
        for (int i = 1; i < allPossibleMoves.size(); i++)
            move = allPossibleMoves.get(randomGenerator.nextInt(i)).getMove();
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
        for (int col = 0; col < board.getBoardSize(); col++) {
            for (int row = 0; row < board.getBoardSize(); row++) {
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
                "com.project.game.logic.mark.Cross", 0,
                "com.project.game.logic.mark.Circle", 0
        );
        return markScores.getOrDefault(mark.getClass().getName(), 0);
    }
}
