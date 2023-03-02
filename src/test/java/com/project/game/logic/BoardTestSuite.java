package com.project.game.logic;

import com.project.game.logic.mark.Circle;
import com.project.game.logic.mark.Cross;
import com.project.game.logic.mark.None;
import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.*;

public class BoardTestSuite {
    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Nested
    @DisplayName("Test set and get mark")
    class TestSetAndGetMark {
        @Test
        @DisplayName("Test get mark")
        void testGetMark() {
            //Given
            Board board = new Board(false, CharacterSelection.CIRCLE, 10);
            Circle circle = new Circle(Symbol.CIRCLE);
            Cross cross = new Cross(Symbol.CROSS);
            None none = new None();
            board.setMark(0, 0, circle);
            board.setMark(0, 1, cross);

            //When & Then
            System.out.println(board);
            assertEquals(circle.toString(), board.getMark(0, 0).toString());
            assertEquals(cross.toString(), board.getMark(0, 1).toString());
            assertEquals(none.toString(), board.getMark(0, 2).toString());
        }

        @Test
        @DisplayName("Test set mark")
        void testSetMark() {
            //Given
            Board board = new Board(false, CharacterSelection.CIRCLE, 10);
            Circle circle = new Circle(Symbol.CIRCLE);
            Cross cross = new Cross(Symbol.CROSS);

            //When
            board.setMark(0, 1, circle);
            board.setMark(0, 2, cross);

            //Then
            System.out.println(board);
            assertEquals(circle.toString(), board.getMark(0, 1).toString());
            assertEquals(cross.toString(), board.getMark(0, 2).toString());
        }
    }

    @Nested
    @DisplayName("Test move")
    class TestMove {
        @Test
        @DisplayName("Test opposite move")
        void testOppositeMove() {
            //Given
            Board board = new Board(false, CharacterSelection.CIRCLE, 10);
            Circle circle = new Circle(Symbol.CIRCLE);
            Cross cross = new Cross(Symbol.CROSS);

            //When & Then
            System.out.println("Check opposing movement to the circle: " + board.oppositeMove(circle.getSymbol()));
            assertEquals(cross.getSymbol(), board.oppositeMove(circle.getSymbol()));
        }

        @Test
        @DisplayName("Test wrong move")
        void testWrongMove() {
            //Given
            Board board = new Board(false, CharacterSelection.CIRCLE, 10);
            Circle circle = new Circle(Symbol.CIRCLE);
            Cross cross = new Cross(Symbol.CROSS);

            //When
            board.move(new Move(0, 0));
            boolean SecondMoveTryTheSameField = board.move(new Move(0, 0));
            boolean againCircleMove = board.move(new Move(0, 1));

            //Then
            System.out.println(board);
            assertEquals(cross.getSymbol(), board.getMark(0, 0).getSymbol());
            assertEquals(circle.getSymbol(), board.getMark(0, 1).getSymbol());
            assertFalse(SecondMoveTryTheSameField);
            assertTrue(againCircleMove);
        }
    }

    @Nested
    @DisplayName("Test check circle win")
    class TestCheckCircleWin {

        @Test
        @DisplayName("Test winning circle in col")
        void testWinningCirclesInCol() {
            //Given
            Board board = new Board(false, CharacterSelection.CIRCLE, 10);
            Circle circle = new Circle(Symbol.CIRCLE);
            board.setMark(0, 0, circle);
            board.setMark(0, 1, circle);
            board.setMark(0, 2, circle);
            board.setMark(0, 3, circle);
            board.setMark(0, 4, circle);

            //When
            boolean result = board.isWinner(board);

            //Then
            System.out.println(board);
            assertTrue(result);
        }

        @Test
        @DisplayName("Test winning circle in row")
        void testWinningCirclesInRow() {
            //Given
            Board board = new Board(false, CharacterSelection.CIRCLE, 10);
            Circle circle = new Circle(Symbol.CIRCLE);
            board.setMark(0, 0, circle);
            board.setMark(1, 0, circle);
            board.setMark(2, 0, circle);
            board.setMark(3, 0, circle);
            board.setMark(4, 0, circle);

            //When
            boolean result = board.isWinner(board);

            //Then
            System.out.println(board);
            assertTrue(result);
        }

        @Test
        @DisplayName("Test winning circle in diagonally")
        void testWinningCirclesInDiagonally() {
            //Given
            Board board = new Board(false, CharacterSelection.CIRCLE, 10);
            Circle circle = new Circle(Symbol.CIRCLE);
            board.setMark(0, 0, circle);
            board.setMark(1, 1, circle);
            board.setMark(2, 2, circle);
            board.setMark(3, 3, circle);
            board.setMark(4, 4, circle);

            //When
            boolean result = board.isWinner(board);

            //Then
            System.out.println(board);
            assertTrue(result);
        }
    }

    @Nested
    @DisplayName("Test check cross win")
    class TestCheckCrossWin {
        @Test
        @DisplayName("Test winning cross in col")
        void testWinningCrossInCol() {
            //Given
            Board board = new Board(false, CharacterSelection.CROSS, 10);
            Cross cross = new Cross(Symbol.CROSS);
            board.setMark(0, 0, cross);
            board.setMark(0, 1, cross);
            board.setMark(0, 2, cross);
            board.setMark(0, 3, cross);
            board.setMark(0, 4, cross);

            //When
            boolean result = board.isWinner(board);

            //Then
            System.out.println(board);
            assertTrue(result);
        }

        @Test
        @DisplayName("Test winning cross in row")
        void testWinningCrossInRow() {
            //Given
            Board board = new Board(false, CharacterSelection.CIRCLE, 10);
            Cross cross = new Cross(Symbol.CROSS);
            board.setMark(0, 0, cross);
            board.setMark(1, 0, cross);
            board.setMark(2, 0, cross);
            board.setMark(3, 0, cross);
            board.setMark(4, 0, cross);

            //When
            boolean result = board.isWinner(board);

            //Then
            System.out.println(board);
            assertTrue(result);
        }

        @Test
        @DisplayName("Test winning cross in diagonally")
        void testWinningCrossInDiagonally() {
            //Given
            Board board = new Board(false, CharacterSelection.CROSS, 10);
            Cross cross = new Cross(Symbol.CROSS);
            board.setMark(0, 0, cross);
            board.setMark(1, 1, cross);
            board.setMark(2, 2, cross);
            board.setMark(3, 3, cross);
            board.setMark(4, 4, cross);

            //When
            boolean result = board.isWinner(board);

            //Then
            System.out.println(board);
            assertTrue(result);
        }
    }

    @Test
    @DisplayName("Test draw")
    void testDraw() {
        //Given
        Board board = new Board(false, CharacterSelection.CIRCLE, 10);
        Circle circle = new Circle(Symbol.CIRCLE);
        Cross cross = new Cross(Symbol.CROSS);

        for (int col = 0; col < board.getBoardSize(); col++) {
            for (int row = 0; row < board.getBoardSize(); row++) {
                if ((row == 1 || row == 3 || row == 5 || row == 7 || row == 9) && (col == 0 || col == 5)) {
                    board.setMark(col, row, circle);
                } else {
                    board.setMark(col, row, cross);
                }
                if ((col > 0 && col < 5) || (col > 5 && col < board.getBoardSize())) {
                    if (row == 0 || row == 2 || row == 4 || row == 6 || row == 8)
                        board.setMark(col, row, circle);
                }
            }
        }
        //When
        boolean result = board.thereAreNoEmptyFields();
        boolean isWinner = board.isWinner(board);

        //Then
        System.out.println(board);
        assertTrue(result);
        assertFalse(isWinner);
    }

}
