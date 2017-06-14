package com.java.tictactoe.ai;

import com.java.tictactoe.enums.Seed;
import com.java.tictactoe.facade.model.Board;
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
        board.init();
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
        robot.init(board);
        assertEquals(winningPosition, robot.isWinning());
    }

    @Test
    public void testMarvinBloksPlayerWinningMove() {
        board.init();
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
        robot.init(board);
        assertEquals(blockingPosition, robot.isBlocking());
    }

    @Test
    public void testMarvinBloksPlayerWinningMove2() {
        board.init();
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
        robot.init(board);
        assertEquals(blockingPosition, robot.isBlocking());
    }

    @Test
    public void testIsAiForkingItsMove() {
        board.init();
        Integer forkingPosition = 2;
        // |0|X|+|
        // | |X| |
        // |x| |0|
        board.getCells()[0].setContent(Seed.NOUGHT);
        board.getCells()[1].setContent(Seed.CROSS);
        board.getCells()[2].setContent(Seed.EMPTY);
        board.getCells()[3].setContent(Seed.EMPTY);
        board.getCells()[4].setContent(Seed.CROSS);
        board.getCells()[5].setContent(Seed.EMPTY);
        board.getCells()[6].setContent(Seed.CROSS);
        board.getCells()[7].setContent(Seed.EMPTY);
        board.getCells()[8].setContent(Seed.NOUGHT);
        robot.init(board);
        assertEquals(forkingPosition, robot.isForking());
    }

    @Test
    public void testIsAiBlokingOponnentForkMove() {
        board.init();
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
        robot.init(board);
        assertEquals(forkingPosition, robot.isBlockingFork());
    }


}