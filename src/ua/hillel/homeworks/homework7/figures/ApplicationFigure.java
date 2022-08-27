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














//        ArrayList<Figure> figureSquares = new ArrayList<Figure>();
//        figureSquares.add(new Circle(12));
//        figureSquares.add(new Square(22));
//        figureSquares.add(new Triangle(12, 14));

    //System.out.println("Sum = " + getSumFigureSquare(figureSquares));
    //}

//    static double getSumFigureSquare(ArrayList<Figure> figureSquares) {
//        double sum = 0;
//
//        for (Figure figure : figureSquares) {
//            sum += figure.getSquare();
//        }
//        return sum;
//    }
}
