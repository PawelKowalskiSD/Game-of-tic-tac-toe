package com.project.game.ui.text;

import com.project.game.logic.Board;
import com.project.game.logic.Move;
import com.project.game.logic.NextMark;

import java.util.Scanner;

public class UserDialogs {
    public static Move getNextMove() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter your move: ");
            String s = scanner.nextLine();
            try {
                int col = Integer.parseInt(s.substring(0,1));
                int row = Integer.parseInt(s.substring(0,1));
                if(col > 2 || row > 2)
                    throw new Exception();
                return new Move(col, row);
            } catch (Exception e) {
                System.out.println("Wrong move, try again.");
            }
        }
    }
}
