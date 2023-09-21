package Lesson1;

import java.util.Arrays;
import java.util.Random;

public class Seminar {
    public static void main(String[] args) {
        /*
        Примитивные (не ссылочные) типы данных: int, float, double, long, short, byte, boolean, char.
        Ссылочные типы данных: массивы, листы, мапы, сеты, сканер и всё остальное, кроме примитивов.
        */

        int[] digits = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(Arrays.toString(digits));  // Нельзя написать просто название массива, ибо некорректно отработает.

        int[][] some_digits = { {-1, -2, -3, -4, -5, -6, -7, -8}, {1, 2, 3, 4, 5, 6, 7, 8}};
        // System.out.println(Arrays.toString(some_digits)); - не отработает корректно - покажет свойства вложенных списков.
        for (int i = 0; i < some_digits.length; i++){
            for (int j = 0; j < some_digits[0].length; j++){
                System.out.print(some_digits[i][j] + " ");
            }
            System.out.println();
        }

        String s = "Привет, мир программирования!";  // Упрощённая запись от String s = new String("Привет!");
        System.out.println(s.length());
        System.out.println(s.replace("р", "ы"));  // Как и в Python строка не является изменяемым типом данных.

        // Создать строку с текстом. Вывести только чётные символы.
        String myText = "Добрый день! Как Ваши дела?";
        for (int i = 0; i < myText.length(); i += 2){
            System.out.print(myText.charAt(i));
        }
        System.out.println();

        // Написать алгоритм расчёта арифметической прогрессии.
        int stop = 10;
        int step = 1;
        for (int i = 0; i <= stop; i+=step) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Реализовать то же самое, но чтобы в теле цикла ничего не было.
        int sum = 0;
        for (int i = 0; i < stop; i+= step, sum+=i);  // В данной операции он всегда считает следующий элемент в sum.
        System.out.println(sum);

        // Выкинуть случайное число, сохранить в переменную. Целое число от 0 ло 1000.
        int randInt = new Random().nextInt(1001);
        System.out.println("Рандомное число = " + randInt);

        // Решить используя высокоуровневые инструменты: найти старший значащий бит.
        System.out.println(Integer.toBinaryString(randInt).length());  // Данный метод даёт битовое представление числа,
        // отбрасывая все незначащие нули слева.

        // Найти старший значащий бит выпавшего числа, не используя высокоуровневые инструменты. Вывести в консоль его номер.
        var res = 0;
        while (randInt != 0) {
           randInt /= 2;
           res++;
        }
        System.out.println(res);
    }
}
