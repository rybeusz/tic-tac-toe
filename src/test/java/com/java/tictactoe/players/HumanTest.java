package com.java.tictactoe.players;

import com.java.tictactoe.enums.Seed;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by rybeusz on 15.06.17.
 */
class HumanTest {
    @Test
    void testIsPlayerSeedGoodAfterInitialization() {
        Player human = new Human(Seed.CROSS, null);
        assertEquals(Seed.CROSS, human.getPlayerSeed());
    }

}