package com.java.tictactoe;

import com.java.tictactoe.players.Ai;
import com.java.tictactoe.enums.GameState;
import com.java.tictactoe.enums.Seed;
import com.java.tictactoe.game.Game;
import com.java.tictactoe.players.Player;
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

    private void startGame() {
        game.init();
        gui.showMenu();
        Integer userChoose;
        Boolean userInputIsCorrect = false;
        while (!userInputIsCorrect) {
            userChoose = userInput.chooseOption();
            if (userChoose == 1) {
                userInputIsCorrect = true;
                setPlayerVsPlayerPlayers();
            } else if (userChoose == 2) {
                userInputIsCorrect = true;
                setPlayerVersusAiPlayers();
            } else if (userChoose == 3) {
                userInputIsCorrect = true;
                setAiVersusAiPlayers();
            } else {
                gui.showError("Bad input");
            }
        }
        gui.showStatus(game.getCurrentState());
    }

    private void endGame() {
        gui.showEndGame(game.getCurrentState());
        gui.showBoard(game.getBoardSeeds());
    }

    private void playTurn() {
        Seed currentPlayerSeed = game.getCurrentPlayer();
        gui.showCurrentPlayer(currentPlayerSeed);
        gui.showBoard(game.getBoardSeeds());
        gui.showQuestion();
        Integer position = currentPlayerSeed.equals(firstPlayer.getPlayerSeed()) ? firstPlayer.getMove() : secondPlayer.getMove();
        if (position >= 0 && position <= 8) game.updateGameState(position);
        else gui.showError("Bad input");
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

    private void setAiVersusAiPlayers() {
        Ai rufus = new Ai();
        Ai marvin = new Ai();
        rufus.init(game.getBoard(), Seed.CROSS);
        marvin.init(game.getBoard(), Seed.NOUGHT);
        firstPlayer = rufus;
        secondPlayer = marvin;
    }
}
