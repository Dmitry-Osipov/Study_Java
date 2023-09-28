package Lesson3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Homework {
    public static void main(String[] args) {
        // Реализуйте сортировку слиянием по не убыванию в массиве.
        int[] firstArray = new int[] {2, 3, 1, 0, 6, 8, 3, 5, -1, -20};
        mergeSort(firstArray);
        for (int item : firstArray) System.out.print(item + " ");
        System.out.println();

        // Удаление чётных элементов в массиве.
        Integer[] secondArray = new Integer[] {3, 5, 6, 8, 0, -2, 4, 9, 12, 6, 75, 83, -23};
        removeEvenNumbers(secondArray);
        System.out.println();
        Integer[] thirdArray = new Integer[] {20, 0, 22, -12, 2, 4};
        removeEvenNumbers(thirdArray);
        System.out.println();

        // Напишите метод, который выводит максимальный и минимальный элементы списка, avg и сортирует список.
        Integer[] fourthArray = new Integer[]{101, -82, 78, 821, -91, 0, 21, 47, 72, 12, -701, 1010};
        analyzeNumbers(fourthArray);
    }

    public static void mergeSort(int[] a) {
        Integer length = a.length;
        if (length <= 1) {
            return;
        }

        Integer middle = length / 2;
        ArrayList<Integer> tempLeft = new ArrayList<>();
        for (int i = 0; i < middle; i++) {
            tempLeft.add(a[i]);
        }

        ArrayList<Integer> tempRight = new ArrayList<>();
        for (int i = middle; i < length; i++) {
            tempRight.add(a[i]);
        }

        int[] leftHalf = new int[tempLeft.size()];
        for (int i = 0; i < leftHalf.length; i++) {
            leftHalf[i] = tempLeft.get(i);
        }

        int[] rightHalf = new int[tempRight.size()];
        for (int i = 0; i < rightHalf.length; i++) {
            rightHalf[i] = tempRight.get(i);
        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(a, leftHalf, rightHalf);
    }

    private static void merge(int[] result, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                result[k] = left[i];
                i++;
            } else {
                result[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < left.length) {
            result[k] = left[i];
            i++;
            k++;
        }

        while (j < right.length) {
            result[k] = right[j];
            j++;
            k++;
        }
    }

    public static void removeEvenNumbers(Integer[] arr) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) temp.add(arr[i]);
        }

        Integer[] result = new Integer[temp.size()];
        if (result.length > 0) {
            for (int i = 0; i < result.length; i++) {
                result[i] = temp.get(i);
            }
        }

        for (Integer item : result) System.out.print(item + " ");
    }

    public static void analyzeNumbers(Integer[] arr) {
        ArrayList<Integer> result = new ArrayList<>(List.of(arr));
        result.sort(Comparator.naturalOrder());
        System.out.println(result);
        System.out.println("Minimum is " + result.get(0));
        System.out.println("Maximum is " + result.get(result.size() - 1));
        System.out.println("Average is " + avg(result));
    }

    private static int avg(ArrayList<Integer> arr) {
        if (arr.isEmpty()) {
            return 0;
        }

        int sum = 0;
        for (int number : arr) sum += number;

        return sum / arr.size();
    }
}
