package Lesson3;

import java.util.*;

import static java.lang.Math.abs;

public class Seminar {
    public static void main(String[] args) {
        // Код преподавателя:
        Object o = new Object();

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>(Arrays.asList(0,1,2,3));

        for (int i = 0; i < 10; i++) {
            list.add(new Random().nextInt(10));
            list1.add(new Random().nextInt(10));
        }

        list.add(1);
        list.add(0, 2);
        list1.addAll(0, list);
        Integer i = 1;
        list.remove(1);
        list.remove(i);
        list.contains(i);
        i = list.get(0);
        list.set(0, 3);
        list.indexOf(5);
        list.lastIndexOf(5);
        list.subList(0, list.size()/2).clear();

        System.out.println(list);
        System.out.println(list1);
        System.out.println("-".repeat(16));

        list.removeAll(list1);
        list.retainAll(list1);
        list.removeIf(n -> n%2==0);

        list.sort((o1, o2) -> {
            if (list2.get(o1)%2==0) return 1;
            if (list2.get(o2)%2==0) return -1;
            return 0;
        });

        System.out.println(list);

        for (int j = 0; j < list.size(); j++) {
            System.out.print(list.get(j)+", ");
        }

        for (int j1 : list) {
            System.out.print(j1);
        }

        ListIterator<Integer> iterator = list.listIterator(list.size()/2);
        while (iterator.hasPrevious()){
            int i1 = iterator.previous();
            iterator.add(1);
            iterator.set(7);
            System.out.println(i1);
            iterator.remove();
            iterator.nextIndex();
        }

        list.forEach(n -> System.out.println(n));


        // Задачи:
        // Создать два целочисленных списка. Первый заполнить случайным числом, второй заполнить чётными элементами первого.
        ArrayList<Integer> list6 = new ArrayList<>();
        for (int l = 0; l < 10; l++) {
            list6.add(new Random().nextInt(10));
        }
        System.out.println(list6);

        ArrayList<Integer> list7 = new ArrayList<>(list6);
        list7.removeIf(n -> n % 2 == 1);
        System.out.println(list7);

        // Создать два списка, Один инт второй стринг. Заполнить первый случайным числом. Второй строковыми значениями первого.
        ArrayList<Integer> list3 = new ArrayList<>();
        ArrayList<String> list4 = new ArrayList<>();
        for (int l = 0; l < 10; l++) {
            list3.add(new Random().nextInt(10));
            list4.add(String.valueOf(list3.get(l)));
        }

        System.out.println(list3);
        System.out.println(list4);

        // Создать целочисленный список, найти средний по значению элемент.
        ArrayList<Integer> list5 = new ArrayList<>();
        for (int l = 0; l < 10; l++) {
            list5.add(new Random().nextInt(10));
        }

        System.out.println(list5);
        list5.sort(Comparator.naturalOrder());
        System.out.println(list5);
        System.out.println("Медианный метод: значение = " + list5.get(list5.size() / 2)); // Не всегда корректно

        Integer avg = (list5.get(0) + (list5.get(9))) / 2;
        System.out.println("Среднее арифметическое: " + avg);
        Integer nextMid = (list5.size() / 2) + 1;
        Integer prevMid = (list5.size() / 2) - 1;
        Integer distance1 = abs(nextMid - prevMid);
        Integer distance2 = abs(prevMid - nextMid);
        if (abs(distance1 - avg) > abs(distance2 - avg)) {
            System.out.println("Ближайшее среднее значение = " + list5.get(prevMid));
        } else if ((abs(distance1 - avg) == avg) && (abs(distance2 - avg) == avg)) {
            System.out.println("Ближайшее среднее значение = " + avg);
        } else {
            System.out.println("Ближайшее среднее значение = " + list5.get(nextMid));
        }
    }
}
