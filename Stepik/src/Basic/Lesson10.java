package Basic;

public class Lesson10 {
    public static void main(String[] args) {
        int w = 5;
        float h = 3.4f;
        System.out.println(perimeter(w, h));
        System.out.println(perimeter(5, 4));

        byte[] array = {1, 3, 0, -2, 7, 9};
        showArray(array);

        showIntArray(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println(modul(-1112));
        System.out.println(modul(-12.2));

        upAndDown(1);
    }

    public static float perimeter(float a, float b) {  // В статическом методе можно вызывать только статические методы.
        return 2 * (a + b);  // Всё, что будет написано после return, не будет отработано.
    }

    public static void showArray(byte[] array) {  // Метод может так же ничего не возвращать.
        for (byte value : array) System.out.print(value + " ");
        System.out.println();
    }

    public static void showIntArray(int ...array) {  // Замена *args в Python.
        for (int value : array) System.out.print(value + " ");
        System.out.println();
    }

    public static int modul(int x) {
        if (x < 0) x = -x;
        return x;
    }

    public static double modul(double x) {
        // Тернарный оператор проверки условия. Т.е. мы проверяем x, если он отрицательный, возвращаем -x, иначе x.
        return (x < 0) ? -x : x;
    }

    public static void upAndDown(int n) {
        System.out.println("Уровень вниз " + n);
        if (n < 4) upAndDown(n+1);
        System.out.println("Уровень вверх " + n);
    }
}
