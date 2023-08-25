package Algorithms.Seminar;

public class lesson1 {

    // Написать программу, считывающую сумму от 1 до n. Сложность данного алгоритма O(n).
    public static int findSum(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            count += i;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(findSum(5));

        // Написать алгоритм поиска простых чисел (делятся только на себя и на 1) в диапазоне от 1 до N.
        // В алгоритме будет использоваться вложенный for, что явно говорит о сложности O(n^2).
        findSimpleNumbers(13);

        // Посчитать количество действий для разных способов вычисления вариантов выпадения 4 кубиков.

        // Решение с 4 циклами for:
        System.out.println(cyclesCounter(6));

        // Решение с рекурсией:
        System.out.println(recursiveCounter(1, 4, 6));

        // Пишем алгоритм поиска нужного числа последовательности Фибоначчи.
        // Считаем, что 1 и 2 значения последовательности равны 1.
        // Искать будем по формуле On=On-1+On-2 что предполагает использовать рекурсивного алгоритма.

        System.out.println(findFib(7));
        System.out.println(findFibWhile(7));
    }

    // Написать алгоритм поиска простых чисел (делятся только на себя и на 1) в диапазоне от 1 до N.
    // В алгоритме будет использоваться вложенный for, что явно говорит о сложности O(n^2).
    public static void findSimpleNumbers(int number) {
        for (int i = 1; i <= number; i++) {
            boolean flag = true;
            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println(i);
            }
        }
    }

    // Решение с 4 циклами for:
    public static int cyclesCounter(int faces) {
        int count = 0;
        for (int i = 0; i < faces; i++) {
            for (int j = 0; j < faces; j++) {
                for (int k = 0; k < faces; k++) {
                    for (int l = 0; l < faces; l++) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    // Решение с рекурсией:
    public static int recursiveCounter(int depth, int maxDepth, int faces) {
        int count = 0;
        for (int i = 1; i <= faces; i++) {
            if (depth == maxDepth) {
                count++;
            } else {
                count += recursiveCounter(depth + 1, maxDepth, faces);
            }
        }
        return count;
    }

    // Пишем алгоритм поиска нужного числа последовательности Фибоначчи.
    // Считаем, что 1 и 2 значения последовательности равны 1.
    // Искать будем по формуле On=On-1+On-2 что предполагает использовать рекурсивного алгоритма.
    public static int findFib(int number) {  // Сложность O(2^n)
        if (number == 1 || number == 2) {
            return 1;
        }
        return findFib(number - 1) + findFib(number - 2);
    }

    public static int findFibWhile(int number) {  // Сложность O(n)
        int count = 1;
        int temp = 1;
        for (int i = 2; i < number; i++) {
            int t = count;
            count = count + temp;
            temp = t;
        }
        return count;
    }
}
