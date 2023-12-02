package OOP;

public class Lesson1 {
    public static void main(String[] args) {
        Point pt = new Point();
        pt.x = 1;
        pt.y = 2;
        System.out.println("x = " + pt.x + ", y = " + pt.y);

        Point pt2 = new Point();
        pt2.x = 10;
        pt2.y = 20;
        System.out.println("x = " + pt2.x + ", y = " + pt2.y);

        Point3D point3D = new Point3D();
        point3D.x = 10;
        point3D.y = 20;
        point3D.z = 30;
        System.out.println("x = " + point3D.x + ", y = " + point3D.y + ", z = " + point3D.z);

        Line line1 = new Line();
        line1.start = 100;
        line1.end = 200;
        System.out.println("start = " + line1.start + ", end = " + line1.end);

        Line line2 = new Line();
        line2.start = 500;
        line2.end = 700;
        System.out.println("start = " + line2.start + ", end = " + line2.end);
    }
}

class Point {
    int x, y;
}

class Point3D {
    int x, y, z;
}

class Line {
    int start, end;
}
