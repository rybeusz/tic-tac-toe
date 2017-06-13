package com.tictactoe.model;

import com.tictactoe.enums.Seed;
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
        Cell cell = new Cell(2,2, 1);
        board.init();
        assertTrue(cell.equals(board.getCells()[8]));
    }

    @Test
    public void testIsDrawIfNoEmptyCells() {
        board.init();
        for (Cell cell : board.getCells()) {
            cell.setContent(Seed.CROSS);
        }
        assertTrue(board.isDraw());
    }

    @Test
    public void testIsDrawIfSomeEmptyCells() {
        board.init();
        for (Cell cell : board.getCells()) {
            cell.setContent(Seed.CROSS);
        }
        board.getCells()[8].setContent(Seed.EMPTY);
        assertFalse(board.isDraw());
    }

    @Test
    public void testIf3CrossesInRowWin() {
        // |X|X| |
        // | |X| |
        // |X|X|X|
        board.init();
        board.getCells()[0].setContent(Seed.CROSS);
        board.getCells()[1].setContent(Seed.CROSS);
        board.getCells()[4].setContent(Seed.CROSS);
        board.getCells()[6].setContent(Seed.CROSS);
        board.getCells()[7].setContent(Seed.CROSS);
        board.getCells()[8].setContent(Seed.CROSS);
        assertTrue(board.hasWon(Seed.CROSS, 0, 3));
    }

    @Test
    public void testIf3NoughtInRowWin() {
        // |O|O|O|
        // | | | |
        // | | | |
        board.init();
        board.getCells()[0].setContent(Seed.NOUGHT);
        board.getCells()[1].setContent(Seed.NOUGHT);
        board.getCells()[2].setContent(Seed.NOUGHT);
        assertTrue(board.hasWon(Seed.NOUGHT, 0, 3));
    }

    @Test
    public void testIf3CrossesInCrossWin() {
        // |X| | |
        // | |X| |
        // | | |X|
        board.init();
        board.getCells()[0].setContent(Seed.CROSS);
        board.getCells()[4].setContent(Seed.CROSS);
        board.getCells()[8].setContent(Seed.CROSS);
        assertTrue(board.hasWon(Seed.CROSS, 3, 3));
    }

    @Test
    public void testIf3NoughtInCrossWin() {
        // |O| | |
        // | |O| |
        // | | |O|
        board.init();
        board.getCells()[0].setContent(Seed.NOUGHT);
        board.getCells()[4].setContent(Seed.NOUGHT);
        board.getCells()[8].setContent(Seed.NOUGHT);
        assertTrue(board.hasWon(Seed.NOUGHT, 3, 3));
    }

}