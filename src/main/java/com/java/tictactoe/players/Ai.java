package com.java.tictactoe.ai;


import com.java.tictactoe.enums.Seed;
import com.java.tictactoe.facade.model.Board;
import com.java.tictactoe.facade.model.Cell;
import com.java.tictactoe.interfaces.Player;

import java.util.*;

public class Ai implements Player {

    private Seed aiSeed;
    private Board board;
    List<Cell> marvinMoves;
    List<Cell> emptyCell;
    List<Cell> userMoves;

    public void init(Board board, Seed aiSeed) {
        this.aiSeed = aiSeed;
        setBoard(board);
        marvinMoves = new ArrayList<>();
        emptyCell = new ArrayList<>();
        userMoves = new ArrayList<>();
    }

    @Override
    public Integer getMove() {
        Integer winMove = getWinMove();
        Integer blockMove = getBlockMove();
//        Integer
        if (winMove != null) return winMove;
        if (blockMove != null) return blockMove;
//        if (makeFork() > -1) return makeFork();
        if (isForking() > -1) return isForking();
        return 0;
        }

    @Override
    public Seed getPlayerSeed() {
        return aiSeed;
    }

    public Integer makeFork() {
        return -1;
    }

    public Integer getWinMove() {
        recountBoards();
        return findFifteen(marvinMoves, emptyCell);
    }

    public Integer getBlockMove() {
        recountBoards();
        return findFifteen(userMoves, emptyCell);
    }

    private Integer findFifteen(List<Cell> playerMoves, List<Cell> emptyCells) {
        Integer winMove = null;
        int wonNumber;
        for (int i=0; i<playerMoves.size(); i++) {
            for (int j = i + 1; j<playerMoves.size(); j++) {
                for (int k = 0; k < emptyCells.size(); k++) {
                    wonNumber = playerMoves.get(i).getValue() + playerMoves.get(j).getValue() + emptyCells.get(k).getValue();
                    if (wonNumber == 15) winMove = emptyCells.get(k).getPosition();
                }
            }
        }
        return winMove;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    private void recountBoards() {
        for (Cell cell : board.getCells()) {
            if (cell.getContent().equals(aiSeed)) {
                marvinMoves.add(cell);
            } else if (cell.getContent().equals(Seed.EMPTY)) {
                emptyCell.add(cell);
            } else {
                userMoves.add(cell);
            }
        }
    }

    public Integer isForking() {
        recountBoards();
        return findFork(marvinMoves, emptyCell);
    }

    public Integer isBlockingFork() {
        recountBoards();
        return findFork(userMoves, emptyCell);
    }

    private Integer findFork(List<Cell> playerMoves, List<Cell> emptyCells) {
        Map<Cell, Integer> cellsUse = new HashMap<>();
        Integer won;

        for (Cell cell : emptyCells) {
            cellsUse.put(cell, 0);
        }

        for (int i=0; i<playerMoves.size(); i++) {
            for (int j = 0; j<emptyCells.size(); j++) {
                for (int k = j + 1; k < emptyCells.size(); k++) {
                    won = playerMoves.get(i).getValue() + emptyCells.get(j).getValue() + emptyCells.get(k).getValue();
                    if (won == 15) {
                        cellsUse.put(emptyCells.get(j), cellsUse.get(emptyCells.get(j)) + 1);
                        cellsUse.put(emptyCells.get(k), cellsUse.get(emptyCells.get(k)) + 1);
                    }
                }
            }
        }

        for(Map.Entry<Cell, Integer> entry : cellsUse.entrySet()) {
            Cell cell = entry.getKey();
            Integer value = entry.getValue();
            if (value.equals(2)) return cell.getPosition();
        }
        return -1;
    }


}
