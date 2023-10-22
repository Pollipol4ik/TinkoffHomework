package edu.task2;

public class Square extends Rectangle {
    public Square(int side) {
        super(side, side);
    }

    public Square() {

    }

    public void setSide(int side) {
        if (side < 0) {
            throw new IllegalArgumentException("Side cannot be negative");
        }
        super.setWidth(side);
        super.setHeight(side);
    }
}
