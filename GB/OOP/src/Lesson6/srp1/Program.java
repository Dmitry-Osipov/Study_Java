package Lesson6.srp1;

public class Program {
    public static void main(String[] args) {
        Square square = new Square(new Point(1, 1), 5);
        System.out.printf("Площадь фигуры: %d \n", square.getArea());
        SquareDrawer squareDrawer = new SquareDrawer(square, 2);
        squareDrawer.draw();
        System.out.println();
        squareDrawer.setScale(4);
        squareDrawer.draw();
    }
}
