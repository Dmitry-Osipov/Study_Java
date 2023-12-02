package OOP;

public class Lesson15 {
    public static void main(String[] args) {
        Point5<Integer, String> pt = new Point5<>(2, 3);
        pt.x = 10;
        pt.y = 20;
        System.out.println(pt.x + " " + pt.y);

        Point5<Double, Integer> ptd = new Point5<>(0.1, 0.2);
        ptd.x = 20.5;
        ptd.y = 33.3;
        System.out.println(ptd.x + " " + ptd.y);

        for (Object point : pt.getCoords()) System.out.println(point);
    }
}

class Point5<T, V> {
    public V id;
    public T x, y;

    public Point5(T x, T y) {
        this.x = x;
        this.y = y;
    }

    public T getX() {
        return x;
    }

    public T getY() {
        return y;
    }

    public V getId() {
        return id;
    }

    public Object[] getCoords() {
        return new Object[] {x, y};
    }
}
