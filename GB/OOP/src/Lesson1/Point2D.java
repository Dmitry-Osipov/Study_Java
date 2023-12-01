package Lesson1;

public class Point2D {
    // Атрибуты класса:
    private int x, y;  // Модификатор доступа закрывает на чтение и запись обе координаты. Для доступа к координатам
    // нужны геттеры и сеттеры.

    // Конструктор экземпляра класса для двух аргументов:
    public Point2D(int valueX, int valueY) {
        this.x = valueX;  // this используется для указания на конкретно эту координату в конкретно этом классе.
        y = valueY;  // Как видим, по факту можно и не использовать this.
    }

    // Конструктор экземпляра класса для одного аргумента:
    public Point2D(int value) {
        this(value, value);
    }

    // Конструктор экземпляра класса без аргументов:
    public Point2D() {
        this(0);
    }

    // Геттеры координат:
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    // Сеттеры координат:
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    // Переопределение встроенного метода:
    @Override
    public String toString() { return String.format("x: %d; y: %d", this.x, this.y); }

    public static double distance(Point2D a, Point2D b) {
        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
    }
}
