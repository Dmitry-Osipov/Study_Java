package Lesson1;

import java.util.Arrays;

public class Homework {
    public static void main(String[] args) {
        try {
        arrayOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка выхода за пределы массива");
        }

        try {
            divisionByZero();
        } catch (ArithmeticException e) {
            System.out.println("Арифметическая ошибка");
        }

        try {
            numberFormatException();
        } catch (NumberFormatException e) {
            System.out.println("Ошибка формата числа");
        }

        int[] firstArray = new int[] {4, 5, 6};
        int[] secondArray = new int[] {1, 2, 3};
        int[] thirdArray = new int[] {1, 2, 3, 4};
        System.out.println(Arrays.toString(subArrays(firstArray, secondArray)));
        System.out.println(Arrays.toString(subArrays(firstArray, thirdArray)));

        int[] fourthArray = new int[] {12, 11, 6};
        int[] fifthArray = new int[] {3, 2, 3};
        int[] sixthArray = new int[] {1, 2, 3, 4};
        System.out.println(Arrays.toString(divArrays(fourthArray, fifthArray)));
        System.out.println(Arrays.toString(divArrays(fourthArray, sixthArray)));
        }

//    Реализуйте 3 метода, чтобы в каждом из них получить разные исключения.
//    Метод arrayOutOfBoundsException - Ошибка, связанная с выходом за пределы массива
//    Метод divisionByZero - Деление на 0
//    Метод numberFormatException - Ошибка преобразования строки в число
//    Важно: они не должны принимать никаких аргументов
    public static void arrayOutOfBoundsException() {
        int counter = 0;
        int[] arr = new int[] {1, 2, 3};

        for (int i = 0; i < 4; i++) counter += arr[i];
    }

    public static void divisionByZero() { int number = 5 / 0; }

    public static void numberFormatException() { Integer str = new Integer("A"); }

//    Реализуйте метод subArrays, принимающий в качестве аргументов два целочисленных массива a и b, и возвращающий
//    новый массив c, каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке.
//    Если длины массивов не равны - верните нулевой массив длины 1.
//    Напишите свой код в методе subArrays класса Answer. Метод subArrays принимает на вход два параметра:
//    int[] a - первый массив
//    int[] b - второй массив
    public static int[] subArrays(int[] a, int[] b) {
        int length = a.length;
        if (length != b.length) return new int[1];

        int[] c = new int[length];
        for (int i = 0; i < length; i++) c[i] = a[i] - b[i];
        return c;
    }

//    Реализуйте метод divArrays, принимающий в качестве аргументов два целочисленных массива a и b, и возвращающий
//    новый массив с, каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке.
//    Если длины массивов не равны - верните нулевой массив длины 1.
//    Важно: При выполнении метода единственное исключение, которое пользователь может увидеть - RuntimeException,
//    т.е.ваше.
//    Напишите свой код в методе divArrays класса Answer. Метод divArrays принимает на вход два параметра:
//    int[] a - первый массив
//    int[] b - второй массив
    public static int[] divArrays(int[] a, int[] b) {
        int length = a.length;
        if (length != b.length) return new int[1];

        int[] c = new int[length];
        for (int i = 0; i < length; i++) c[i] = a[i] / b[i];
        return c;
    }
}
