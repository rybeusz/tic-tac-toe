package com.java.tictactoe.game;

import com.java.tictactoe.game.Game;
import com.java.tictactoe.enums.GameState;
import com.java.tictactoe.enums.Seed;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by rybeusz on 13.06.17.
 */
class GameTest {

    private Game game;

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
        int positionToUpdate = 1;
        game.updateGameState(positionToUpdate);
        assertEquals(Seed.NOUGHT, game.getCurrentPlayer());
    }

    @Test
    void testCurrentPlayerIsNotChangeIfCellIsTaken() {
        int markedCellPosition = 1;
        game.setCurrentPlayer(Seed.CROSS);
        game.getBoard().getCells()[markedCellPosition].setContent(Seed.NOUGHT);
        game.updateGameState(markedCellPosition);
        assertEquals(Seed.CROSS, game.getCurrentPlayer());
    }

    @Test
    void testIsCrossWin() {
        // |X|X| |
        game.setCurrentPlayer(Seed.CROSS);
        game.getBoard().getCells()[0].setContent(Seed.CROSS);
        game.getBoard().getCells()[1].setContent(Seed.CROSS);
        int lastCellPositionToWin = 2;
        game.updateGameState(lastCellPositionToWin);
        assertEquals(GameState.CROSS_WON, game.getCurrentState());
    }

    @Test
    void testIsNoughtWin() {
        // |O|O| |
        game.setCurrentPlayer(Seed.NOUGHT);
        game.getBoard().getCells()[0].setContent(Seed.NOUGHT);
        game.getBoard().getCells()[1].setContent(Seed.NOUGHT);
        int lastCellPositionToWin = 2;
        game.updateGameState(lastCellPositionToWin);
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
        int lastCellPostitionToDraw = 8;
        game.updateGameState(lastCellPostitionToDraw);
        assertEquals(GameState.DRAW, game.getCurrentState());
    }

    @Test
    void testGetBoardSeedsAreCorrect() {
        List<Seed> expectedSeeds = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {
            expectedSeeds.add(Seed.EMPTY);
        }
        assertEquals(expectedSeeds, game.getBoardSeeds());
    }
}