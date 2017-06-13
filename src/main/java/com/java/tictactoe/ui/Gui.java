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
    }

    public void showQuestion() {
    }

    public void showEndGame() {
    }

    public void showStatus(GameState currentState) {
    }
}
