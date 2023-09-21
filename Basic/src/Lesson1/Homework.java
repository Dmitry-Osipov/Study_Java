package Lesson1;

public class Homework {
    public static void main(String[] args) {
        // Вычислить n-ое треугольного число(сумма чисел от 1 до n).
        System.out.println(countNTriangle(5));

        // Вывести простые числа в промежутке от 1 до 1000, каждое число на новой строке.
        printPrimeNums();

        // Реализуйте простой калькулятор, который должен возвращать результат вычислений. При некорректном действии от
        // пользователя калькулятор должен выдать "Некорректный оператор: 'оператор'"
        System.out.println(calculate('+', 3, 7));
    }

    public static Integer countNTriangle(int number) {
        return (number * (number + 1)) / 2;
    }

    public static void printPrimeNums() {
        for (int i = 1; i < 1000; i++) {
            if (isPrime(i, 2)) System.out.println(i);
        }

    }

    private static Boolean isPrime(int number, int divisor) {
        if (number < 2) return false;
        if (number == 2) return true;
        if (number % divisor == 0) return false;
        if (divisor * divisor > number) return true;

        return isPrime(number, divisor + 1);
    }

    public static String calculate(char op, int a, int b) {
        Integer result;
        switch (op) {
            case '+' -> result = a + b;
            case '-' -> result = a - b;
            case '*' -> result = a * b;
            case '/' -> {if (b != 0) result = a / b; else {return "На ноль делить нельзя";}}
            default -> {return "Некорректный оператор: '" + op + "'" ;}
        }
        return result.toString();
    }
}
