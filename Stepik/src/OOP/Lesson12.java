package OOP;

public class Lesson12 {
    public static void main(String[] args) {
        final byte N = 3;
        Geom2[] geom = new Geom2[N];
        geom[0] = new Line4();
        geom[1] = new Rectangle1();
        geom[2] = new Triangle3();
        for (Geom2 figure : geom) System.out.println(figure.getSquare());

        GeomInterface1.showInterval();
    }
}

class InterfaceGroup {
    private interface Interface_1 {  // Обычно приватные интерфейсы используются для расширения других интерфейсов.
        void method_1();

        private void privateMethod() {  // Приватные методы должны иметь реализацию, обычно используются для принципа DRY.
            System.out.println("privateMethod");
        }
    }

    interface Interface_2 extends Interface_1 {
        void method_2();
    }
}

class ReleaseInterface implements InterfaceGroup.Interface_2 {
    @Override
    public void method_2() {}

    @Override
    public void method_1() {}
}

abstract class Geom2 implements MathGeom1 {
    public int width, color;
    abstract void draw();

//    @Override
//    public double getSquare() { return 0; }  // Благодаря реализации в абстрактном классе можно не реализовывать метод
//    // интерфейса в дочерних классах, если не использовать реализацию по умолчанию.
}

interface MathGeom1 {
    default double getSquare() { return -1; }  // Стандартная реализация для всех дочерних классов.
}

interface GeomInterface1 {
    int MIN_COORD = 0;  // К переменным автоматически java добавляет модификаторы public static final.
    int MAX_COORD = 1000;

    static void showInterval() { System.out.println("[" + MIN_COORD + "; " + MAX_COORD + "]"); }  // Статический метод
    // обязательно должен иметь реализацию и не может быть переопределён в дочерних классах.

    default double getSquare() { return -2; }  // Если сразу 2 интерфейса реализуют 1 метод по умолчанию и дочерний
    // класс наследует сразу 2 этих интерфейса, то в дочернем классе следует переопределить этот метод.
}

class Line4 extends Geom2 {
    int x1, x2, y1, y2;

    @Override
    void draw() {
        System.out.println("Рисование линии");
    }
}

class Rectangle1 extends Geom2 implements GeomInterface1 {
    @Override
    void draw() {
        System.out.println("Рисование прямоугольника");
    }

    @Override
    public double getSquare() {
        return 5 * 10;
    }  // Стандартную реализацию можно переопределить.
}

class Triangle3 extends Geom2 implements GeomInterface1 {
    @Override
    void draw() {
        System.out.println("Рисование треугольника");
    }

    @Override
    public double getSquare() { return GeomInterface1.super.getSquare(); }  // Можно напрямую прописать откуда наследуем
    // метод при коллизии.
}
