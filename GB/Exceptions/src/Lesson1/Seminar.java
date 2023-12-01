package Lesson1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Seminar {
    public static void main(String[] args) {
        ArrayList<Integer> firstArray = new ArrayList<>();
        for (int i = 0; i < 10; i++) firstArray.add(i);
        System.out.println(checkArraySize(firstArray, 3));
        System.out.println(checkArraySize(new ArrayList<>(), 3));

        int[] secondArray = new int [] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(findElement(secondArray, 3, 3));

        findElementMessage(secondArray, 3, 3);
        findElementMessage(secondArray, 3, 14);
        findElementMessage(secondArray, -4, 3);

        int[][] firstMatrix = new int[][] {
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 1, 0, 0},
                {0, 1, 1, 1}
        };
        System.out.println(sumElements(firstMatrix));

        Integer[] thirdArray = new Integer[] {null, 2, 3, 4, null, 6, 7, 8, 9, null};
        checkArray(thirdArray);
    }

//    Реализуйте метод, принимающий в качестве аргумента целочисленный массив.
//    Если длина массива меньше некоторого заданного минимума, метод возвращает -1, в качестве кода ошибки, иначе -
//    длину массива.
    public static int checkArraySize (List<Integer> array, int minSize) {
        int arraySize = array.size();
        if (arraySize < minSize) return -1;

        return arraySize;
    }

//    Реализуйте метод, принимающий в качестве аргумента целочисленный массив и некоторое значение. Метод ищет в
//    массиве заданное значение и возвращает его индекс. При этом, например:
//    если длина массива меньше некоторого заданного минимума, метод возвращает -1, в качестве кода ошибки.
//    если искомый элемент не найден, метод вернет -2 в качестве кода ошибки.
//    придумайте свои варианты исключительных ситуаций и верните соответствующие коды ошибок.
//    Напишите метод, в котором реализуйте взаимодействие с пользователем. То есть, этот метод запросит искомое
//    число у пользователя, вызовет первый, обработает возвращенное значение и покажет читаемый результат пользователю.
//    Например, если вернулся -2, пользователю выведется сообщение: “Искомый элемент не найден”.
    public static int findElement(int[] array, int element, int minSize) {
        int arraySize = array.length;
        if (arraySize < minSize) return -1;

        for (int i = 0; i < arraySize; i++) {
            if (array[i] == element) return i;
        }

        return -2;
    }

    public static void findElementMessage(int[] array, int element, int minSize) {
        int result = findElement(array, element, minSize);
        switch (result) {
            case -1 -> System.out.println("Длина массива меньше некоторого заданного минимума.");
            case -2 -> System.out.println("Искомый элемент не найден в массиве.");
            default -> System.out.println("Индекс элемента в массиве: " + result + ".");
        }
    }

//    Реализуйте метод, принимающий в качестве аргумента целочисленный двумерный массив.
//    Необходимо посчитать и вернуть сумму элементов этого массива.
//    При этом накладываем на метод 2 ограничения: метод может работать только с квадратными массивами
//    (кол-во строк = кол-ву столбцов), и в каждой ячейке может лежать только значение 0 или 1.
//    Если нарушается одно из условий, метод должен бросить RuntimeException с сообщением об ошибке.
    public static int sumElements(int[][] squareMatrix) {
        int result = 0;
        int rows = squareMatrix.length;

        for (int i = 0; i < rows; i++) {
            if (rows != squareMatrix[i].length) throw new RuntimeException("Матрица не является квадратной.");
            for (int j = 0; j < squareMatrix[i].length; j++) {
                if ((squareMatrix[i][j] != 0) && (squareMatrix[i][j] != 1)) throw new RuntimeException("Элемент не является 0 или 1.");
                result += squareMatrix[i][j];
            }
        }

        return result;
    }

//    Реализуйте метод checkArray(Integer[] arr), принимающий в качестве аргумента целочисленный одномерный массив.
//    Метод должен пройтись по каждому элементу и проверить, что он не равен null.
//    А теперь реализуйте следующую логику:
//    1. Если в какой-то ячейке встретился null, то необходимо "оповестить" об этом пользователя;
//    2. Если null'ы встретились в нескольких ячейках, то идеально было бы все их подсветить.
    public static void checkArray(Integer[] arr) {
        ArrayList<Integer> nullsIndexes = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) nullsIndexes.add(i);
        }

        if (!nullsIndexes.isEmpty()) throw new RuntimeException("В массиве есть null'ы. Их индексы: " + nullsIndexes);
    }
}
