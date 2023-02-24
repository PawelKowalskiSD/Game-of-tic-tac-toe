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


    public  Board () {

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
        if(result) {
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
            if(!(getMark(move.getCol(), move.getRow()) instanceof None))
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
            if(counter != getBoardSize()) {
                s += counter++ + "";
            }
        }
        return s;
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
//        }
            return checkWinner;
    }

    private boolean checkWinner(Board board, int col, int row, int deltaCol, int deltaRow) {
        int repetitionCounter = 0;
        Symbol symbol = getMark(col, row).getSymbol();

        for (int i = 0; i < 5; i++) {
            if(col < board.getBoardSize() && row < board.getBoardSize() && col >= 0 && row >= 0) {
                if (symbol.equals(Symbol.CROSS) || symbol.equals(Symbol.CIRCLE)) {
                    repetitionCounter++;
                }
            }
            col += deltaCol;
            row += deltaRow;
        }
        return repetitionCounter == 5;
    }

    public boolean thereAreNoEmptyFields() {
        for (int col = 0; col < getBoardSize(); col++) {
            for(int row = 0; row < getBoardSize(); row++) {
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
                if((mark instanceof None)) {
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

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }
}
