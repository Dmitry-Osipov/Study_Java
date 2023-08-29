package Algorithms.Lesson;


/*
Структурами данных называют некоторый контейнер с данными, обладающий специфическим внутренним устройством (макетом) и
логикой хранения. Различные макеты могут быть эффективны для некоторых операций и неэффективны для других.
Массив (для Python список) - это контейнер, хранящий данные, идентифицируемые по индексу. К любому элементу массива
всегда можно обратиться по его индексу или заменить его. Особенностью массива является то, что доступ к элементам по
индексу осуществляется за константное время, т.е. имеет сложность О(1).
Всего есть несколько стандартных операций с массивами: поиск по массиву, сортировка массива. Рассмотрим простые
алгоритмы сортировки, алгоритмы поиска, продвинутые алгоритмы сортировки.
 */

public class lesson2 {

    public static void main(String[] args) {
        int[] array1 = new int[]{4, 2, 5, 8, 1, 9, 2, 3, 6, 8};
        bubbleSort(array1);

        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + " ");
        }
        System.out.println();


        int[] array2 = new int[]{4, 2, 5, 8, 1, 9, 2, 3, 6, 8};
        directSort(array2);

        for (int i = 0; i < array2.length; i++) {
            System.out.print(array2[i] + " ");
        }
        System.out.println();


        int[] array3 = new int[]{4, 2, 5, 8, 1, 9, 2, 3, 6, 8};
        insertSort(array3);

        for (int i = 0; i < array3.length; i++) {
            System.out.print(array3[i] + " ");
        }
        System.out.println();


        int[] array4 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(simpleFind(array4, 5));


        int[] array5 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(binarySearch(array5, 5, 0, array5.length - 1));


        int[] array6 = new int[]{4, 2, 5, 8, 1, 9, 2, 3, 6, 8};
        quickSort(array6, 0, array6.length - 1);

        for (int i = 0; i < array6.length; i++) {
            System.out.print(array6[i] + " ");
        }
        System.out.println();


        int[] array7 = new int[]{4, 2, 5, 8, 1, 9, 2, 3, 6, 8};
        heapSort(array7);

        for (int i = 0; i < array7.length; i++) {
            System.out.print(array6[i] + " ");
        }
        System.out.println();
    }

    /*
    Простые алгоритмы сортировки: пузырьковая сортировка, сортировка выбором, сортировка вставками.
    Все простые алгоритмы поиска имеют одинаковую сложность O(n^2).
     */

    // Алгоритм сортировки пузырьком - сложность O(n^2).
    public static void bubbleSort(int[] array) {
        boolean finish;
        do {
            finish = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    finish = false;
                }
            }
        } while (!finish);
    }

    // Сортировка выбором - сложность O(n^2), но на один проход меньше, чем у пузырька.
    public static void directSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minPos]) {
                    minPos = j;
                }
            }
            if (i != minPos) {
                int temp = array[i];
                array[i] = array[minPos];
                array[minPos] = temp;
            }
        }
    }

    // Сортировка вставками - сложность O(n^2).
    public static void insertSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    /*
    Алгоритмы поиска: простой перебор, бинарный поиск.
    Для простого перебора не требуется сортировать массив.
    В свою очередь, бинарный поиск требует отсортированного массива.
     */

    // Простой перебор - сложность O(n).
    public static int simpleFind(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    // Бинарный поиск - сложность O(log(n)). min и max - это диапазон, в котором будет осуществляться бинарный поиск,
    // что позволит нам эту функцию рекурсивно вызывать постоянно, изменяя min и max, тем самым изменяя диапазон, в
    // котором хотим найти элементы, для которых хотим определить позицию.
    public static int binarySearch(int[] array, int value, int min, int max) {
        int midPoint;

        if (max < min) {
            return -1;
        }

        midPoint = (max - min) / 2 + min;
        if (array[midPoint] < value) {
            return binarySearch(array, value, midPoint + 1, max);
        }

        if (array[midPoint] > value) {
            return binarySearch(array, value, min, midPoint - 1);
        }

        return midPoint;
    }

    /*
    Продвинутые алгоритмы сортировки: быстрая сортировка, пирамидальная сортировка.

    Быстрая сортировка.
    Разделяй и властвуй - парадигма разработки алгоритмов, заключающаяся в рекурсивном разбиении решаемой задачи на две
    или более подзадачи того же типа, но меньшего размера, и комбинировании их решений для получения ответа к исходной
    задаче; разбиения выполняются до тех пор, пока все подзадачи не окажутся элементарными.
    Pivot - элемент, служащий точкой сравнения элементов и их "поворота", в случае необходимости.

    Пирамидальная сортировка.
    Бинарная куча. Если принять элемент с индексом i за родителя, то индексы его дочерних элементов будут 2 * i + 1 и
    2 * i + 2.
     */

    // Быстрая сортировка - сложность O(n * log(n)).
    public static void quickSort(int[] array, int startPos, int endPos) {
        int leftPos = startPos;
        int rightPos = endPos;
        int pivot = array[(startPos + endPos) / 2];

        do {
            while (array[leftPos] < pivot) {
                leftPos++;
            }
            while (array[rightPos] > pivot) {
                rightPos--;
            }
            if (leftPos <= rightPos) {
                if (leftPos < rightPos) {
                    int temp = array[leftPos];
                    array[leftPos] = array[rightPos];
                    array[rightPos] = temp;
                }
                leftPos++;
                rightPos--;
            }

        } while (leftPos <= rightPos);

        if (leftPos < endPos) {
            quickSort(array, leftPos, endPos);
        }
        if (startPos < rightPos) {
            quickSort(array, startPos, rightPos);
        }
    }

    // Пирамидальная сортировка - сложность O(n * log(n)).
    private static void heapify(int[] array, int heapSize, int rootIndex){
        int largest = rootIndex; // Инициализируем наибольший элемент как корень.
        int leftChild = 2 * rootIndex + 1; // Левый 2 * rootIndex + 1.
        int rightChild = 2 * rootIndex + 2; // Правый 2 * rootIndex + 2.

        // Если левый дочерний элемент больше корня.
        if (leftChild < heapSize && array[leftChild] > array[largest]){
            largest = leftChild;
        }

        // Если правый дочерний элемент больше, чем самый большой элемент на данный момент.
        if (rightChild < heapSize && array[rightChild] > array[largest]){
            largest = rightChild;
        }

        // Если самый большой элемент не корень.
        if (largest != rootIndex){
            int temp = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = temp;

            // Рекурсивно преобразуем в двоичную кучу затронутое поддерево.
            heapify(array, heapSize, largest);
        }
    }

    public static void heapSort(int[] array){
        // Построение кучи (перегруппировываем массив).
        for (int i = array.length / 2 - 1; i >= 0; i--){
            heapify(array, array.length, i);
        }

        // Один за другим извлекаем элементы из кучи.
        for (int i = array.length - 1; i >= 0; i--){
            // Перемещаем текущий корень в конец.
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Вызываем процедуру heapify на уменьшенной куче.
            heapify(array, i, 0);
        }
    }
}

