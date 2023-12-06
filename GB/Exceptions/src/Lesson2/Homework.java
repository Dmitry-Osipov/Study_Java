package Lesson2;

public class Homework {
    public static void main(String[] args) {
        System.out.println(isFloat("3.14"));
        System.out.println(isFloat("Ivan"));

        System.out.println(expr(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, 1));
        System.out.println(expr(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, 0));
        System.out.println(expr(new int[] {12, 23, 12, 98, 111}, 18));

        printSum(12, 5);
        System.out.println(div(12, 5));
        printSum(13, 0);
        System.out.println(div(13, 0));

        try {
            System.out.println("Result: " + useless('0'));
            System.out.println(useless(' '));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Напишите программу, которая проверяет, является ли введенная текстовая строка числом с плавающей точкой (float).
    // Программа пытается преобразовать введенную строку в число float, и если это успешно, она выводит полученное число.
    // Если преобразование не удалось, программа выдаёт сообщение об ошибке и возвращает специальное значение Float.NaN,
    // чтобы обозначить ошибку.
    public static float isFloat(String input) {
        try {
            float result = Float.parseFloat(input);
            return result;
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return Float.NaN;
        }
    }

    // Напишите программу, которая вычисляет значение выражения intArray[8] / d, гдеintArray- массив целых чисел,
    // а d - делитель.
    // Программа проверяет, имеется ли в массиве intArray элемент с индексом 8, и если нет, выводит сообщение о
    // невозможности выполнения операции.
    // Также программа проверяет, равен ли делитель d нулю, и если да, выводит соответствующее сообщение.
    public static double expr(int[] intArray, int d) {
        if (d == 0) {
            System.out.printf("It's not possible to evaluate the expression - intArray[8] / d as d = %d.%n", d);
            return Double.NaN;
        }

        if (intArray.length < 8) {
            System.out.printf("It's not possible to evaluate the expression - intArray[8] / d as there is no 8th element in the given array.%n");
            return Double.NaN;
        }

        System.out.printf("intArray[8] / d = %d / %d = 9.0%n", intArray[8], d);
        return (double) intArray[8] / d;
    }

    // Напишите программу для выполнения арифметической операции деления двух целых чисел a и b.
    // При этом программа должна проверить, что делитель b не равен нулю, и выполнить деление только в этом случае.
    // Если b равен нулю, программа должна вывести сообщение о невозможности выполнения операции и вернуть результат
    // равный нулю.
    // После выполнения операции деления, программа также должна вывести сумму чисел a и b с помощью метода printSum.
    // Если аргументы не переданы через командную строку, используйте значения по умолчанию.
    // На входе:
    // '12'
    // '5'
    // На выходе:
    // 17
    // 2.4
    public static double div(int a, int b) {
        if (b == 0) {
            System.out.println("Невозможно выполнить операцию.");
            return 0.0;
        }

        return (double) a / b;
    }

    public static void printSum(int a, int b) {
        System.out.println(a + b);
    }

    // Напишите программу, которая принимает символ a в качестве аргумента и выполняет следующую проверку:
    // если символ a равен пробелу '', программа должна выбрасывать исключение с сообщением
    // "Пустая строка введена.".
    // В противном случае программа должна возвращать сообщение
    // "Ваш ввод - [символ]", где [символ] заменяется на введенный символ a.
    public static String useless(char a) throws Exception {
        if (a == ' ') throw new Exception("Empty string has been input.");

        return String.format("Your input was - %c", a);
    }
}
