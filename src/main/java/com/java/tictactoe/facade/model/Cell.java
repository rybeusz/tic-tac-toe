package com.java.tictactoe.facade.model;

import com.java.tictactoe.enums.Seed;

/**
 * Created by rybeusz on 12.06.17.
 */
public class Cell {
    Seed content;
    Integer position;
    Integer value;


    public Cell(Integer position, Integer value) {
        content = Seed.EMPTY;
        setPosition(position);
        setValue(value);
    }

    public Seed getSeed() {
        return content;
    }


    public void clear() {
        this.content = Seed.EMPTY;
    }

    public void setContent(Seed content) throws IllegalArgumentException {
        if (this.content == Seed.EMPTY) {
            this.content = content;
        } else {
            throw new IllegalArgumentException("Cell already occuped");
        }
    }


    public Seed getContent() { return content; }


    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setPosition(int position) {
        if (position > 8 || position < 0) throw new IllegalArgumentException();
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        if (position != null ? !position.equals(cell.position) : cell.position != null) return false;
        return value != null ? value.equals(cell.value) : cell.value == null;
    }

}
