package com.java.tictactoe.players;

import com.java.tictactoe.enums.Seed;

/**
 * Created by rybeusz on 14.06.17.
 */
public interface Player {
    Integer getMove();
    Seed getPlayerSeed();
}
