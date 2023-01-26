package com.project.game.ui.text;

import com.project.game.logic.Move;

import java.util.Scanner;



public class UserDialogs {
    public static Move getNextMove() {
//        1.logowanie
//        username:
//        password:
//        rejestracja:
//        username:
//        password:
//        repeat password:
//        1. wyświetla się menu dostępnych opcji
//                --nowa gra
//        - wypieramy gę z botem albo z innym graczem turniej (z graczem zliczanie wyniku rozgrywki do rankingu zapisywanie wyniku użytkowników. sumowanie wyników jeśłi istnieją w rankingu;
//        jeśli bot to zapytaj o poziom trundosci easy intermediate advanced
//        - z innym graczem podaj imię drugiego gracza:
//        - wybierz rozmiar planyszy jeżeli plansza 3x3 to:
//        - ilość gier które chcecie rozegrać 5, 7, 9;
//        - jeżeli 10x10 to:
//        - ilość gier które chcecie rozegrać 3, 5;
//        - wybierz kto zaczyna grę: gracz 1 gracz 2 czy losowo;
//        po rozpoczęciu gry możliwość przerwania rozgrywki ( powrót do menu)
//        po wcisnieciu Q - quit komputer pyta czy napewno potwierdz y/n
//        policz kto wygrał i nie zapisuj do rankingu wyświetl punktacje informacyjnie;
//
//        --profil użytkownika
//                - wygrane , remisy , porażyki , twój ranking
//                -- ranking
//                -- training game
//        - wypieramy gę z botem albo z innym graczem
//        jeśli bot to zapytaj o poziom trundosci easy intermediate advanced
//        - z innym graczem podaj imię drugiego gracza:
//        - wybierz rozmiar planyszy
//        - wybierz kto zaczyna grę: gracz 1 gracz 2 czy losowo;
//        - wybierz ilość gier
//        po rozpoczęciu gry możliwość przerwania rozgrywki ( powrót do menu) restart gry treningowej( gra od początku) restart bierzącej mapy(restart tablicy)
//        po wcisnieciu Q - quit komputer pyta czy napewno potwierdz y/n
//        po wcisnieciu restart all games - quit komputer pyta czy napewno potwierdz y/n
//        po wcisnieciu r - restart this board komputer pyta czy napewno potwierdz y/n
//
//        policz kto wygrał i nie zapisuj do rankingu wyświetl punktacje informacyjnie;
//        --wyloguj
//                - logowanie && rejestracja
//                --wyjdz z gry ( przerwij program )
        Scanner scanner = new Scanner(System.in);
//        System.out.println("1 -> sign in");
//        System.out.println("2 -> sign up");
//        String m = scanner.nextLine();
//        try {
//            if (m.equals("1")) {
//                System.out.println("Username: ");
//                scanner.nextLine();
//                System.out.println("Password: ");
//                scanner.nextLine();
//            }
//            else if (m.equals("2")) {
//                System.out.println("Username: ");
//                scanner.nextLine();
//                System.out.println("Password: ");
//                scanner.nextLine();
//            }
//
//        }catch (Exception e) {
//
//        }


        String s = scanner.nextLine();
        while (true) {
            System.out.println("Press (Q-Quit)-(R-Restart)");
            System.out.println("Enter your move: ");
            try {
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
