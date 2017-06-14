package com.java.tictactoe;

import com.java.tictactoe.ai.Ai;
import com.java.tictactoe.enums.GameState;
import com.java.tictactoe.enums.Seed;
import com.java.tictactoe.facade.Game;
import com.java.tictactoe.ui.Gui;
import com.java.tictactoe.ui.UserInput;

/**
 * Created by rybeusz on 13.06.17.
 */
public class GameController {

    private Game game;
    private Gui gui;
    private UserInput userInput;
    private Ai marvin;

    public GameController() {
        game = new Game();
        gui = new Gui();
        userInput = new UserInput();
        marvin = new Ai();
    }

    public void run() {
        startGame();
        while(game.getCurrentState() == GameState.PLAYING) {
            playTurn();
        }
        endGame();
    }

    public void playTurn() {
        gui.showBoard(game.getBoard().getSeeds());
        gui.showQuestion();
        if (game.getCurrentPlayer() == Seed.NOUGHT) {
            Integer position = marvin.move();
            game.updateGameState(game.getCurrentPlayer(), position);
        } else {
            game.updateGameState(game.getCurrentPlayer(), userInput.chooseCell() - 1);
        }
        gui.showStatus(game.getCurrentState());
    }

    private void startGame() {
        game.init();
        marvin.init(game.getBoard());
        gui.showStartMessage(game.getCurrentPlayer());
    }

    private void endGame() {
        gui.showEndGame(game.getCurrentState());
        gui.showBoard(game.getBoard().getSeeds());
    }

}
