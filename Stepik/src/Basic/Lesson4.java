package Basic;

import java.util.Scanner;

public class Lesson4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число: ");
        int x = in.nextInt();

        if (x < 0) x *= -1;

        System.out.println(x);

        if (x > 5) System.out.println("Введённое число больше 5");
        else if (x == 5) System.out.println("Введённое число 5");
        else System.out.println("Введённое число меньше 5");

        short item;
        System.out.println("1 - площадь треугольника\n2 - площадь прямоугольника");
        item = in.nextShort();

        double h, a, S = 0;
        if (item == 1) {
            System.out.println("Введите высоту и основание треугольника");
            h = in.nextDouble();
            a = in.nextDouble();
            S = 0.5 * h * a;
        } else if (item == 2) {
            System.out.println("Введите стороны прямоугольника: ");
            h = in.nextDouble();
            a = in.nextDouble();
            S = h * a;
        }
        System.out.println("Площадь равна: " + S);

        double b;
        System.out.println("Введите число: ");
        b = in.nextDouble();
        if (b >= -2 && b <= 5) System.out.println("Число принадлежит [-2; 5]");
        else if (b < -2 || b > 5) System.out.println("Число не принадлежит [-2; 5]");

        boolean fl = true;
        if (!fl) System.out.println("fl = false");
        else System.out.println("fl = true");

        int z = -1, y = 5;
        if ((z < 0 || z > 2) && y >= 5 && y <= 7) System.out.println("z не принадлежит [0; 2], y принадлежит [5; 7]");

        System.out.println("Выберите число от 1 до 4");
        item = in.nextShort();
        switch (item) {
            case 1 -> System.out.println("Выбрана площадь треугольника");
            case 2 -> System.out.println("Выбрана площадь прямоугольника");
            case 3 -> System.out.println("Выбрана площадь круга");
            case 4 -> System.out.println("Выбрана площадь трапеции");
            default -> System.out.println("Не выбран ни один из пунктов меню");
        }
    }
}
