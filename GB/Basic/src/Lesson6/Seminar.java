package Lesson6;

import java.util.HashMap;
import java.util.Iterator;

public class Seminar {
    public static void main(String[] args) {
        // Разработать класс, исполняющий функционал класса HashSet без использования сетов вообще. Храним целые числа.
        // Реализовать метод добавления элемента учитывающий особенности множеств. Сигнатура метода public boolean add(Integer i).
        // Реализовать метод удаления элемента учитывающий особенности множеств. Сигнатура метода boolean remove(Object o).
        // Реализовать метод удаления всех элементов множества. Сигнатура метода void clear().
        MySet<String> mySet = new MySet<>();
        System.out.println(mySet.add("dhsj"));
        System.out.println(mySet.add("ds"));

        Iterator<String> iter = mySet.iterator();
        while (iter.hasNext()) System.out.println(iter.next());

        System.out.println(mySet.remove("jkjkjk"));
        mySet.clear();
        System.out.println(mySet.remove("ds"));
    }
}


class MySet <E> {
    private HashMap<E, Object> map = new HashMap<>();
    private static final Object PRESENT = new Object();
    private int count = 0;


    public boolean add (E e) { return map.put(e, PRESENT) == null; }

    public boolean remove (Object o) { return map.remove(o) == PRESENT; }

    public void clear() { map.clear(); }

      // Упрощённая реализация итератора:
//    @Override
//    public boolean hasNext() {
//        return map.size() > count;
//    }
//
//    @Override
//    public Integer next() {
//        return (Integer) map.keySet().toArray()[count++];
//    }

    // Нормальный итератор:
    public Iterator<E> iterator() { return map.keySet().iterator(); }
}
