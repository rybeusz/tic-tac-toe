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

    static void run() {
        GameController gc = new GameController();
        gc.startGame();
        while(gc.game.getCurrentState() == GameState.PLAYING) {

        }
    }

    private void startGame() {
        game.init();
        gui.showStartMessage(game.getCurrentPlayer());
    }

}
