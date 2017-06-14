package com.java.tictactoe;

import com.java.tictactoe.enums.GameState;
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

    public GameController() {
        game = new Game();
        gui = new Gui();
        userInput = new UserInput();
    }

    public void run() {
        startGame();
        while(game.getCurrentState() == GameState.PLAYING) {
            playTurn();
        }
        endGame();
    }

    private void playTurn() {
        gui.showBoard(game.getBoard().getSeeds());
        gui.showQuestion();
        game.updateGameState(game.getCurrentPlayer(), userInput.chooseCell()-1);
        gui.showStatus(game.getCurrentState());
    }

    private void startGame() {
        game.init();
        gui.showStartMessage(game.getCurrentPlayer());
    }

    private void endGame() {
        gui.showEndGame(game.getCurrentState());
        gui.showBoard(game.getBoard().getSeeds());
    }

}
