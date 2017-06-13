package com.tictactoe.model;

import com.tictactoe.enums.Seed;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by rybeusz on 12.06.17.
 */
public class Board {
    private Cell[] cells;

    public Board() {
        cells = new Cell[9];
    }
    
    public void init() {
        int[] values = {4,3,8,9,5,1,2,7,6};
        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[k]= new Cell(i, j, values[k]);
                k += 1;
            }
        }
    }

    public Cell[] getCells() {
        return cells;
    }

    public boolean isDraw() {
        for (Cell cell : getCells()) {
            if (cell.getContent().equals(Seed.EMPTY)) {
                return false;
            }
        }
        return true;
    }

    public boolean hasWon(Seed seed, int row, int col) {

        ArrayList<Integer> player = new ArrayList<>();
        for (Cell cell : getCells()) {
            if (cell.getContent().equals(seed)) {
                player.add(cell.getValue());
            }
        }

        for (int i=0; i<player.size(); i++) {
            for (int j = i + 1; j<player.size(); j++) {
                for (int k = j + 1; k < player.size(); k++) {
                    Integer won = player.get(i) + player.get(j) + player.get(k);
                    if (won == 15) return true;
                }
            }
        }
        return false;
    }
}
