package ua.hillel.homeworks.homework7.figures;

public class ApplicationFigure {
    public static void main(String[] args) {
        Figure[] figures = getFigures();
        System.out.println("The sum = " + getSumFigureSquare(figures));
    }

    private static Figure[] getFigures() {
        return new Figure[] {
                new Circle(12),
                new Square(22),
                new Triangle(12, 22)
        };
    }

    private static double getSumFigureSquare(Figure[] figures) {
        double sum = 0;

        for (Figure figure : figures) {
            sum += figure.getSquare();
        }
        return sum;
    }
}
