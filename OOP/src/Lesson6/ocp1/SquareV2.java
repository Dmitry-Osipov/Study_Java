package Lesson6.ocp1;

public class SquareV2 implements ShapeV2 {
    private int side;

    public SquareV2(int side) { this.side = side; }

    public int getSide() { return side; }

    public void setSide(int side) { this.side = side; }

    @Override
    public double getArea() { return Math.pow(side, 2); }
}
