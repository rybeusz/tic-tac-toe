package com.tictactoe.model;

/**
 * Created by rybeusz on 12.06.17.
 */
public class Board {
    private Cell[][] cells;

    public Board() {
        cells = new Cell[3][3];
    }
    
    public void init() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = new Cell(i, j);
            }
        }
    }

    public Cell[][] getCells() {
        return cells;
    }
}
