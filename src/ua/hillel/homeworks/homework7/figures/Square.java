package ua.hillel.homeworks.homework7.figures;

public class Square implements Figure {
    private double weight;

    public Square(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public double getSquare() {
        return weight * weight;
    }
}
