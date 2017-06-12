package com.tictactoe.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by rybeusz on 12.06.17.
 */
class BoardTest {

    Board board;

    @BeforeEach
    public void setup() {
        board = new Board();
    }

    @Test
    public void testBoardCreatesBoardWith3Rows() {
        assertEquals(3, board.getCells().length);
    }

    @Test
    public void testBoardCreateBoardRowsWith3Cells() {
        assertEquals(3, board.getCells()[0].length);
        assertEquals(3, board.getCells()[1].length);
        assertEquals(3, board.getCells()[2].length);
    }

    @Test
    public void testInitFillsCellsWithCorrectCoordinates() {
        Cell cell = new Cell(2,2);
        board.init();
        assertTrue(cell.equals(board.getCells()[2][2]));
    }

}