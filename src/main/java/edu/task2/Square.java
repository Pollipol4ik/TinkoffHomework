package edu.task2;

public class Square extends Rectangle {
    public Square(int side) {
        super(side, side);
    }

    public Square() {

    }

    public final Square setSide(int side) {
        if (side < 0) {
            throw new IllegalArgumentException("Side cannot be negative");
        }
        return new Square(side);
    }

}
