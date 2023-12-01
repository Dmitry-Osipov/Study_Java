package Lesson5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Homework {
    public static void main(String[] args) {
        // Напишите программу, представляющую телефонную книгу. Программа должна иметь следующие функции:
        // * add(String name, Integer phoneNum): Добавляет запись в телефонную книгу.
        //Если запись с именем name уже существует, добавляет новый номер телефона в существующую запись.
        //Если запись с именем name не существует, создает новую запись с этим именем и номером телефона phoneNum.
        // * find(String name): Поиск номеров телефона по имени в телефонной книге.
        //Если запись с именем name существует, возвращает список номеров телефона для этой записи.
        //Если запись с именем name не существует, возвращает пустой список.
        // * getPhoneBook(): Возвращает всю телефонную книгу в виде HashMap, где ключи - это имена, а значения - списки
        // номеров телефона.
        PhoneBook myBook = new PhoneBook();

        myBook.add("Alice", 123456);
        myBook.add("Bob", 789012);
        myBook.add("Alice", 789012);

        System.out.println(myBook.find("Alice"));
        System.out.println(myBook.find("Tom"));

        System.out.println(PhoneBook.getPhoneBook());

        // Вы работаете с приложением для учета имен пользователей. Ваша задача - разработать программу, которая
        // принимает на вход пять имен пользователей (или использует имена по умолчанию, если аргументы не
        // предоставлены) и подсчитывает, сколько раз каждое имя встречается. Программа должна использовать HashMap для
        // хранения имен и их количества вхождений. По завершении, программа выводит результат пар имя + количество.
        NamesCounter counter = new NamesCounter();

        counter.addName("Elena");
        counter.addName("Elena");
        counter.addName("Elena");
        counter.addName("Ivan");
        counter.addName("Ivan");

        counter.showNamesOccurrences();

        // Необходимо разработать программу для сортировки массива целых чисел с использованием сортировки кучей
        // (Heap Sort). Программа должна работать следующим образом:
        // Принимать на вход массив целых чисел для сортировки. Если массив не предоставлен, программа использует массив
        // по умолчанию.
        // Сначала выводить исходный массив на экран.
        // Затем применять сортировку кучей (Heap Sort) для сортировки элементов массива в порядке возрастания.
        // Выводить отсортированный массив на экран.
        // Ваше решение должно содержать два основных метода: buildTree, который строит сортирующее дерево на основе
        // массива, и heapSort, который выполняет собственно сортировку кучей. Основная часть кода предоставлена вам.
        // Программа должна быть способной сортировать массив, даже если он состоит из отрицательных чисел и имеет
        // дубликаты.
        // На входе:
        // '5 8 12 3 6 9'
        // На выходе:
        // Initial array:
        // [5, 8, 12, 3, 6, 9]
        // Sorted array:
        // [3, 5, 6, 8, 9, 12]
        int[] someArray = new int[] {17, 32, 1, 4, 25, 17, 0, 3, 10, 7, -64, 1};
        System.out.println("Initial array:");
        System.out.println(Arrays.toString(someArray));
        System.out.println("Sorted array:");
        HeapSort.heapSort(someArray, someArray.length);
        System.out.println(Arrays.toString(someArray));
    }

    static class PhoneBook {
        private static HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();

        public void add(String name, Integer phoneNum) {
            ArrayList<Integer> phones = new ArrayList<>();

            if (phoneBook.containsKey(name)) phones.addAll(phoneBook.get(name));
            phones.add(phoneNum);

            if (!phoneBook.containsKey(name)) phoneBook.put(name, phones);
            else phoneBook.replace(name, phones);
        }

        public ArrayList<Integer> find(String name) {
            if (phoneBook.containsKey(name)) return phoneBook.get(name);
            return new ArrayList<Integer>();
        }

        public static HashMap<String, ArrayList<Integer>> getPhoneBook() {
            return phoneBook;
        }
    }

    static class NamesCounter {
        private HashMap<String, Integer> names = new HashMap<>();

        public void addName(String name) {
            if (names.containsKey(name)) {
                Integer value = names.get(name) + 1;
                names.put(name, value);
            } else names.put(name, 1);
        }

        public void showNamesOccurrences() {
            System.out.println(names);
        }
    }

    static class HeapSort {
        // Процедура преобразования в двоичную кучу поддерева с кореневым узлом currentIndex
        public static void buildTree(int[] tree, int sortLength, int currentIndex) {
            int largest = currentIndex;  // Инициализируем наибольший элемент как корень
            int left = 2 * currentIndex + 1;  // Левый элемент дерева
            int right = 2 * currentIndex + 2; // Правый элемент дерева

            // Если левый элемент больше корня
            if (left < sortLength && tree[left] > tree[largest]) largest = left;

            // Если правый элемент больше корня
            if (right < sortLength && tree[right] > tree[largest]) largest = right;

            // Если самый большой элемент не корень
            if (largest != currentIndex) {
                int swap = tree[currentIndex];
                tree[currentIndex] = tree[largest];
                tree[largest] = swap;

                // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
                buildTree(tree, sortLength, largest);
            }
        }

        // Реализация пирамидальной сортировки
        public static void heapSort(int[] sortArray, int sortLength) {
            // Построение кучи (перегруппируем массив)
            for (int i = sortLength / 2 - 1; i >= 0 ; i--) {
                buildTree(sortArray, sortLength, i);
            }

            // Один за другим извлекаем элементы из кучи
            for (int i = sortLength - 1; i >= 0 ; i--) {
                // Перемещаем текущий корень в конец
                int temp = sortArray[0];
                sortArray[0] = sortArray[i];
                sortArray[i] = temp;

                // Вызываем процедуру buildTree на уменьшенной куче
                buildTree(sortArray, i, 0);
            }
        }
    }
}
