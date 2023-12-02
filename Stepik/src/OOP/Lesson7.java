package OOP;

public class Lesson7 {
    public static void main(String[] args) {
//        Line1 line1 = new Line1();
//        line1.width = 5;
//        line1.x1 = 3;
//        Properties p = line1;
//        p.color = 100;
//        p.width = 10;
//        System.out.println(line1.width);
        Properties[] geom = new Properties[4];
        geom[0] = new Line1();
        geom[1] = new Triangle1();
        geom[2] = new Rect3();
        geom[3] = new Ellipse();
    }
}

class Geom {
    int id;

    public Geom() {
        System.out.println("Инициализация класса Geom");
    }
}

class Properties extends Geom {
    int width, color;

    public Properties() {
        System.out.println("Инициализация класса Properties");
    }
}

class Triangle1 extends Properties {
    int x1, x2, y1, y2, z1, z2;

    public Triangle1() {
        System.out.println("Инициализация класса Triangle");
    }
}

class Line1 extends Properties {
    int x1, x2;

    public Line1() {
        System.out.println("Инициализация класса Line");
    }
}

class Rect3 extends Properties {
    int x1, x2, y1, y2;

    public Rect3() {
        System.out.println("Инициализация класса Rect");
    }
}

class Ellipse extends Properties {
    int x1, x2, y1, y2;

    public Ellipse() {
        System.out.println("Инициализация класса Ellipse");
    }
}
