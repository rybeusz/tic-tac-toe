package com.java.tictactoe.players;

import com.java.tictactoe.enums.Seed;
import com.java.tictactoe.game.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AiTest {
    private Ai robot;

    private Board board;
    @BeforeEach
    public void setup() {
        robot = new Ai();
        board = new Board();
        board.init();
    }

    @Test void testIsAiSeedCorrectAfterInit() {
        Seed robotSeed = Seed.NOUGHT;
        robot.init(board, robotSeed);
        assertEquals(robotSeed, robot.getPlayerSeed());
    }

    @Test
    public void testMarvinMakesWinningMove() {
        Integer winningPosition = 2;
        // |X| | |
        // |X|X|O|
        // |O|X|O|
        board.getCells()[0].setContent(Seed.CROSS);
        board.getCells()[1].setContent(Seed.EMPTY);
        board.getCells()[2].setContent(Seed.EMPTY);
        board.getCells()[3].setContent(Seed.CROSS);
        board.getCells()[4].setContent(Seed.CROSS);
        board.getCells()[5].setContent(Seed.NOUGHT);
        board.getCells()[6].setContent(Seed.NOUGHT);
        board.getCells()[7].setContent(Seed.CROSS);
        board.getCells()[8].setContent(Seed.NOUGHT);
        robot.init(board, Seed.NOUGHT);
        assertEquals(winningPosition, robot.getMove());
    }

    @Test
    public void testMarvinBloksPlayerWinningMove() {
        Integer blockingPosition = 1;
        // |X| | |
        // |X|X| |
        // |O|X|O|
        board.getCells()[0].setContent(Seed.CROSS);
        board.getCells()[1].setContent(Seed.EMPTY);
        board.getCells()[2].setContent(Seed.EMPTY);
        board.getCells()[3].setContent(Seed.CROSS);
        board.getCells()[4].setContent(Seed.CROSS);
        board.getCells()[5].setContent(Seed.EMPTY);
        board.getCells()[6].setContent(Seed.NOUGHT);
        board.getCells()[7].setContent(Seed.CROSS);
        board.getCells()[8].setContent(Seed.NOUGHT);
        robot.init(board, Seed.NOUGHT);
        assertEquals(blockingPosition, robot.getMove());
    }

    @Test
    public void testMarvinBlocsPlayerWinningMoveInRow() {
        Integer blockingPosition = 2;
        // |X|X| |
        // | | | |
        // | | | |
        board.getCells()[0].setContent(Seed.CROSS);
        board.getCells()[1].setContent(Seed.CROSS);
        robot.init(board, Seed.NOUGHT);
        assertEquals(blockingPosition, robot.getMove());
    }

    @Test
    public void testMarvinBlocsPlayerWinningMove2() {
        Integer blockingPosition = 4;
        // |0| | |
        // |X| |X|
        // |O|X|O|
        board.getCells()[0].setContent(Seed.CROSS);
        board.getCells()[1].setContent(Seed.EMPTY);
        board.getCells()[2].setContent(Seed.EMPTY);
        board.getCells()[3].setContent(Seed.CROSS);
        board.getCells()[4].setContent(Seed.EMPTY);
        board.getCells()[5].setContent(Seed.CROSS);
        board.getCells()[6].setContent(Seed.NOUGHT);
        board.getCells()[7].setContent(Seed.CROSS);
        board.getCells()[8].setContent(Seed.NOUGHT);
        robot.init(board, Seed.NOUGHT);
        assertEquals(blockingPosition, robot.getMove());
    }

    @Test
    public void testIsAiForkingItsMove() {
        Integer forkingPosition = 2;
        // |0| |+|
        // | |X| |
        // |x| |0|
        board.getCells()[0].setContent(Seed.NOUGHT);
        board.getCells()[1].setContent(Seed.EMPTY);
        board.getCells()[2].setContent(Seed.EMPTY);
        board.getCells()[3].setContent(Seed.EMPTY);
        board.getCells()[4].setContent(Seed.CROSS);
        board.getCells()[5].setContent(Seed.EMPTY);
        board.getCells()[6].setContent(Seed.CROSS);
        board.getCells()[7].setContent(Seed.EMPTY);
        board.getCells()[8].setContent(Seed.NOUGHT);
        robot.init(board, Seed.NOUGHT);
        assertEquals(forkingPosition, robot.getMove());
    }

    @Test
    public void testIsAiBlokingOponnentForkMove() {
        Integer forkingPosition = 0;
        // |+|X| |
        // |X|0|0|
        // | | |X|
        board.getCells()[0].setContent(Seed.EMPTY);
        board.getCells()[1].setContent(Seed.CROSS);
        board.getCells()[2].setContent(Seed.EMPTY);
        board.getCells()[3].setContent(Seed.CROSS);
        board.getCells()[4].setContent(Seed.NOUGHT);
        board.getCells()[5].setContent(Seed.NOUGHT);
        board.getCells()[6].setContent(Seed.EMPTY);
        board.getCells()[7].setContent(Seed.EMPTY);
        board.getCells()[8].setContent(Seed.CROSS);
        robot.init(board, Seed.NOUGHT);
        assertEquals(forkingPosition, robot.getMove());
    }

    @Test
    void testAiGetCenter() {
        Integer center = 4;
        // | | | |
        // | | | |
        // | | | |
        robot.init(board, Seed.NOUGHT);
        assertEquals(center, robot.getMove());
    }

    @Test
    void testAiGetCenterIfAlreadyTaken() {
        // | | | |
        // | |X| |
        // | | | |
        board.getCells()[4].setContent(Seed.CROSS);
        robot.init(board, Seed.NOUGHT);
        robot.recountBoards();
        assertEquals(null, robot.getCenter());
    }

    @Test
    void testAiGetOppositeCorner() {
        Integer opossiteCorner = 0;
        // | | | |
        // | | | |
        // | | |X|
        board.getCells()[8].setContent(Seed.CROSS);
        robot.init(board, Seed.NOUGHT);
        assertEquals(opossiteCorner, robot.getMove());
    }

    @Test
    void testAiGetEmptyCorner() {
        Integer emptyCorner = 0;
        // | | | |
        // | | | |
        // | | | |
        robot.init(board, Seed.NOUGHT);
        robot.recountBoards();
        assertEquals(emptyCorner, robot.getEmptyCorner());
    }

    @Test
    void testAiGetEmptySide() {
        Integer emptySide = 1;
        // | | | |
        // | | | |
        // | | | |
        // how it should take it? top side, down side, left side, right side
        robot.init(board, Seed.NOUGHT);
        robot.recountBoards();
        assertEquals(emptySide, robot.getEmptySide());
    }

    @Test
    void testAiGetEmptySideIfOneIsAlreadyTaken() {
        Integer emptySide = 7;
        // | |X| |
        // | | | |
        // | | | |
        // how it should take it? top side, down side, left side, right side
        board.getCells()[1].setContent(Seed.CROSS);
        robot.init(board, Seed.NOUGHT);
        robot.recountBoards();
        assertEquals(emptySide, robot.getEmptySide());
    }


}