package OOP;

public class Lesson14 {
    public static void main(String[] args) {
        System.out.println(GeomType.POINT.getClass());  // class OOP.GeomType

        final byte N = 3;
        Geom3[] g = new Geom3[N];
        g[0] = new Line5(GeomType.LINE);
        g[1] = new Point3(GeomType.POINT);
        g[2] = new Line5(GeomType.LINE);

        for (Geom3 fig : g) {
            switch (fig.type) {
                case POINT -> ((Point3)fig).getPointMethod();
                case LINE -> ((Line5)fig).getLineMethod();
            }
        }

        if (g[0].type == GeomType.LINE) System.out.println("Линия");

        for (GeomType type : GeomType.values()) {  // Встроенное перечисление всех классов внутри enum.
            System.out.println(type);
            System.out.println(type + " = " + type.ordinal());  // Порядковый номер перечисления.
        }

        GeomType pt = GeomType.POINT;
        if ((GeomType.POINT).equals(pt)) System.out.println("Константы равны");

        GeomType point = GeomType.POINT;
        if (GeomType.LINE.compareTo(point) > 0) System.out.println("Константа LINE больше point");
        GeomType line = GeomType.LINE;
        if (GeomType.POINT.compareTo(line) < 0) System.out.println("Константа POINT меньше line");
        if (GeomType.POINT.compareTo(line) == 0) System.out.println("Константы равны");

        Geom4[] g1 = new Geom4[N];
        g1[0] = new Line6(GeomType1.LINE1);
        g1[1] = new Point4(GeomType1.POINT1);
        g1[2] = new Line6(GeomType1.LINE1);

        for (Geom4 fig : g1) {
            String value = fig.type.getValue();
            System.out.println(value);
        }
    }
}

enum GeomType {
    POINT, LINE, TRIANGLE, RECTANGLE, ELLIPSE;
}

abstract class Geom3 {
    public GeomType type;
}

class Point3 extends Geom3 {
    public Point3(GeomType type) {
        this.type = type;
    }

    public void getPointMethod() {
        System.out.println("Класс Point");
    }
}

class Line5 extends Geom3 {
    public Line5(GeomType type) {
        this.type = type;
    }

    public void getLineMethod() {
        System.out.println("Класс Line");
    }
}

enum GeomType1 {
    POINT1("point"), LINE1("line"), TRIANGLE1("triangle"),
    RECTANGLE1("rectangle"), ELLIPSE1("ellipse");

    private String value;

    GeomType1(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

abstract class Geom4 {
    public GeomType1 type;
}

class Point4 extends Geom4 {
    public Point4(GeomType1 type) {
        this.type = type;
    }

    public void getPointMethod() {
        System.out.println("Класс Point");
    }
}

class Line6 extends Geom4 {
    public Line6(GeomType1 type) {
        this.type = type;
    }

    public void getLineMethod() {
        System.out.println("Класс Line");
    }
}
