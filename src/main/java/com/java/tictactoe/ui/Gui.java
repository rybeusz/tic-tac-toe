package com.java.tictactoe.ui;

import com.java.tictactoe.enums.GameState;
import com.java.tictactoe.enums.Seed;

import java.util.ArrayList;

public class Gui {

    public void showStartMessage(Seed currentPlayer) {
        System.out.println(String.format("Current player: %s", currentPlayer));
    }

    public void showBoard(ArrayList<Seed> seeds) {
        Integer seedCount = 1;
        String seedValue;
        for (Seed seed : seeds) {
            if (seed.equals(Seed.CROSS)) seedValue = "X";
            else if (seed.equals(Seed.NOUGHT)) seedValue = "O";
            else seedValue = seedCount.toString();

            System.out.print(String.format("|%s", seedValue));
            if (seedCount == 3 || seedCount == 6 || seedCount == 9) System.out.print("|\n");
            seedCount++;
        }
    }

    public void showQuestion() {
        System.out.println("Choose cell which you want mark by typing it number: ");
    }

    public void showEndGame(GameState winner) {
        System.out.println(String.format("The winner is: %s", winner));
    }

    public void showStatus(GameState currentState) {
        System.out.println(String.format("Game status: %s", currentState));
    }

}
