package com.java.tictactoe.game.model;

import com.java.tictactoe.enums.Seed;
import com.java.tictactoe.game.Cell;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by rybeusz on 12.06.17.
 */
class CellTest {

    Cell cell;

    @BeforeEach
    public void setup() {
        int position = 4;
        int value = 5;
        cell = new Cell(position, value);
    }

    @Test
    public void testIsContentEmptyInNewCell() {
        assertEquals(Seed.EMPTY, cell.getSeed());
    }

    @Test
    public void testThrowIllegalArgumentExceptionIfPositionLT0() {
        assertThrows(IllegalArgumentException.class, ()-> {
           new Cell(-1, null);
        });
    }

    @Test
    public void testThrowIllegalArgumentExceptionIfPositionHT8() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cell(10, null);
        });
    }

    @Test
    public void testClearCell() {
        cell.setContent(Seed.CROSS);
        cell.clear();
        assertEquals(Seed.EMPTY, cell.getSeed());
    }

}