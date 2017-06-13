package com.tictactoe.model;

import com.tictactoe.enums.Seed;

/**
 * Created by rybeusz on 12.06.17.
 */
public class Cell {
    Seed content;
    int row;
    int col;
    int value;


    public Cell(int row, int col, int value) {
        content = Seed.EMPTY;
        setRow(row);
        setCol(col);
        setValue(value);
    }

    public Seed getSeed() {
        return content;
    }

    public void setRow(int row) {
        if (row > 2 || row < 0) {
            throw new IllegalArgumentException();
        }
        this.row = row;
    }

    public void setCol(int col) {
        if (col > 2 || col < 0) {
            throw new IllegalArgumentException();
        }
        this.col = col;
    }

    public void clear() {
        this.content = Seed.EMPTY;
    }

    public void setContent(Seed content) {
        this.content = content;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Seed getContent() { return content; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        if (row != cell.row) return false;
        return col == cell.col;
    }


    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
