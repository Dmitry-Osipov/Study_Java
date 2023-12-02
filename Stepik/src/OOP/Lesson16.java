package OOP;

public class Lesson16 {
    public static void main(String[] args) {
        Point6<Integer> point = new Point6<>(12, 3);
        System.out.println(point.getMax());
        Point6<Double> point1 = new Point6<>(21.2, 32.1);
        System.out.println(point.equalsPoint(point1));

        Short[] array = {1, 2, 3, 4};
        Short value = 4;
        System.out.println(Math1.isIn(value, array));

        Digit d1 = new Digit(10);
        Digit d2 = new Digit(10.5);
        Digit d3 = new Digit(1.5f);

        System.out.println(d1.value + " " + d2.value + " " + d3.value);
    }
}

class Point6<T extends Number> {
    public T x, y;

    public Point6(T x, T y) {
        this.x = x;
        this.y = y;
    }

    public double getMax() {
        double xd = x.doubleValue();
        double yd = y.doubleValue();
        return (xd < yd) ? yd : xd;
    }

    public boolean equalsPoint(Point6<? extends Number> pt) {  // Метасимвольный аргумент дженерика.
        return (x.doubleValue() == pt.x.doubleValue() && y.doubleValue() == pt.y.doubleValue());
    }
}

class Math1 {
    public static <T> boolean isIn(T val, T[] array) {
        for (T v : array) if (v.equals(val)) return true;
        return false;
    }
}

class Digit {
    public double value;

    public <T extends Number> Digit(T value) {
        this.value = value.doubleValue();
    }
}

interface I1 {}
interface I2 {}

class MyClass1<T extends Number & I1, I2> {  // Генерик примет любой класс, который наследуется от Number и реализует
    // эти 2 интерфейса.
}
