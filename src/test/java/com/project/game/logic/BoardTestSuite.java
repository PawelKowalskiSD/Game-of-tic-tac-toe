package com.project.game.logic;

import com.project.game.logic.mark.Circle;
import com.project.game.logic.mark.Cross;
import com.project.game.logic.mark.None;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    void testGetMark() {
        //Given
        Circle circle = new Circle(Symbol.CIRCLE);
        Cross cross = new Cross(Symbol.CROSS);
        None none = new None();
        Board board = new Board();
        board.setMark(0,0, new Circle(Symbol.CIRCLE));
        board.setMark(0,1, new Cross(Symbol.CROSS));

        //When & Then
        System.out.println(board);
        assertEquals(circle.toString(), board.getMark(0,0).toString());
        assertEquals(cross.toString(), board.getMark(0,1).toString());
        assertEquals(none.toString(), board.getMark(0,2).toString());
    }
    @Test
    void testSetMark() {
        //Given
        Circle circle = new Circle(Symbol.CIRCLE);
        Cross cross = new Cross(Symbol.CROSS);
        Board board = new Board();
        board.getMark(0,0);

        //When
        board.setMark(0,1,circle);
        board.setMark(0,2,cross);

        //Then
        System.out.println(board);
        assertEquals(circle.toString(), board.getMark(0,1).toString());
        assertEquals(cross.toString(), board.getMark(0,2).toString());
    }

    @Test
    void testOppositeMove() {
        //Given
        Board board = new Board();
        Circle circle = new Circle(Symbol.CIRCLE);
        Cross cross = new Cross(Symbol.CROSS);
        System.out.println("Check opposing movement to the circle: " + board.oppositeMove(circle.getSymbol()));
        //When & Then
        assertEquals(cross.getSymbol(), board.oppositeMove(circle.getSymbol()));
    }

    @Test
    void testMove() {
        //Given
        Board board = new Board();
        Circle circle = new Circle(Symbol.CIRCLE);
        Cross cross = new Cross(Symbol.CROSS);

        //When
        board.move(new Move(0,0));
        boolean SecondMoveTryTheSameField = board.move(new Move(0,0));
        boolean againCircleMove = board.move(new Move(0,1));
        System.out.println(board);

        //Then
        assertEquals(cross.getSymbol(),  board.getMark(0,0).getSymbol());
        assertEquals(circle.getSymbol(),  board.getMark(0,1).getSymbol());
        assertFalse(SecondMoveTryTheSameField);
        assertTrue(againCircleMove);
    }

    @Test
    void testIsWinner() {
        //given
        Board board = new Board();
        Cross cross = new Cross(Symbol.CROSS);
        Circle circle = new Circle(Symbol.CIRCLE);
        board.move(new Move(0, 0));
        board.move(new Move(2, 2));
        board.move(new Move(0, 1));
        board.move(new Move(2, 1));
        board.move(new Move(0, 2));

        //When
        boolean whoWonTheGame = board.isWinner();

        //Then
        assertTrue(whoWonTheGame);
    }
}
