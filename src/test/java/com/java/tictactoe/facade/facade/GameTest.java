package com.java.tictactoe.facade.facade;

import com.java.tictactoe.facade.Game;
import com.java.tictactoe.enums.GameState;
import com.java.tictactoe.enums.Seed;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by rybeusz on 13.06.17.
 */
class GameTest {
    Game game;

    @BeforeEach
    void setup() {
        game = new Game();
        game.init();
    }

    @Test
    void testStatusGameIsPlayingAfterInit() {
        assertEquals(GameState.PLAYING ,game.getCurrentState());
    }

    @Test
    void testChangeCurrentPlayerIfCellIsEmpty() {
        game.setCurrentPlayer(Seed.CROSS);
        game.updateGameState(1);
        assertEquals(Seed.NOUGHT, game.getCurrentPlayer());
    }

    @Test
    void testCurrentPlayerIsNotChangeIfCellIsTaken() {
        game.setCurrentPlayer(Seed.CROSS);
        game.getBoard().getCells()[1].setContent(Seed.NOUGHT);
        game.updateGameState(1);
        assertEquals(Seed.CROSS, game.getCurrentPlayer());
    }

    @Test
    void testIsCrossWin() {
        game.setCurrentPlayer(Seed.CROSS);
        game.getBoard().getCells()[0].setContent(Seed.CROSS);
        game.getBoard().getCells()[1].setContent(Seed.CROSS);
        game.updateGameState(2);
        assertEquals(GameState.CROSS_WON, game.getCurrentState());
    }

    @Test
    void testIsNoughtWin() {
        game.setCurrentPlayer(Seed.NOUGHT);
        game.getBoard().getCells()[0].setContent(Seed.NOUGHT);
        game.getBoard().getCells()[1].setContent(Seed.NOUGHT);
        game.updateGameState(2);
        assertEquals(GameState.NOUGHT_WON, game.getCurrentState());
    }

    @Test
    void testIsCurrentStatusDrawIfThereIsNoWinner() {
        game.getBoard().getCells()[0].setContent(Seed.CROSS);
        game.getBoard().getCells()[1].setContent(Seed.NOUGHT);
        game.getBoard().getCells()[2].setContent(Seed.CROSS);
        game.getBoard().getCells()[3].setContent(Seed.CROSS);
        game.getBoard().getCells()[4].setContent(Seed.NOUGHT);
        game.getBoard().getCells()[5].setContent(Seed.NOUGHT);
        game.getBoard().getCells()[6].setContent(Seed.NOUGHT);
        game.getBoard().getCells()[7].setContent(Seed.CROSS);
        game.setCurrentPlayer(Seed.NOUGHT);
        game.updateGameState(8);
        assertEquals(GameState.DRAW, game.getCurrentState());
    }
}