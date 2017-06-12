package com.tictactoe.model;

import com.tictactoe.enums.Seed;
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
        int row = 1;
        int col = 1;
        cell = new Cell(1,1);
    }

    @Test
    public void testIsContentEmptyInNewCell() {
        assertEquals(Seed.EMPTY, cell.getSeed());
    }

    @Test
    public void testThrowIllegalArgumentExceptionIfCoordinatesLT0() {
        assertThrows(IllegalArgumentException.class, ()-> {
           new Cell(-1,2);
        });
    }

    @Test
    public void testThrowIllegalArgumentExceptionIfCoordinatesHT2() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cell(0,4);
        });
    }

    @Test
    public void testClearCell() {
        cell.setContent(Seed.CROSS);
        cell.clear();
        assertEquals(Seed.EMPTY, cell.getSeed());
    }

}