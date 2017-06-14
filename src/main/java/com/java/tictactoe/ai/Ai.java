package com.java.tictactoe.ai;


import com.java.tictactoe.enums.Seed;
import com.java.tictactoe.facade.model.Board;
import com.java.tictactoe.facade.model.Cell;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class Ai {

    private Board board;
    private Integer countMove;
    private Integer[] VALUES = {4,3,8,9,5,1,2,7,6};
    ArrayList<Integer> marvinMoves;
    ArrayList<Integer> emptyCell;
    ArrayList<Integer> userMoves;

    public void init(Board board) {
        setBoard(board);
        countMove = 0;
        marvinMoves = new ArrayList<Integer>();
        emptyCell = new ArrayList<Integer>();
        userMoves = new ArrayList<Integer>();
    }

    public Integer move() {
        if (isWinning() > -1) return isWinning();
        if (isBlocking() > -1) return isBlocking();
        if (makeFork() > -1) return makeFork();
        if (isForking() > -1) return isForking();
        return -1;
        }

    public Integer makeFork() {
        return -1;
    }

    public Integer isWinning() {
        recountBoards();
        return findFifteen(marvinMoves, emptyCell);
    }

    public Integer isBlocking() {
        recountBoards();
        return findFifteen(userMoves, emptyCell);
    }

    private Integer findFifteen(ArrayList<Integer> playerMoves, ArrayList<Integer> emptyCells) {
        Integer won;
        for (int i=0; i<playerMoves.size(); i++) {
            for (int j = i + 1; j<playerMoves.size(); j++) {
                for (int k = 0; k < emptyCells.size(); k++) {
                    won = playerMoves.get(i) + playerMoves.get(j) + emptyCells.get(k);
                    if (won == 15) return Arrays.asList(VALUES).indexOf(emptyCells.get(k));
                }
            }
        }
        return -1;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    private void recountBoards() {
        for (Cell cell : board.getCells()) {
            if (cell.getContent().equals(Seed.NOUGHT)) {
                marvinMoves.add(cell.getValue());
            } else if (cell.getContent().equals(Seed.EMPTY)) {
                emptyCell.add(cell.getValue());
            } else {
                userMoves.add(cell.getValue());
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

    private Integer findFork(ArrayList<Integer> playerMoves, ArrayList<Integer> emptyCells) {
        HashMap<Integer, Integer> cellsUse = new HashMap<Integer, Integer>();
        Integer won;
        for (Integer value : VALUES) {
            cellsUse.put(value, 0);
        }

        for (int i=0; i<playerMoves.size(); i++) {
            for (int j = 0; j<emptyCells.size(); j++) {
                for (int k = j + 1; k < emptyCells.size(); k++) {
                    won = playerMoves.get(i) + emptyCells.get(j) + emptyCells.get(k);
                    if (won == 15) {
                        cellsUse.put(emptyCells.get(j), cellsUse.get(emptyCells.get(j)) + 1);
                        cellsUse.put(emptyCells.get(k), cellsUse.get(emptyCells.get(k)) + 1);
                    }
                }
            }
        }

        for (Integer value : VALUES) {
            System.out.println(value);
            System.out.println(cellsUse.get(value));
            if (cellsUse.get(value).equals(2)) {
                return Arrays.asList(VALUES).indexOf(value);
            }
        }
        return -1;
    }


}
