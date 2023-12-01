package Lesson6;

import java.util.*;

public class Lesson {
    public static void main(String[] args) {
        /*
        isEmpty() – проверка на пустоту.
        add(V) – добавление элемента в коллекцию.
        remove(V) – удаление элемента из коллекцию.
        contains(V) – проверка на включение элемента в коллекции.
        clear() – удаление всех элементов коллекции.
        size() – возвращает количество элементов коллекции.
        */
        Set<Integer> set = new HashSet<>();
        set.add(1); set.add(12); set.add(123);
        set.add(1234); set.add(1234);
        System.out.println(set.contains(12)); // true
        set.add(null);
        System.out.println(set.size()); // 5
        System.out.println(set); // [null, 1, 1234, 123, 12]
        set.remove(12);
        for (var item : set) System.out.println(item); // null 1 1234 123
        set.clear();
        System.out.println(set); // []

        /*
        addAll(Coll) – объединение множеств.
        retainAll(Coll) – пересечение множеств.
        removeAll(Coll) – разность множеств.
        */
        var a = new HashSet<>(Arrays.asList(1,2,3,4,5,6,7));
        var b = new HashSet<>(Arrays.asList(2,3,5,7,11,13,17));
        var u = new HashSet<Integer>(a); u.addAll(b);
        var r = new HashSet<Integer>(a); r.retainAll(b);
        var s = new HashSet<Integer>(a); s.removeAll(b);
        System.out.println(a); // [1, 2, 3, 4, 5, 6]
        System.out.println(b); // [17, 2, 3, 5, 7, 11]
        System.out.println(u); // [1, 17, 2, 3, 4, 5, 6, 11]
        System.out.println(r); // [2, 3, 5, 7]
        System.out.println(s); // [1, 4, 6]

        /*
        TreeSet:
        first()
        last()
        headSet(E)
        tailSet(E)
        subSet(E1, E2)
        */
        var e = new TreeSet<>(Arrays.asList(1,7,2,3,6,4,5));
        var q = new TreeSet<>(Arrays.asList(13,3,17,7,2,11,5));
        System.out.println(e); // [1, 2, 3, 4, 5, 6, 7]
        System.out.println(q); // [2, 3, 5, 7, 11, 13, 17]
        System.out.println(e.headSet(4)); // [1, 2, 3]
        System.out.println(e.tailSet(4)); // [4, 5, 6, 7]
        System.out.println(e.subSet(3, 5)); // [3, 4]

        /*
        LinkedHashSet:
        isEmpty() – проверка на пустоту.
        add(V) – добавление элемента в коллекцию.
        remove(V) – удаление элемента из коллекцию.
        contains(V) – проверка на включение элемента в коллекции.
        clear() – удаление всех элементов коллекции.
        size() – возвращает количество элементов коллекции.
        */
        var l = new LinkedHashSet<>(Arrays.asList(1,7,2,3,6,4,5));
        var i = new LinkedHashSet<>(Arrays.asList(13,3,17,7,2,11,5));
        l.add(28);
        System.out.println(l); // [1, 7, 2, 3, 6, 4, 5, 28]
        System.out.println(i); // [13, 3, 17, 7, 2, 11, 5]

        // Работаем с классом Worker:
        Worker w1 = new Worker();  // Каждый экземпляр класса будет разными объектами.
        w1.firstName = "Имя_1";
        w1.lastName = "Фамилия_1";
        w1.salary = 100;
        w1.id = 1000;

        Worker w4 = new Worker();  // Разные экземпляры классов с w1, хотя данные полностью одинаковые.
        w4.firstName = "Имя_1";
        w4.lastName = "Фамилия_1";
        w4.salary = 100;
        w4.id = 1000;

        Worker w2 = new Worker();
        w2.firstName = "Имя_2";
        w2.lastName = "Фамилия_2";
        w2.salary = 200;
        w2.id = 2000;

        Worker w3 = new Worker();
        w3.firstName = "Имя_3";
        w3.lastName = "Фамилия_3";
        w3.salary = 300;
        w3.id = 3000;

        var workers = new HashSet<Worker>(Arrays.asList(w1, w2, w3));
        System.out.println(workers.contains(w4));  // Делаем вывод, что сравнение идёт по хэшу, а не по данным внутри.
        System.out.println(w1);  // До собачки идёт расположение класса и класс, после собачки идёт хэш-код экземпляра.

        // Попробуем переписать метод toString внутри Worker (но я определю новый класс Worker1 для лучшей наглядности).
        Worker1 w5 = new Worker1();  // Каждый экземпляр класса будет разными объектами.
        w5.firstName = "Имя_1";
        w5.lastName = "Фамилия_1";
        w5.salary = 100;
        w5.id = 1000;

        Worker1 w8 = new Worker1();  // Разные экземпляры классов с w1, хотя данные полностью одинаковые.
        w8.firstName = "Имя_1";
        w8.lastName = "Фамилия_1";
        w8.salary = 100;
        w8.id = 1000;

        Worker1 w6 = new Worker1();
        w6.firstName = "Имя_2";
        w6.lastName = "Фамилия_2";
        w6.salary = 200;
        w6.id = 2000;

        Worker1 w7 = new Worker1();
        w7.firstName = "Имя_3";
        w7.lastName = "Фамилия_3";
        w7.salary = 300;
        w7.id = 3000;

        var newWorkers = new HashSet<Worker1>(Arrays.asList(w5, w6, w7));
        System.out.println(newWorkers.contains(w8));
        System.out.println(w5);
    }
}
