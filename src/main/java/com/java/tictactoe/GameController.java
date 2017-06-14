package com.java.tictactoe;

import com.java.tictactoe.ai.Ai;
import com.java.tictactoe.enums.GameState;
import com.java.tictactoe.enums.Seed;
import com.java.tictactoe.facade.Game;
import com.java.tictactoe.interfaces.Player;
import com.java.tictactoe.players.Human;
import com.java.tictactoe.ui.Gui;
import com.java.tictactoe.ui.UserInput;

/**
 * Created by rybeusz on 13.06.17.
 */
public class GameController {

    private Game game;
    private Gui gui;
    private UserInput userInput;
    private Player firstPlayer;
    private Player secondPlayer;

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

    public void playTurn() {
        gui.showBoard(game.getBoard().getSeeds());
        gui.showQuestion();
        Seed currentPlayerSeed = game.getCurrentPlayer();
        Integer position = currentPlayerSeed.equals(firstPlayer.getPlayerSeed()) ? firstPlayer.getMove() : secondPlayer.getMove();
        game.updateGameState(position);
        gui.showStatus(game.getCurrentState());
    }

    private void startGame() {
        game.init();
        gui.showMenu();
        Integer userChoose = userInput.chooseOption();
        if (userChoose == 1) {
            setPlayerVsPlayerPlayers();
        } else if (userChoose == 2) {
            setPlayerVersusAiPlayers();
        }
        gui.showStartMessage(game.getCurrentPlayer());
    }

    private void endGame() {
        gui.showEndGame(game.getCurrentState());
        gui.showBoard(game.getBoard().getSeeds());
    }

    private void setPlayerVsPlayerPlayers() {
        firstPlayer = new Human(Seed.CROSS, userInput);
        secondPlayer = new Human(Seed.NOUGHT, userInput);
    }

    private void setPlayerVersusAiPlayers() {
        //Human is always CROSS, AI always NOUGHT
        Ai marvin = new Ai();
        marvin.init(game.getBoard(), Seed.NOUGHT);
        firstPlayer = new Human(Seed.CROSS, userInput);
        secondPlayer = marvin;
    }
}
