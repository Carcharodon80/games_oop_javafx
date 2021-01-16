package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BishopBlackTest {
    @Test
    public void testPosition() {
        Figure bishopBlack = new BishopBlack(Cell.A4);
        Cell position = bishopBlack.position();
        assertEquals(Cell.A4, position);
    }

    @Test
    public void testCopy() {
        Figure bishopBlack = new BishopBlack(Cell.B1);
        Figure newBishopBlack = bishopBlack.copy(Cell.C6);
        assertEquals(newBishopBlack.position(), Cell.C6);
    }

    @Test
    public void testWayC1G5() throws ImpossibleMoveException {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Cell[] steps = bishopBlack.way(Cell.G5);
        assertThat(steps, is(new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5}));
    }

    @Test
    public void testWayF2A7() throws ImpossibleMoveException {
        Figure bishopBlack = new BishopBlack(Cell.F2);
        Cell[] steps = bishopBlack.way(Cell.A7);
        assertThat(steps, is(new Cell[]{Cell.E3, Cell.D4, Cell.C5, Cell.B6, Cell.A7}));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void testWayNotDiagonal() throws ImpossibleMoveException {
        Figure bishopBlack = new BishopBlack(Cell.F1);
        Cell[] steps = bishopBlack.way(Cell.A7);
    }
}