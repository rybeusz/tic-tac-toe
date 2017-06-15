package com.java.tictactoe.players;


import com.java.tictactoe.enums.Seed;
import com.java.tictactoe.game.Board;
import com.java.tictactoe.game.Cell;

import java.util.*;

public class Ai implements Player {

    private Seed aiSeed;
    private Seed enemySeed;
    private Board board;
    private List<Cell> marvinMoves;
    private List<Cell> emptyCell;
    private List<Cell> userMoves;

    public void init(Board board, Seed aiSeed) {
        this.aiSeed = aiSeed;
        this.enemySeed = aiSeed.equals(Seed.NOUGHT) ? Seed.CROSS : Seed.NOUGHT;
        this.board = board;
        marvinMoves = new ArrayList<>();
        emptyCell = new ArrayList<>();
        userMoves = new ArrayList<>();
    }

    @Override
    public Integer getMove() {
        recountBoards();
        Integer winMove = getWinMove();
        Integer blockMove = getBlockMove();
        Integer forkMove = getForkMove();
        Integer blockForkMove = getBlockForkMove();
        Integer centerMove = getCenter();
        Integer oppositeCornerMove = getOppositeCorner();
        Integer emptyCornerMove = getEmptyCorner();
        Integer emptySideMove = getEmptySide();
        Integer positionToMove = null;

        if (winMove != null) positionToMove = winMove;
        else if (blockMove != null) positionToMove = blockMove;
        else if (forkMove != null) positionToMove = forkMove;
        else if (blockForkMove != null) positionToMove = blockForkMove;
        else if (centerMove != null) positionToMove = centerMove;
        else if (oppositeCornerMove != null) positionToMove = oppositeCornerMove;
        else if (emptyCornerMove != null) positionToMove = emptyCornerMove;
        else if (emptySideMove != null) positionToMove = emptySideMove;
        return positionToMove;
        }

    @Override
    public Seed getPlayerSeed() {
        return aiSeed;
    }

    public Integer getWinMove() {
        return findFifteen(marvinMoves, emptyCell);
    }

    public Integer getBlockMove() {
        return findFifteen(userMoves, emptyCell);
    }

    public Integer getForkMove() {
        return findFork(marvinMoves, emptyCell);
    }

    public Integer getBlockForkMove() {
        return findFork(userMoves, emptyCell);
    }

    public Integer getCenter() {
        Integer positionToMove = null;
        Boolean isBoardEmpty = true;
        for (Cell cell : board.getCells()) {
            if (!cell.getContent().equals(Seed.EMPTY)) {
                isBoardEmpty = false;
                break;
            }
        }
        // 4 is center
        if (isBoardEmpty) positionToMove = 4;
        return positionToMove;
    }

    public Integer getOppositeCorner() {
        Integer positionToMove = null;
        Cell topLeft = board.getCells()[0];
        Cell topRight = board.getCells()[2];
        Cell downLeft = board.getCells()[6];
        Cell downRight = board.getCells()[8];
        if (topLeft.getContent().equals(enemySeed) && downRight.getContent().equals(Seed.EMPTY)) positionToMove = downRight.getPosition();
        else if (downRight.getContent().equals(enemySeed) && topLeft.getContent().equals(Seed.EMPTY)) positionToMove = topLeft.getPosition();
        else if (topRight.getContent().equals(enemySeed) && downLeft.getContent().equals(Seed.EMPTY)) positionToMove = downLeft.getPosition();
        else if (downLeft.getContent().equals(enemySeed) && topRight.getContent().equals(Seed.EMPTY)) positionToMove = topRight.getPosition();
        return positionToMove;
    }

    public Integer getEmptyCorner() {
        Cell topLeft = board.getCells()[0];
        Cell topRight = board.getCells()[2];
        Cell downLeft = board.getCells()[6];
        Cell downRight = board.getCells()[8];
        return checkEmptyCells(topLeft, topRight, downLeft, downRight);
    }

    public Integer getEmptySide() {
        Cell topSide = board.getCells()[1];
        Cell downSide = board.getCells()[7];
        Cell leftSide = board.getCells()[3];
        Cell rightSide = board.getCells()[5];
        return checkEmptyCells(topSide, downSide, leftSide, rightSide);
    }

    public void recountBoards() {
        marvinMoves.clear();
        emptyCell.clear();
        userMoves.clear();
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

    private Integer checkEmptyCells(Cell cell1, Cell cell2, Cell cell3, Cell cell4) {
        // used for getEmptySide or getEmptyCorner to not duplicate code
        Integer positionToMove = null;
        if (cell1.getContent().equals(Seed.EMPTY)) positionToMove = cell1.getPosition();
        else if (cell2.getContent().equals(Seed.EMPTY)) positionToMove = cell2.getPosition();
        else if (cell3.getContent().equals(Seed.EMPTY)) positionToMove = cell3.getPosition();
        else if (cell4.getContent().equals(Seed.EMPTY)) positionToMove = cell4.getPosition();
        return positionToMove;
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

    private Integer findFork(List<Cell> playerMoves, List<Cell> emptyCells) {
        Map<Cell, Integer> cellsUse = new HashMap<>();
        int wonNumber;
        Integer forkMove = null;

        for (Cell cell : emptyCells) {
            cellsUse.put(cell, 0);
        }

        for (int i=0; i<playerMoves.size(); i++) {
            for (int j = 0; j<emptyCells.size(); j++) {
                for (int k = j + 1; k < emptyCells.size(); k++) {
                    wonNumber = playerMoves.get(i).getValue() + emptyCells.get(j).getValue() + emptyCells.get(k).getValue();
                    if (wonNumber == 15) {
                        cellsUse.put(emptyCells.get(j), cellsUse.get(emptyCells.get(j)) + 1);
                        cellsUse.put(emptyCells.get(k), cellsUse.get(emptyCells.get(k)) + 1);
                    }
                }
            }
        }

        for(Map.Entry<Cell, Integer> entry : cellsUse.entrySet()) {
            Cell cell = entry.getKey();
            Integer value = entry.getValue();
            if (value.equals(2)) forkMove = cell.getPosition();
        }
        return forkMove;
    }
}
