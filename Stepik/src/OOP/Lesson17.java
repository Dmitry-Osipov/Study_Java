package OOP;

public class Lesson17 {
    public static void main(String[] args) {
        GeomInterface2<Integer> pt = new Point7();
        pt.setCoord(10, 20);
        System.out.println(pt.getCoord(TypeCoord1.COORD_X));
        System.out.println(pt.getCoord(TypeCoord1.COORD_Y));

        PointProp<Integer> p1 = new Point2D<>(1, 2);
        PointProp<Float> p2 = new Point3D1<>(10f, 20f, 30f);
        if (p1 instanceof Point2D<?>) System.out.println("p1 является объектом класса Point2D");
        if (p2 instanceof Point3D1<?>) System.out.println("p2 является объектом класса Point3D");

        ((Point2D<Integer>)p1).x = 5; // Ошибки нет.
//        ((Point2D<Float>)p1).x = 5;  // Ошибка приведения типа. Нужно быть осторожным, как при даунгрейде.
    }
}

enum TypeCoord1 {
    COORD_X, COORD_Y
}

interface GeomInterface2<T> {
    void setCoord(T x, T y);
    T getCoord(TypeCoord1 type);
}

class Point7 implements GeomInterface2<Integer> {
    private Integer x, y;

    @Override
    public void setCoord(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Integer getCoord(TypeCoord1 type) {
        return (type == TypeCoord1.COORD_X) ? x : y;
    }
}

class PointProp<T> {
    public T x, y;
}

class Point2D<T> extends PointProp<T> {
    public T x, y;

    public Point2D(T x, T y) {
        this.x = x;
        this.y = y;
    }
}

class Point3D1<T> extends PointProp<T> {
    public T x, y, z;

    public Point3D1(T x, T y, T z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
