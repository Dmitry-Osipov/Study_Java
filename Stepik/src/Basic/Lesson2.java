package Basic;

import java.util.Scanner;

public class Lesson2 {
    public static void main(String[] args) {
        short x = 5;
        double y = 4.5;
        float z = 1.2f;
        System.out.println("x = " + x + ", y = " + y);
        /*
        Основные спецификаторы функции System.out.printf:
        %d - для целочисленных значений;
        %f - для вещественных значений;
        %.nf - для вещественного значения с точностью до n-ого знака после запятой;
        %c - для отдельного символа (тип char);
        %s - для строк;
        %% - вывод процентов.
         */
        System.out.printf("x = %d, y = %f, z = %.2f\n", x, y, z);

        /*
        Методы Scanner:
        next(): считывает введённую строку до первого пробела;
        nextLine(): считывает введённую строку до перевода строки;
        nextByte(): считывает введённое число как byte;
        nextShort(): считывает введённое число как short;
        nextInt(): считывает введённое число как тип int;
        nextDouble: считывает введённое число как double;
        nextFloat: считывает введённое число как float;
        nextBoolean(): считывает значение boolean.
         */
        Scanner in = new Scanner(System.in);
        System.out.println("Input name: ");
        String name = in.nextLine();
        System.out.println("Input age: ");
        int age = in.nextInt();
        System.out.println("Input height: ");
        float height = in.nextFloat();
        System.out.printf("Name: %s, Age: %d, Height: %.2f\n", name, age, height);
    }
}
