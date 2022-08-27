package ua.hillel.homeworks.homework7.figures;

public class Triangle implements Figure {
    private double side;
    private double height;

    public Triangle(double side, double height) {
        this.side = side;
        this.height = height;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getSquare() {
        return side * height / 2;
    }
}
