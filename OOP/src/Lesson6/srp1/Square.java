package Lesson6.srp1;

import java.util.ArrayList;
import java.util.List;

public class Square {
    private List<Point> points;
    private int side;
//    private int scale = 1;

    public Square(Point point1, int side) {
        this.side = side;

        points = new ArrayList<>();

        for (int i = 0; i < 4; i++) points.add(new Point(point1.getX() + side, point1.getY()));
    }

    public int getSide() { return side; }

    public int getArea() { return side * side; }

    /*
    public int getScale() { return scale; }

    public void setScale(int scale) { this.scale = scale; }

    public void draw() {
        for (int i = 0; i < side * scale * 2; i++) System.out.print("*");
        System.out.println();

        for (int i = 0; i < side * scale - 2; i++) {
            System.out.print("*");

            for (int j = 1; j < side * scale * 2 - 1; j++) System.out.print(" ");

            System.out.println("*");
        }

        for (int i = 0; i < side * scale * 2; i++) System.out.print("*");
    }
     */

}
