package com.project.game.ui.text;

import com.project.game.logic.Board;
import com.project.game.logic.Move;

import java.util.Scanner;


public class UserDialogs {
    public static Move getNextMove(Board board) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String s = scanner.nextLine();
            System.out.println("Press (Q-Quit)");
            System.out.println("Enter your move: ");
            try {
                if (s.toUpperCase().equals("Q")) {
                    System.exit(0);
                }
                if (s.toUpperCase().equals("R")) {
                    return new Move(0, 0, true);
                }

                int col = Integer.parseInt(s.substring(0, 1));
                int row = Integer.parseInt(s.substring(1, 2));
                if (col >= board.getBoardSize() || row >= board.getBoardSize())
                    throw new Exception();
                return new Move(col, row, false);
            } catch (Exception e) {
                System.out.println("Wrong move, try again.");
            }
        }
    }

}
