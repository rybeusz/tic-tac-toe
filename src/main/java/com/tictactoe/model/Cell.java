package com.tictactoe.model;

import com.tictactoe.enums.Seed;

/**
 * Created by rybeusz on 12.06.17.
 */
public class Cell {
    Seed content;
    int row;
    int col;
    private Object cell;

    public Cell(int row, int col) {
        content = Seed.EMPTY;
        setRow(row);
        setCol(col);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell1 = (Cell) o;

        if (row != cell1.row) return false;
        if (col != cell1.col) return false;
        return cell != null ? cell.equals(cell1.cell) : cell1.cell == null;
    }
}
