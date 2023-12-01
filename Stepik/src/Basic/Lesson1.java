package Basic;

public class Lesson1 {
    /*
    Стандартные типы данных:
    Названия типа:  Описание:
    byte            для целочисленных чисел в диапазоне от -128 до 127, занимает 1 байт;
    short           для целочисленных чисел в диапазоне от -32_768 до 32_767, занимает 2 байта;
    int             для целочисленных чисел в диапазоне от -2_147_483_648 до 2_147_483_647, занимает 4 байта;
    long            для целочисленных чисел в диапазоне от -9_223_372_036_854_775_808 до 9_223_372_036_854_775_807,
                    занимает 8 байт;
    float           для вещественных чисел в диапазоне от -3,4 * 10^38 до 3,4 * 10^38, занимает 4 байта;
    double          для вещественных чисел в диапазоне от +-4,9 * 10^-324 до +-1,8 * 10^308, занимает 8 байт;
    char            для одиночного символа в кодировке UTF-16, занимает 2 байта (также можно записывать целые числа в
                    диапазоне от 0 до 65_535);
    boolean         для булевых значений true и false (размер спецификацией языка строго не определён).
     */
    public static void main(String[] args) {
        short a;
        short b = 5;
        int A, B;
        double e = 5.5, f;
        float var_f = 3.5f;
        char ch = 'b';
        boolean fl = true, flF = false;
        final double PI = 3.14;

        System.out.println("Hello World!");
        System.out.println(b);
//        System.out.println(a);
        System.out.println(e);

        a = 6;
        int i = 1;
        i++;
        System.out.println(i);
        int c = 10;
        short q = 5;
        a = q;
        q = (short) c;  // Приведение типов при даунгрейде.
        float var_fl = 8.7f;
        int var_i;
        var_i = (int) var_fl;
        System.out.println(var_i);
    }
}
