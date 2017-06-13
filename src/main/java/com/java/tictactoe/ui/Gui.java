package com.java.tictactoe.ui;

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
        // | | | |
        // | | | |
        // | | | |
    }


    public static void main(String[] args) {
        Gui gui = new Gui();
        gui.showStartMessage(Seed.CROSS);
    }

    public void showBoard(ArrayList<Seed> seeds) {
    }
}
