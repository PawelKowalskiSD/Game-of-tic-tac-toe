package com.project.game.ui.text;

import com.project.game.logic.Move;

import java.util.Scanner;



public class UserDialogs {
    public static Move getNextMove() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Press (Q-Quit)-(R-Restart)");
            System.out.println("Enter your move: ");
            try {
                String s = scanner.nextLine();
                if (s.toUpperCase().equals("Q")) {
                    System.exit(0);
                }
                if (s.toUpperCase().equals("R")) {
                   return new Move(0,0, true);
                }

                int col = Integer.parseInt(s.substring(0, 1));
                int row = Integer.parseInt(s.substring(1, 2));
                if (col > 2 || row > 2 )
                    throw new Exception();
                return new Move(col, row, false);
            } catch (Exception e) {
                System.out.println("Wrong move, try again.");
            }
        }
    }

}
