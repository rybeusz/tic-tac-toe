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
        assertEquals(9, board.getCells().length);
    }


    @Test
    public void testInitFillsCellsWithCorrectCoordinates() {
        Cell cell = new Cell(2,2);
        board.init();
        assertTrue(cell.equals(board.getCells()[8]));
    }

}