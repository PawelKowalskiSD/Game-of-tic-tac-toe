package com.project.game.logic;

import com.project.game.logic.mark.Circle;
import com.project.game.logic.mark.Cross;
import com.project.game.logic.mark.None;

import java.util.ArrayList;
import java.util.List;

public class Board {

    Symbol whoStarts = Symbol.CROSS;
    private final List<BoardRow> rows = new ArrayList<>();
    private CharacterSelection characterSelection = CharacterSelection.CROSS;
    private boolean gameWithComputer;
    private int boardSize;

    public Board() {

    }

    public Board(boolean gameWithComputer, CharacterSelection characterSelection, int boardSize) {
        this.characterSelection = characterSelection;
        this.gameWithComputer = gameWithComputer;
        this.boardSize = boardSize;
        for (int row = 0; row < getBoardSize(); row++)
            rows.add(new BoardRow(boardSize));
    }

    public Mark getMark(int col, int row) {
        return rows.get(row).getCols().get(col);
    }

    public void setMark(int col, int row, Mark mark) {
        rows.get(row).getCols().set(col, mark);
    }

    public Symbol oppositeMove(Symbol symbol) {
        return (symbol == Symbol.CROSS ? Symbol.CIRCLE : Symbol.CROSS);
    }

    public boolean move(Move move) {
        boolean result = true;
        result = result && isTargetOnBoard(move);
        result = result && checkPossibleMove(move);
        result = result && checkSymbol(move);
        if (result) {
            Mark markCross = new Cross(Symbol.CROSS);
            Mark markCircle = new Circle(Symbol.CIRCLE);
            if (whoStarts.equals(markCross.getSymbol())) {
                setMark(move.getCol(), move.getRow(), markCross);
                whoStarts = oppositeMove(whoStarts);
            } else if (whoStarts.equals(markCircle.getSymbol())) {
                setMark(move.getCol(), move.getRow(), markCircle);
                whoStarts = oppositeMove(whoStarts);
            }
        }
        return result;
    }

    private boolean isTargetOnBoard(Move move) {
        return move.getCol() >= 0 && move.getCol() <= getBoardSize() && move.getRow() >= 0 && move.getRow() <= getBoardSize();
    }

    private boolean checkSymbol(Move move) {
        return !(getMark(move.getCol(), move.getRow()).getSymbol() == whoStarts);
    }

    private boolean checkPossibleMove(Move move) {
        try {
            if (!(getMark(move.getCol(), move.getRow()) instanceof None))
                throw new Exception();
        } catch (Exception e) {
            System.out.println("Wrong move, try again.");
        }
        return (getMark(move.getCol(), move.getRow()) instanceof None);
    }

    @Override
    public String toString() {
        int counter = 0;
        String s = "";
        s += counter++;
        for (int row = 0; row < getBoardSize(); row++) {
            s += rows.get(row);
            if (counter != getBoardSize()) {
                s += counter++ + "";
            }
        }
        s += gameplay();
        return s;
    }

    private String gameplay() {
        Board board = new Board(gameWithComputer, characterSelection, boardSize);
        if (isWinner(board)) {
            return "Win " + oppositeMove(whoStarts);
        } else if (thereAreNoEmptyFields()) {
            return "draw in the game";
        }
        return "Next move: " + whoStarts;
    }

    public boolean isWinner(Board board) {
        boolean checkWinner = false;

        for (int col = 0; col < getBoardSize(); col++) {
            for (int row = 0; row < getBoardSize(); row++) {
                checkWinner = checkWinner || checkWinner(board, col, row, 0, -1);
                checkWinner = checkWinner || checkWinner(board, col, row, 1, -1);
                checkWinner = checkWinner || checkWinner(board, col, row, 1, 0);
                checkWinner = checkWinner || checkWinner(board, col, row, 1, 1);
                checkWinner = checkWinner || checkWinner(board, col, row, 0, 1);
                checkWinner = checkWinner || checkWinner(board, col, row, -1, 1);
                checkWinner = checkWinner || checkWinner(board, col, row, -1, 0);
                checkWinner = checkWinner || checkWinner(board, col, row, -1, -1);
            }
        }
        return checkWinner;
    }

    private boolean checkWinner(Board board, int col, int row, int deltaCol, int deltaRow) {
        int symbolCrossCounter = 0;
        int symbolCircleCounter = 0;

        if (getBoardSize() > 4) {
            return checkWin(5, board, col, row, symbolCrossCounter, symbolCircleCounter, deltaCol, deltaRow);
        } else {
            return checkWin(3, board, col, row, symbolCrossCounter, symbolCircleCounter, deltaCol, deltaRow);
        }
    }

    private boolean checkWin(int size, Board board, int col, int row, int symbolCrossCounter, int symbolCircleCounter, int deltaCol, int deltaRow) {
        for (int i = 0; i < size; i++) {
            if (isOnTheBoard(board, col, row)) {
                Symbol symbol = getMark(col, row).getSymbol();
                if (symbol == Symbol.CROSS) {
                    symbolCrossCounter++;
                } else if (symbol == Symbol.CIRCLE) {
                    symbolCircleCounter++;
                }
            }
            col += deltaCol;
            row += deltaRow;
        }
        if (symbolCrossCounter == size) {
            return true;
        } else {
            return symbolCircleCounter == size;
        }
    }

    private static boolean isOnTheBoard(Board board, int col, int row) {
        return col < board.getBoardSize() && row < board.getBoardSize() && col >= 0 && row >= 0;
    }

    public boolean thereAreNoEmptyFields() {
        for (int col = 0; col < getBoardSize(); col++) {
            for (int row = 0; row < getBoardSize(); row++) {
                if (getMark(col, row).getSymbol().equals(Symbol.NONE))
                    return false;
            }
        }
        return true;
    }

    public boolean isGameWithComputer() {
        return gameWithComputer;
    }

    public Board deepCopy() {
        Board newBoard = new Board(gameWithComputer, characterSelection, boardSize);
        for (int col = 0; col < getBoardSize(); col++) {
            for (int row = 0; row < getBoardSize(); row++) {
                Mark mark = getMark(col, row);
                if ((mark instanceof None)) {
                    Mark newMark = MarkFactory.createMarkCopy(mark);
                    newBoard.setMark(col, row, newMark);
                }
            }
        }
        newBoard.whoStarts = whoStarts;
        return newBoard;
    }

    public CharacterSelection getCharacterSelection() {
        return characterSelection;
    }

    public int getBoardSize() {
        return boardSize;
    }
}
