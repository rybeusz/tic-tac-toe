package com.java.tictactoe.players;

import com.java.tictactoe.enums.Seed;
import com.java.tictactoe.ui.UserInput;

/**
 * Created by rybeusz on 14.06.17.
 */
public class Human implements Player {
    private UserInput userInput;
    private Seed playerSeed;

    public Human(Seed playerSeed, UserInput userInput) {
        this.playerSeed = playerSeed;
        this.userInput = userInput;
    }

    @Override
    public Integer getMove() {
        return userInput.chooseOption();
    }

    @Override
    public Seed getPlayerSeed() {
        return playerSeed;
    }
}
