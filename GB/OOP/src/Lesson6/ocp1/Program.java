package Lesson6.ocp1;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new RightTriangle(2, 3));
        shapes.add(new Square(4));

        CalcAreaService calcAreaService = new CalcAreaService(shapes);
        calcAreaService.processAll();

        List<ShapeV2> shapesV2 = new ArrayList<>();
        shapesV2.add(new RightTriangleV2(2, 3));
        shapesV2.add(new SquareV2(4));
        shapesV2.add(new CircleV2(5));

        CalcAreaServiceV2 calcAreaServiceV2 = new CalcAreaServiceV2(shapesV2);
        calcAreaServiceV2.processAll();
    }
}
