package Basic;

import java.util.Scanner;

public class Lesson3 {
    public static void main(String[] args) {
        int a = 5, b = 7;
        int c = a + b;
        System.out.println(c);

        short d = (short) (c + 5 + a + 7);
        System.out.println(d);

        float e = 5.8f, f = 7.6f;
        double g = e - f;
        System.out.println(g);  // С вещественными числами всегда получаем приблизительное значение.

        int h = (int) (e - f);
        System.out.println(h);

        double j = 3 * e;
        System.out.println(j);

        int k = (int) (3 * f);
        System.out.println(k);

        double o, p;
        Scanner in = new Scanner(System.in);
        System.out.println("Введите первую сторону прямоугольника: ");
        o = in.nextDouble();
        System.out.println("Введите вторую сторону прямоугольника: ");
        p = in.nextDouble();
        double perimeter = 2 * (o + p);
        System.out.printf("Периметр прямоугольника: %.2f\n", perimeter);

        int r = 7;
        int t = 2;
        double y = r / t;
        System.out.println(y);  // Получаем 3.0
        y = (double) r / t;
        System.out.println(y);  // Получаем 3.5

        int ost = 12 % 3;
        System.out.println(ost);

        short var = 0;
        var++;
        System.out.println(var);
        var--;
        System.out.println(var);
        ++var;
        System.out.println(var);
        --var;
        System.out.println(var);

        int n, m, l = 10, u = 10;
        n = l++;  // Присваивается 10 для n, потом 11 для l.
        m = ++u;  // Присваивается 11 для m, потом 11 для u.
        System.out.println("n = " + n + ", m = " + m + ", l = " + l + ", u = " + u);
    }
}
