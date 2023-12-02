package OOP;

public class Lesson11 {
    public static void main(String[] args) {
        final int N = 3;
        Geom1[] geom = new Geom1[N];
        geom[0] = new Rectangle();
        geom[1] = new Triangle2();
        geom[2] = new Line3();

        for (Geom1 figure : geom) {
            if (figure instanceof MathGeom) {
                System.out.println(((MathGeom) figure).getSquare() + " for " + figure);
            }
        }

        for (Geom1 figure : geom) {
            if (figure instanceof GeomInterface) {
                for (double result : ((GeomInterface) figure).getCoords()) System.out.println(result);
            }
        }
    }
}

abstract class Geom1 {
    public int width, color;
    abstract void draw();
}

interface MathGeom {
    double getSquare();
}

interface GeomInterface {
    double[] getCoords();
}

class Line3 extends Geom1 implements GeomInterface {
    @Override
    void draw() {
        System.out.println("Рисование линии");
    }

    @Override
    public double[] getCoords() {
        return new double[] {1, 2, 3, 4};
    }
}

class Rectangle extends Geom1 implements MathGeom, GeomInterface {
    @Override
    void draw() {
        System.out.println("Рисование прямоугольника");
    }

    @Override
    public double getSquare() {
        return 5 * 10;
    }

    @Override
    public double[] getCoords() {
        return new double[] {10, 20, 30, 40};
    }
}

class Triangle2 extends Geom1 implements MathGeom, GeomInterface {
    @Override
    void draw() {
        System.out.println("Рисование треугольника");
    }

    @Override
    public double getSquare() {
        return 0.5 * 4 * 10;
    }

    @Override
    public double[] getCoords() {
        return new double[] {100, 200, 300, 400};
    }
}
