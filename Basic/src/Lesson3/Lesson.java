package Lesson3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Lesson {
    public static void main(String[] args) {
        Object o = 1;  // В Object можно положить что угодно.
        System.out.println(o.getClass());
        o = 1.2;
        System.out.println(o.getClass());

        /*
        Коллекции в Java.
        Иерархия коллекций:

        LinkedHashSet => HashSet -
                                  |
                                  -------------------------------------------> <<interface>> Set ==
                                                                          ||                      ||
        TreeSet -> <<interface>> NavigableSet => <<interface>> SortedSet =                        ||
                                                                                                  ||
        ArrayList --                                                                              ||
                    |                                                                             ||
                    --> <<interface>> List ============================================================> <<interface>> Collection
                    |                                                                             ||
        Vector -----|                                                                             ||
                    |                                                                             ||
        LinkedList -                                                                              ||
                    |                                                                             ||
                     ----> <<interface>> Queue ====================================================
                       |
        PriorityQueue -

        P.s.: ---> (и переход: |) Реализовывает, а ===> (и переход: ||) Расширяет.
        */

        // ArrayList - "удобный массив". Способ создания:
        ArrayList list = new ArrayList();
        /*
        List – пронумерованный набор элементов. Пользователь этого интерфейса имеет точный контроль над тем, где в
        списке вставляется каждый элемент. Пользователь может обращаться к элементам по их целочисленному индексу
        (позиции в списке) и искать элементы в списке.
        ArrayList, LinkedList (Vector, Stack – устаревшие)
        */
        // Разные способы создания:
        ArrayList<Integer> list1 = new ArrayList<Integer>();  // Такое обобщение позволит избежать ошибки типов.
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>(10);
        ArrayList<Integer> list4 = new ArrayList<>(list3);
        /*
        add(args) – добавляет элемент в список ( в т.ч. на нужную позицию)
        get(pos) – возвращает элемент из списка по указанной позиции
        indexOf(item) – первое вхождение или -1
        lastIndexOf(item) – последнее вхождение или -1
        remove(pos) – удаление элемента на указанной позиции и его возвращение
        set(int pos, T item) – gjvtoftn значение item элементу, который находится на позиции pos
        void sort(Comparator) – сортирует набор данных по правилу
        subList(int start, int end) – получение набора данных от позиции start до end
        */
        int day = 27;
        int month = 9;
        int year = 2023;
        Integer[] date = {day, month, year};
        List<Integer> d = Arrays.asList(date);
        System.out.println(d);
        /*
        clear() – очистка списка
        toString() – «конвертация» списка в строку
        Arrays.asList – преобразует массив в список
        containsAll(col) – проверяет включение всех элементов из col
        removeAll(col) – удаляет элементы, имеющиеся в col
        retainAll(col) – оставляет элементы, имеющиеся в col
        toArray() – конвертация списка в массив Object’ов
        toArray(type array) – конвертация списка в массив type
        List.copyOf(col) – возвращает копию списка на основе имеющегося
        List.of(item1, item2,...) – возвращает неизменяемый список
        */
        Character value = null;
        List<Character> list5 =
                List.of('S', 'e', 'r', 'g', 'e', 'y');
        System.out.println(list1);
        // list1.remove(1); // java.lang.UnsupportedOperationException
        List<Character> list6 = List.copyOf(list5);
        System.out.println(list6);
        // not null, immutable

        /*
        Итератор.

        Получение итератора с целью более гибкой работы с данными. Интерфейс Iterator<E>. Итератор коллекцией.
        Iterator занимает место Enumeration в Java Collections Framework. Итераторы отличаются от перечислений двумя
        способами: Итераторы позволяют вызывающей стороне удалять элементы из базовой коллекции во время итерации с
        четко определенной семантикой.
        hasNext(), next(), remove()
        ListIterator<E>
        hasPrevious(), E previous(), nextIndex(), previousIndex(), set(E e), add(E e)
        */
        List<Integer> list7 = List.of(1, 12, 123, 1234, 12345);
        for (int item : list7) { System.out.println(item); }
        Iterator<Integer> col = list7.iterator();
        while (col.hasNext()) {
            System.out.println(col.next());
            // col.next();
            // col.remove(); - Получим ошибку.
        }

    }
}
