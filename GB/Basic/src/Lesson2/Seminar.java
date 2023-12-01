package Lesson2;

public class Seminar {
    public static void main(String[] args) {
        // Объявить строку с текстом, подсчитать количество запятых
        String str = "Привет, мир! Я, Дмитрий, рад приветствовать тебя.";
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ',') {
                count++;
            }
        }
        System.out.println(count);

        // Задать две строки. Найти все вхождения первой строки во вторую. Вывести в консоль количество и индексы начала
        String text = "Вторая строка Первая строка";
        String substr = "а";

        int count1 = countMatches(text, substr);
        System.out.println("Счётчик - " + count1);

        // Заполнить строку и StringBuilder 1000ю символами. Сравнить время заполнения
        }

    public static boolean isEmpty(String s) {
        return s == null || s.length() == 0;
    }

    /* Подсчитывает, сколько раз подстрока появляется в большей строке. */
    public static int countMatches(String text, String str)
    {
        if (isEmpty(text) || isEmpty(str)) return 0;

        int index = 0, count = 0;
        System.out.print("Индексы - ");
        while (true)
        {
            index = text.indexOf(str, index);
            if (index != -1)
            {
                count++;
                System.out.print(index + " ");
                index += str.length();
            }
            else break;
        }
        System.out.println();
        return count;
    }
}
