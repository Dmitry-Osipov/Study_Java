package Lesson1;

import java.util.Scanner;

public class Lesson {
    public static void main(String[] args) {
        System.out.println("Hello world");
        String s = "Bye";
        System.out.println(s);
        float num = 213.21f; // Для типа данных float обязательно указывать f в конце.
        double number = 121.21; // Для типа double не нужно ничего прописывать после цифр.
        char ch = '{';
        System.out.println(ch);
        ch = 12;
        System.out.println(ch);  // Используется неявное преобразование, так что мы не увидим цифру.
        boolean flags = true;
        System.out.println(flags);
        var u = 123;  // Неявная типизация. Следует использовать только тогда, когда невозможно определить тип данных.
        System.out.println(u);

        // Для переменных следует использовать не примитивы, а обёртки (вместо int 12 -> Integer 12).

        System.out.println(s.charAt(0));  // Обращение к элементу по индексу происходит через команду.

        int[] arr = new int[10];  // Изначально все элементы статического массива равны 0.
        System.out.println(arr[3]);
        arr[3] = 13;  // Меняем нужное значение.
        System.out.println(arr[3]);

        int[] newArr = {1, 2, 3, 4, 5};  // Также можно создать массив с уже заранее заданными числами.
        System.out.println(newArr[4]);  // Просто так нельзя передать массив, ибо программа выдаст место в памяти.
        int[][] arrsArr = new int[3][5]; // Определение многомерного массива (вложенные массивы в массив).

//        // Получение данных из терминала.
//        // Строки:
//        Scanner iScanner = new Scanner(System.in);
//        System.out.printf("name: ");
//        String name = iScanner.nextLine();
//        System.out.printf("Привет, %s!", name);
//        iScanner.close();
//
//        // Некоторые примитивы:
//        Scanner iScanner = new Scanner(System.in);
//        System.out.printf("int a: ");
//        int x = iScanner.nextInt();
//        System.out.printf("double a: ");
//        double y = iScanner.nextDouble();
//        System.out.printf("%d + %f = %f", x, y, x + y);
//        iScanner.close();
//
//        // Проверка на соответствие получаемого типа:
//        Scanner iScanner = new Scanner(System.in);
//        System.out.printf("int a: ");
//        boolean flag = iScanner.hasNextInt();
//        System.out.println(flag);
//        int i = iScanner.nextInt();
//        System.out.println(i);
//        iScanner.close();

        // Форматированный вывод:
        int a = 1, b = 2;
        int c = a + b;
        String res = a + " + " + b + " = " + c;
        System.out.println(res);

        String res1 = String.format("%d + %d = %d \n", a, b, c);
        System.out.printf("%d + %d = %d \n", a, b, c);
        System.out.println(res1);

        // Условные операторы работают так же, как в C#.
        // Тернарный оператор:
        int q = 9;
        int w = 8;
        int min = q < w ? q : w;
        System.out.println(min);

        // Конструкция switch/case:
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("int value: ");
        boolean flag = iScanner.hasNextInt();
        System.out.println(flag);
        int value = iScanner.nextInt();
        iScanner.close();

        int mounth = value;
        String text = "";
        switch (mounth) {
            case 1:
                text = "Autumn";
                break;
            case 2:
                text = "Winter";
                break;
            case 3:
                text = "Spring";
                break;
            case 4:
                text = "Summer";
                break;
            default:
                text = "mistake";
                break;
        }
        System.out.println(text);

        // Циклы.
        // While:
        int some_value = 321;
        int some_count = 0;
        while (some_value != 0) {
            some_value /= 10;
            some_count++;
        }
        System.out.println(some_count);

        // Do while:
        int value_some = 321;
        int count_some = 0;
        do {
            value_some /= 10;
            count_some++;
        } while (value_some != 0);
        System.out.println(count_some);

        // For:
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0){
                continue;  // Продолжаем цикл уже без этой итерации (пропускаем её).
            } else if (i == 9) {
                break;  // Прерываем цикл полностью на i == 9.
            }
            System.out.println(i);
        }

        // Вложенные циклы:
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                System.out.print("* ");
            }
            System.out.println();
        }

        // Цикл for для коллекций:
        int[] someArr = {1, 2, 3, 4, 5, 6, 7};
        for (int i = 0; i < someArr.length; i++){
            someArr[i] = 10;
        }
        for (int item : someArr){
            System.out.print(item + " ");
        }
        System.out.println();

        // Функции.
        // Вызов:
        sayHi();
        System.out.println(sum(3, 4));
        System.out.println(factor(5));
    }

    // Объявление:
    static void sayHi(){
        System.out.println("Hi");
    }

    static int sum(int a, int b) {
        return a+b;
    }
    static double factor(int n) {
        if(n==1)return 1;
        return n * factor(n-1);
    }
}
