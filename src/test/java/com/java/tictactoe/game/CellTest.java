package com.java.tictactoe.game;

import com.java.tictactoe.enums.Seed;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by rybeusz on 12.06.17.
 */
class CellTest {

    private Cell cell;
    private int position;
    private int value;

    @Test
    void testIsContentEmptyInNewCell() {
        position = 1;
        value = 1;
        cell = new Cell(position, value);
        assertEquals(Seed.EMPTY, cell.getContent());
    }

    @Test
    void testThrowIllegalArgumentExceptionIfPositionLT0() {
        position = -1;
        value = 1;
        assertThrows(IllegalArgumentException.class, () -> {
            new Cell(position, value);
        });
    }

    @Test
    void testThrowIllegalArgumentExceptionIfPositionHT8() {
        position = 10;
        value = 1;
        assertThrows(IllegalArgumentException.class, () -> {
            new Cell(position, value);
        });
    }

    @Test
    void testClearCell() {
        position = 1;
        value = 1;
        cell = new Cell(position, value);
        cell.setContent(Seed.CROSS);
        cell.clear();
        assertEquals(Seed.EMPTY, cell.getContent());
    }

}