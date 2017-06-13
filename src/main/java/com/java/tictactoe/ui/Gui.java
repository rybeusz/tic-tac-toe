package com.java.tictactoe.ui;

import com.java.tictactoe.enums.GameState;
import com.java.tictactoe.enums.Seed;

import java.util.ArrayList;

/**
 * Created by pati on 13.06.17.
 */
public class Gui {

    public void showStartMessage(Seed currentPlayer) {
        System.out.println(String.format("Current player: %s", currentPlayer));
    }

    public void showBoard(ArrayList<Seed> seeds) {
        int seedCount = 1;
        String seedValue;
        for (Seed seed : seeds) {
            if (seed.equals(Seed.CROSS)) seedValue = "X";
            else if (seed.equals(Seed.NOUGHT)) seedValue = "O";
            else seedValue = " ";

            System.out.print(String.format("|%s", seedValue));
            if (seedCount == 3 || seedCount == 6 || seedCount == 9) System.out.print("|\n");
            seedCount++;
        }
    }

    public void showQuestion() {
        System.out.println( "|1|2|3|\n" +
                            "|4|5|6|\n" +
                            "|7|8|9|");
        System.out.println("Choose cell which you want mark by typing it number: ");
    }

    public void showEndGame(GameState winner) {
        System.out.println(String.format("The winner is: %s", winner));
    }

    public void showStatus(GameState currentState) {
        System.out.println(String.format("Game status: %s", currentState));
    }

    public static void main(String[] args) {
        Gui gui = new Gui();
        gui.showStartMessage(Seed.CROSS);
        ArrayList<Seed> seeds = new ArrayList<>();
        seeds.add(Seed.CROSS);
        seeds.add(Seed.EMPTY);
        seeds.add(Seed.CROSS);
        seeds.add(Seed.NOUGHT);
        seeds.add(Seed.NOUGHT);
        seeds.add(Seed.EMPTY);
        seeds.add(Seed.CROSS);
        seeds.add(Seed.CROSS);
        seeds.add(Seed.EMPTY);
        gui.showBoard(seeds);
        gui.showStatus(GameState.PLAYING);
        gui.showQuestion();
    }
}
