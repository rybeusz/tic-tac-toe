package com.java.tictactoe.ui;

import com.java.tictactoe.enums.GameState;
import com.java.tictactoe.enums.Seed;

import java.util.ArrayList;
import java.util.List;

public class Gui {

    public void showMenu() {
        System.out.println(
                "Welcome in Tic-Tac-Toe\n" +
                        "1. Player VS Player\n" +
                        "2. Player VS AI Marvin\n"
        );
    }

    public void showBoard(List<Seed> seeds) {
        Integer seedCount = 0;
        String seedValue;
        for (Seed seed : seeds) {
            if (seed.equals(Seed.CROSS)) seedValue = "X";
            else if (seed.equals(Seed.NOUGHT)) seedValue = "O";
            else seedValue = " ";
            System.out.print(String.format("|%s", seedValue));
            if (seedCount == 2 || seedCount == 5 || seedCount == 8) System.out.print("|\n");
            seedCount++;
        }
    }

    public void showCurrentPlayer(Seed currentPlayer) {
        System.out.println(String.format("\n*******\nCurrent player: %s\n*******", currentPlayer));
    }

    public void showQuestion() {
        System.out.println("*******");
        System.out.println("|0|1|2|\n|3|4|5|\n|6|7|8|");
        System.out.println("Choose cell which you want mark by typing it number: ");
    }

    public void showStatus(GameState currentState) {
        System.out.println(String.format("\n\n\n*******\nGame status: %s\n*******", currentState));
    }

    public void showError(String errorInfo) {
        System.out.println(errorInfo);
    }

    public void showEndGame(GameState winner) {
        System.out.println(String.format("The winner is: %s", winner));
    }

}
