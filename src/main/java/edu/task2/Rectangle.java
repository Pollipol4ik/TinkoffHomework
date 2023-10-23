package edu.task2;

public class Rectangle {

    private int width;
    private int height;

    public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public Rectangle() {

    }

    public final Rectangle setHeight(int height) {
        if (height < 0) {
            throw new IllegalArgumentException("Height cannot be negative");
        }
        return new Rectangle(height, width);
    }

    public final Rectangle setWidth(int width) {
        if (width < 0) {
            throw new IllegalArgumentException("Width cannot be negative");
        }
        return new Rectangle(height, width);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public double area() {
        return width * height;
    }

}
