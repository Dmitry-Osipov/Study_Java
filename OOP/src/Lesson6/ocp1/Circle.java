package Lesson6.ocp1;

public class Circle implements Shape {
    private final int radius;

    public Circle(int radius) { this.radius = radius; }

    public int getRadius() { return radius; }
}
