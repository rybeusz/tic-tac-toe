package com.java.tictactoe.ai;

import com.java.tictactoe.enums.Seed;
import com.java.tictactoe.game.Board;
import com.java.tictactoe.players.Ai;
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
        robot.recountBoards();
        assertEquals(winningPosition, robot.getWinMove());
    }

    @Test
    public void testMarvinBloksPlayerWinningMove() {
        Integer blockingPosition = 1;
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
        robot.recountBoards();
        assertEquals(blockingPosition, robot.getBlockMove());
    }

    @Test
    public void testMarvinBloksPlayerWinningMoveInRow() {
        Integer blockingPosition = 2;
        // |X|X| |
        // | | | |
        // | | | |
        board.getCells()[0].setContent(Seed.CROSS);
        board.getCells()[1].setContent(Seed.CROSS);
        robot.init(board, Seed.NOUGHT);
        robot.recountBoards();
        assertEquals(blockingPosition, robot.getBlockMove());
    }

    @Test
    public void testMarvinBloksPlayerWinningMove2() {
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
        robot.recountBoards();
        assertEquals(blockingPosition, robot.getBlockMove());
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
        robot.recountBoards();
        assertEquals(forkingPosition, robot.getForkMove());
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
        robot.recountBoards();
        assertEquals(forkingPosition, robot.getBlockForkMove());
    }


}