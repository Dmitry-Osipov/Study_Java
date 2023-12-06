package Lesson3.Interview;

import java.util.*;

public class Program {
    public static void main(String[] args) {
        Operationable number;
        number = (x, y) -> x * y;
        System.out.println(number.calculate(10, 20));

        System.out.println(integrate(3, 2));
        System.out.println(integrate(12, 5));
        System.out.println(integrate(40, 3));

        System.out.println(findSmallest(new int[]{1, 2, 3, 4, 5}, "value"));
        System.out.println(findSmallest(new int[]{1, 2, 3, 4, 5}, "index"));

        System.out.println(stringy(4));
        System.out.println(stringy(6));
        System.out.println(stringy(12));

        System.out.println(tripleTrouble("this", "test", "lock"));
        System.out.println(tripleTrouble("aa", "bb", "cc"));
        System.out.println(tripleTrouble("LLh", "euo", "xtr"));

        System.out.println(repeats(new int[] {4, 5, 7, 5, 4, 8}));
        System.out.println(repeats(new int[] {9, 10, 19, 13, 19, 13}));
        System.out.println(repeats(new int[] {16, 0, 11, 4, 8, 16, 0, 11}));

        System.out.println(datingRange(17));
        System.out.println(datingRange(40));
        System.out.println(datingRange(15));

        System.out.println(quadrant(1, 2));
        System.out.println(quadrant(-10, 100));
        System.out.println(quadrant(-11, -9));

        System.out.println(isLeapYear(2020));
        System.out.println(isLeapYear(2000));
        System.out.println(isLeapYear(2015));
        System.out.println(isLeapYear(2100));

        System.out.println(evenOrOdd(1));
        System.out.println(evenOrOdd(2));
        System.out.println(evenOrOdd(-1));

        System.out.println(points(new String[] {"0:1","0:2","0:3","0:4","1:2","1:3","1:4","2:3","2:4","3:4"}));
        System.out.println(points(new String[] {"1:0","2:0","3:0","4:0","2:1","1:3","1:4","2:3","2:4","3:4"}));
        System.out.println(points(new String[] {"1:0","2:0","3:0","4:4","2:2","3:3","1:4","2:3","2:4","3:4"}));

        System.out.println(nbYear(1500, 5, 100, 5000));
        System.out.println(nbYear(1500000, 2.5, 10000, 2000000));
        System.out.println(nbYear(1500000, 0.25, 1000, 2000000));

        System.out.println(gimmeTheLetters("a-z"));
        System.out.println(gimmeTheLetters("h-o"));
        System.out.println(gimmeTheLetters("Q-Z"));

        System.out.println(findAverange(new int[] {1}));
        System.out.println(findAverange(new int[] {1, 3, 5, 7}));

        System.out.println(ReturnProduct(new int[][] {{1,0},{0,1}}));
        System.out.println(ReturnProduct(new int[][] {{1,2,3},{4,5,6},{7,8,9}}));

        System.out.println(isDigit("3"));
        System.out.println(isDigit("  3  "));
        System.out.println(isDigit("-3.23"));

        System.out.println(isDivisible(3, 3, 4));
        System.out.println(isDivisible(12, 3, 4));
        System.out.println(isDivisible(8, 3, 4, 2, 5));

        System.out.println(Arrays.toString(NumbersWithDigitInside(5, 6)));
        System.out.println(Arrays.toString(NumbersWithDigitInside(11, 1)));
        System.out.println(Arrays.toString(NumbersWithDigitInside(20, 0)));
        System.out.println(Arrays.toString(NumbersWithDigitInside(44, 4)));

        System.out.println(Arrays.toString(sortCards(new String[]{"3", "9", "A", "5", "T", "8", "2", "4", "Q", "7", "J", "6", "K"})));
        System.out.println(Arrays.toString(sortCards(new String[]{"Q", "2", "8", "6", "J", "K", "3", "9", "5", "A", "4", "7", "T"})));
        System.out.println(Arrays.toString(sortCards(new String[]{"5", "4", "T", "Q", "K", "J", "6", "9", "3", "2", "7", "A", "8"})));

        System.out.println(sumMul(2, 9));
        System.out.println(sumMul(5, 20));
        System.out.println(sumMul(4, 123));

        System.out.println(Arrays.toString(squareOreSquareRoot(new int[]{4, 3, 9, 7, 2, 1})));
        System.out.println(Arrays.toString(squareOreSquareRoot(new int[]{100, 101, 5, 5, 1, 1})));
        System.out.println(Arrays.toString(squareOreSquareRoot(new int[]{1, 2, 3, 4, 5, 6})));
        }

    public static String integrate(int coefficient, int exponent) {
        int exp = exponent + 1;
        int coef = coefficient / exp;
        return String.format("%dx^%d", coef, exp);
    }

    public static int findSmallest(final int[] numbers, final String toReturn) {
        Integer index = null;

        for (int i = 0; i < numbers.length; i++) {
            if (index == null || numbers[i] < numbers[index]) index = i;
        }

        if (toReturn == "value") return numbers[index];
        return index;
    }

    public static String stringy(int size) {
        StringBuilder str = new StringBuilder("1");
        for (int i = 0; i < size - 1; i++) {
            if (i % 2 == 0) str.append("0");
            else str.append("1");
        }

        return str.toString();
    }

    public static String tripleTrouble(String one, String two, String three) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < one.length(); i++) {
            result.append(one.charAt(i));
            result.append(two.charAt(i));
            result.append(three.charAt(i));
        }

        return result.toString();
    }

    public static int repeats(int[] arr) {
        List<Integer> numbers = new ArrayList<>();
        for (int number : arr) numbers.add(number);

        HashMap<Integer, Integer> counter = new HashMap<>();
        for (Integer number : numbers) {
            if (!counter.containsKey(number)) counter.put(number, 0);
            else counter.put(number, counter.get(number)+1);
        }

        int count = 0;
        for (Integer number : counter.keySet()) {
            if (counter.get(number) < 1) count += number;
        }

        return count;
    }

    public static String datingRange(int age) {
        int min;
        int max;
        if (age <= 14) {
            min = (int) (age - 0.10 * age);
            max = (int) (age + 0.10 * age);
        } else {
            min = age / 2 + 7;
            max = (age - 7) * 2;
        }
        return String.format("%d-%d", min, max);
    }

    public static int quadrant(int x, int y) {
        if (x > 0 && y > 0) return 1;
        if (x < 0 && y > 0) return 2;
        if (x < 0 && y < 0) return 3;
        return 4;
    }

    public static boolean isLeapYear(int year) {
        if (year % 100 == 0 && year % 400 != 0) return false;
        if (year % 4 == 0) return true;
        return year % 400 == 0;
    }

    public static String evenOrOdd(int number) {
        return (number % 2 == 0) ? "Even" : "Odd";
    }

    public static int points(String[] games) {
        int counter = 0;
        for (int i = 0; i < games.length; i++) {
            if (Integer.parseInt(String.valueOf(games[i].charAt(0))) > Integer.parseInt(String.valueOf(games[i].charAt(2)))) counter += 3;
            else if (Integer.parseInt(String.valueOf(games[i].charAt(0))) == Integer.parseInt(String.valueOf(games[i].charAt(2)))) counter += 1;
        }

        return counter;
    }

    public static int nbYear(int p0, double percent, int aug, int p) {
        int years = 0;
        percent /= 100.0;
        while (p0 < p) {
            p0 = (int) (p0 + p0 * percent + aug);
            years++;
        }

        return years;
    }

    public static String gimmeTheLetters(String s) {
        String[] chars = s.split("-");
        StringBuilder str = new StringBuilder();
        for (int i = chars[0].codePointAt(0); i <= chars[1].codePointAt(0); i++) {
            str.append((char) i);
        }
        return str.toString();
    }

    public static int findAverange(int[] nums) {
        int count = 0;
        for (int number : nums) count += number;
        return count / nums.length;
    }

    public static int ReturnProduct(int[][] matrix) {
        int count = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == j) count *= matrix[i][j];
            }
        }
        return count;
    }

    public static boolean isDigit(String s) {
        s = s.trim();
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isDivisible(int ...args) {
        for (int i = 1; i < args.length; i++) if (args[0] % args[i] != 0) return false;

        return true;
    }

    public static long[] NumbersWithDigitInside(long x, long d) {
        String subString = String.format("%d", d);
        ArrayList<Long> numbers = new ArrayList<>();
        for (long i = d; i <= x; i++) if (String.format("%d", i).contains(subString) && i != 0) numbers.add(i);

        if (numbers.isEmpty()) return new long[]{0, 0, 0};

        long sum = 0;
        long prod = 1;
        for (long number : numbers) {
            sum += number;
            prod *= number;
        }
        return new long[]{numbers.size(), sum, prod};
    }

    public static String[] sortCards(String[] cards) {
        HashMap<String, Integer> priority = new HashMap<>();
        for (String card : cards) {
            try {
                priority.put(card, Integer.parseInt(card));
            } catch (NumberFormatException e) {
                if (card == "A") priority.put(card, 1);
                else if (card == "T") priority.put(card, 10);
                else if (card == "J") priority.put(card, 11);
                else if (card == "Q") priority.put(card, 12);
                else if (card == "K") priority.put(card, 13);
            }
        }

        ArrayList<String> result = new ArrayList<>();
        result.addAll(Arrays.asList(cards));
        int arraySize = result.size();
        result.sort(((o1, o2) -> { return priority.get(o1).compareTo(priority.get(o2)); }));
        String[] sortedCards = new String[arraySize];
        for (int i = 0; i < arraySize; i++) sortedCards[i] = result.get(i);
        return sortedCards;
    }

    public static long sumMul(int n, int m) {
        if (m <= 0 || n < 0) throw new IllegalArgumentException();
        long count = 0;
        for (int i = n; i < m; i++) if (i % n == 0) count += i;

        return count;
    }

    public static int[] squareOreSquareRoot(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (Math.sqrt(array[i]) % 1 == 0) array[i] = (int) Math.sqrt(array[i]);
            else array[i] = (int) Math.pow(array[i], 2);
        }
        return array;
    }

    private static Boolean isPrime(int number, int divisor) {
        if (number < 2) return false;
        if (number == 2) return true;
        if (number % divisor == 0) return false;
        if (divisor * divisor > number) return true;

        return isPrime(number, divisor + 1);
    }
}

interface Operationable {
    int calculate(int x, int y);
}

