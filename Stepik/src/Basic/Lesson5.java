package Basic;

import java.util.Scanner;

public class Lesson5 {
    public static void main(String[] args) {
        double S = 0;
        int n = 1;
        while (n <= 1000) {
            S += 1.0 / n;
            n++;
        }
        System.out.println(S);

        S = 0;
        n = 1;
        Scanner in = new Scanner(System.in);
        while (S < 100 && n != 0) {
            System.out.println("Введите целое число: ");
            n = in.nextInt();
            S += n;
        }
        System.out.println(S);

        S = 0;
        int i = 1;
        while ((S += ++i) < 50);
        System.out.println(S);

        S = 0;
        for (int j = 1; j < 1000; ++j) S += 1.0 / j;
        System.out.println(S);

        double f, k, b;

        System.out.println("Введите k и b: ");
        k = in.nextDouble();
        b = in.nextDouble();
        for (double x = 0; x < 1; x += 0.1) {
            f = k * x + b;
            System.out.println(f + " ");
        }

        final int secret_code = 13;
        int code_ent;

        do {
            System.out.println("Введите секретный код: ");
            code_ent = in.nextInt();
        } while (code_ent != secret_code);

        System.out.println("Вы ввели верный код!");

        int N = 7, M = 7, B = 0;
        for (int j = 0; j < N; ++j) {
            for (int l = 0; l < M; ++l) {
                B += j * l;
            }
        }
        System.out.println(B);

        float x, s = 0;
        int m = 0;
        do {
            System.out.println("Введите число: ");
            x = in.nextFloat();
            if (x < 0) continue;
            m ++;
            s += x;
            System.out.println("Текущая сумма: " + s);
        } while (m < 5);


    }
}
