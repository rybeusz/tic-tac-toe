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
        Integer[] values = {4,3,8,9,5,1,2,7,6};
        for (int k = 0; k < 9; k++) {
            cells[k]= new Cell(k, values[k]);
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

    public boolean hasWon(Seed seed, Integer position) throws IllegalArgumentException {
        getCells()[position].setContent(seed);

        //get list with all player cells
        ArrayList<Integer> player = new ArrayList<>();
        for (Cell cell : getCells()) {
            if (cell.getContent().equals(seed)) {
                player.add(cell.getValue());
            }
        }

        //check if any triplet equals 15
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
