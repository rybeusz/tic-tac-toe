package com.tictactoe.model;

/**
 * Created by rybeusz on 12.06.17.
 */
public class Board {
    private Cell[] cells;

    public Board() {
        cells = new Cell[9];
    }
    
    public void init() {
        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[k]= new Cell(i, j);
                k += 1;
            }
        }
    }

    public Cell[] getCells() {
        return cells;
    }
}
