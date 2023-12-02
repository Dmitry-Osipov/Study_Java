package OOP;

public class Lesson5 {
    public static void main(String[] args) {
        Point2 point1 = new Point2();
        Point2 point2 = new Point2();
        System.out.println(Point2.getCount());
    }
}

class Point2 {
    private static int count;
    public int x, y;

    static {  // Инициализатор статики.
        count = 0;
    }

    {
        x = y = -1;
    }

    public Point2() { count++; }

    public static int getCount() {
        return count;
    }
}
