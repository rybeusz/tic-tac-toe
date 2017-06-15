package com.java.tictactoe.game;

import com.java.tictactoe.enums.Seed;
import com.java.tictactoe.game.Board;
import com.java.tictactoe.game.Cell;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by rybeusz on 12.06.17.
 */
class BoardTest {

    private Board board;

    @BeforeEach
    void setup() {
        board = new Board();
    }

    @Test
    void testBoardCreates9BoardLength() {
        assertEquals(9, board.getCells().length);
    }


    @Test
    void testInitFillsCellsWithCorrectCoordinates() {
        int positionToCheck = 8;
        int value = 6;
        Cell cell = new Cell(positionToCheck, value);
        board.init();
        assertTrue(cell.equals(board.getCells()[positionToCheck]));
    }

    @Test
    void testIsDrawIfNoEmptyCells() {
        board.init();
        for (Cell cell : board.getCells()) {
            cell.setContent(Seed.CROSS);
        }
        assertTrue(board.isDraw());
    }

    @Test
    void testIsDrawIfSomeEmptyCells() {
        board.init();
        for (Cell cell : board.getCells()) {
            cell.setContent(Seed.CROSS);
        }
        board.getCells()[8].clear();
        assertFalse(board.isDraw());
    }

    @Test
    void testIf3CrossesInRowWin() {
        // |X|X|X|
        // | | | |
        // | | | |
        board.init();
        board.getCells()[0].setContent(Seed.CROSS);
        board.getCells()[1].setContent(Seed.CROSS);
        assertTrue(board.hasWon(Seed.CROSS, 2));
    }

    @Test
    void testIf3NoughtInRowWin() {
        // |O|O|O|
        // | | | |
        // | | | |
        board.init();
        board.getCells()[0].setContent(Seed.NOUGHT);
        board.getCells()[1].setContent(Seed.NOUGHT);
        assertTrue(board.hasWon(Seed.NOUGHT, 2));
    }

    @Test
    void testIf3CrossesInCrossWin() {
        // |X| | |
        // | |X| |
        // | | |X|
        board.init();
        board.getCells()[0].setContent(Seed.CROSS);
        board.getCells()[4].setContent(Seed.CROSS);
        assertTrue(board.hasWon(Seed.CROSS, 8));
    }

    @Test
    void testIf3NoughtInCrossWin() {
        // |O| | |
        // | |O| |
        // | | |O|
        board.init();
        board.getCells()[0].setContent(Seed.NOUGHT);
        board.getCells()[4].setContent(Seed.NOUGHT);
        assertTrue(board.hasWon(Seed.NOUGHT, 8));
    }

    @Test
    void testPlayerChooseUsedCellThrowsException() {
        board.init();
        board.getCells()[0].setContent(Seed.NOUGHT);
        board.getCells()[1].setContent(Seed.NOUGHT);
        board.getCells()[2].setContent(Seed.NOUGHT);
        assertThrows(IllegalArgumentException.class, () -> {
           board.hasWon(Seed.CROSS, 0);
        });
    }

    @Test
    void testFullBoardWithCrossWinner() {
        // |X|X|O|
        // |O|X|O|
        // |O|X|X|
        board.init();
        board.getCells()[0].setContent(Seed.CROSS);
        board.getCells()[1].setContent(Seed.CROSS);
        board.getCells()[2].setContent(Seed.NOUGHT);
        board.getCells()[3].setContent(Seed.NOUGHT);
        board.getCells()[4].setContent(Seed.CROSS);
        board.getCells()[5].setContent(Seed.NOUGHT);
        board.getCells()[6].setContent(Seed.NOUGHT);
        board.getCells()[8].setContent(Seed.CROSS);
        assertTrue(board.hasWon(Seed.CROSS, 7));
    }

    @Test
    void testFullBoardWithoutWinner() {
        // |X|O|X|
        // |X|O|O|
        // |O|X|O|
        board.init();
        board.getCells()[0].setContent(Seed.CROSS);
        board.getCells()[1].setContent(Seed.NOUGHT);
        board.getCells()[2].setContent(Seed.CROSS);
        board.getCells()[3].setContent(Seed.CROSS);
        board.getCells()[4].setContent(Seed.NOUGHT);
        board.getCells()[5].setContent(Seed.NOUGHT);
        board.getCells()[6].setContent(Seed.NOUGHT);
        board.getCells()[8].setContent(Seed.NOUGHT);
        assertFalse(board.hasWon(Seed.CROSS, 7));
    }

}