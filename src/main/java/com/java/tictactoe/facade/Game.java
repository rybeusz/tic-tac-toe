package com.java.tictactoe.facade;

import com.java.tictactoe.enums.GameState;
import com.java.tictactoe.enums.Seed;
import com.java.tictactoe.facade.model.Board;

import java.util.Random;

public class Game {
    private Board board;
    private GameState currentState;
    private Seed currentPlayer;

    public Game() {
        board = new Board();
    }

    public void init() {
        board.init();
        setGameState(GameState.PLAYING);
        setCurrentPlayer(chooseFirstPlayer());
    }

    private Seed chooseFirstPlayer() {
        Random r = new Random();
        int n = r.nextInt(2) + 1;
        if ( n == 1 ) { return Seed.NOUGHT;}
        return Seed.CROSS;
    }


    public void setGameState(GameState gameState) {
        this.currentState = gameState;
    }

    public void setCurrentPlayer(Seed currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public GameState getCurrentState() {
        return currentState;
    }

    public void updateGameState(Seed seed, Integer position) {
        if (!getCurrentPlayer().equals(seed)) throw new IllegalArgumentException("Bad player");

        try {
            if (board.hasWon(seed, position)) {
                if (seed == Seed.CROSS) currentState = GameState.CROSS_WON;
                if (seed == Seed.NOUGHT) currentState = GameState.NOUGHT_WON;
            } else if (board.isDraw()) {
                setGameState(GameState.DRAW);
            } else {
                if (currentPlayer == Seed.CROSS) {
                    currentPlayer = Seed.NOUGHT;
                } else {
                    currentPlayer = Seed.CROSS;
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public Seed getCurrentPlayer() {
        return currentPlayer;
    }

    public Board getBoard() {
        return board;
    }
}
