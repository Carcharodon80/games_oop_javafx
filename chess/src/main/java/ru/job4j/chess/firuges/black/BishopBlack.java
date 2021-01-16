package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) throws ImpossibleMoveException {
        if (!isDiagonal(this.position, dest)) {
            throw new ImpossibleMoveException();
        }
        int size = Math.abs(this.getPosition().getX() - dest.getX());
        Cell[] steps = new Cell[size];
        int deltaX = (dest.getX() - this.getPosition().getX()) / size;
        int deltaY = (dest.getY() - this.getPosition().getY()) / size;
        int x = this.getPosition().getX();
        int y = this.getPosition().getY();
        for (int i = 0; i < size; i++) {
            x += deltaX;
            y += deltaY;
            steps[i] = Cell.findBy(x, y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        boolean rsl = false;
        if (Math.abs(source.getX() - dest.getX()) == Math.abs(source.getY() - dest.getY())) {
            rsl = true;
        }
        return rsl;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }

    public Cell getPosition() {
        return position;
    }
}
