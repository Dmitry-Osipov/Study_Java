package Lesson6.ocp1;

public class CircleV2 implements ShapeV2 {
    private final int radius;

    public CircleV2(int radius) { this.radius = radius; }

    public int getRadius() { return radius; }

    @Override
    public double getArea() { return Math.PI * Math.pow(radius, 2); }
}
