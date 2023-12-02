package OOP;

import static java.lang.Math.abs;

public class Lesson2 {
    public static void main(String[] args) {
        Point1 point1 = new Point1();
        Point1 point2 = new Point1(1, 2);
        System.out.println("x = " + point1.x + ", y = " + point1.y + ", color = " + point1.color);
        System.out.println("x = " + point2.x + ", y = " + point2.y + ", color = " + point2.color);

        Rect rect1 = new Rect();
        Rect rect2 = new Rect(10, 20);
        Rect rect3 = new Rect(40, 40, 40);
        System.out.printf("Левый верхний = %d, правый нижний = %d, ширина = %d, высота = %d\n",
                rect1.upLeft, rect1.downRigth, rect1.width, rect1.height);
        System.out.printf("Левый верхний = %d, правый нижний = %d, ширина = %d, высота = %d\n",
                rect2.upLeft, rect2.downRigth, rect2.width, rect2.height);
        System.out.printf("Левый верхний = %d, правый нижний = %d, ширина = %d, высота = %d\n",
                rect3.upLeft, rect3.downRigth, rect3.width, rect3.height);

        Triangle triangle1 = new Triangle();
        Triangle triangle2 = new Triangle(1, 2, 3, 4, 5, 6);
        System.out.printf("Координаты треугольника: %d, %d, %d, %d, %d, %d\n",
                triangle1.a.x, triangle1.a.y, triangle1.b.x, triangle1.b.y,triangle1.c.x, triangle1.c.y);
        System.out.printf("Координаты треугольника: %d, %d, %d, %d, %d, %d\n",
                triangle2.a.x, triangle2.a.y, triangle2.b.x, triangle2.b.y,triangle2.c.x, triangle2.c.y);
    }
}

class Point1 {
    int x, y;
    int color;

    // Инициализатор.
    {
        x = -1;
        y = -1;
        color = 100;
    }

    public Point1() {}

    public Point1(int x, int y) {
        this();  // Вызываем первый конструктор.
        this.x = x;
        this.y = y;
    }
}

class Rect {
    int upLeft, downRigth, width, height;

    {
        upLeft = 0;
        downRigth = 0;
        width = 0;
        height = 0;
    }

    public Rect() {}

    public Rect(int upLeft, int downRigth) {
        this();
        this.downRigth = downRigth;
        this.upLeft = upLeft;
        width = abs(upLeft - downRigth);
        height = abs(upLeft - downRigth);
    }

    public Rect(int upLeft, int width, int height) {
        this();
        this.upLeft = upLeft;
        this.width = width;
        this.height = height;
    }
}

class Triangle {
    Point1 a = new Point1();
    Point1 b = new Point1();
    Point1 c = new Point1();
    public Triangle() {}

    public Triangle(int a_x, int a_y, int b_x, int b_y, int c_x, int c_y) {
        a = new Point1(a_x, a_y);
        b = new Point1(b_x, b_y);
        c = new Point1(c_x, c_y);
    }
}
