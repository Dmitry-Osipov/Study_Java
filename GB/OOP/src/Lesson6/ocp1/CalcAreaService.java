package Lesson6.ocp1;

import java.util.List;

public class CalcAreaService {
    private List<Shape> shapes;

    public CalcAreaService(List<Shape> shapes) { this.shapes = shapes; }

    public List<Shape> getShapes() { return shapes; }

    public void processAll() {
        double sumArea = 0;
        for (Shape shape : shapes) {
            if (shape instanceof RightTriangle) {
                RightTriangle triangle = (RightTriangle) shape;
                sumArea += triangle.getKatet1() * triangle.getKatet2() / 2.0;
            }

            if (shape instanceof Square) {
                Square square = (Square) shape;
                sumArea += Math.pow(square.getSide(), 2);
            }

            if (shape instanceof Circle) {
                Circle circle = (Circle) shape;
                sumArea += Math.PI * Math.pow(circle.getRadius(), 2);
            }
        }

        System.out.printf("Сумма площадей фигур равна %f \n", sumArea);
    }
}
