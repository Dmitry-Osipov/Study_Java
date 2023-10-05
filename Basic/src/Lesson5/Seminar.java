package Lesson5;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Seminar {
    public static void main(String[] args) {
        // Код преподавателя:
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        HashMap<Integer, String> hashMap = new HashMap<>();

        hashMap.put(5, "Пять");
        hashMap.putIfAbsent(5, "Пять");
        hashMap.replace(5, "Пять");
        hashMap.put(5, "Три");
        hashMap.replace(5, "Три", "Пять");
        String str = hashMap.get(5);
        hashMap.getOrDefault(5, "Ничего");
        if (hashMap.containsValue("Пять")) {}
        if (hashMap.containsKey(5)) {}
        hashMap.remove(5);
        hashMap.remove(5, "Три");

        for (int i = 0; i < 10; i++) {
            hashMap.put(i, Character.getName(i));
        }

        hashMap.compute(10, (k, v) -> v == null ? v = "10" : v + "11");
        hashMap.computeIfPresent(10, (k, v) -> v == null ? v = "10" : v + "11");
        hashMap.computeIfAbsent(10, v -> "9");

        Set<Map.Entry<Integer, String>> a = hashMap.entrySet();
        Iterator<Map.Entry<Integer, String>> iterator = a.iterator();
        while (iterator.hasNext()){}

        Set<Integer> k = hashMap.keySet();
        Collection<String> v = hashMap.values();

        AtomicInteger integer = new AtomicInteger(11);
        hashMap.merge(integer.get(), "11", (o, n) -> {
            if (o == null) {
                System.out.println("Оштибка");
                System.exit(-1);
            }
            o = o+n+String.valueOf(integer.get());
            return o;
        });

        System.out.println(hashMap);

        hashMap.forEach( (k1, v1) -> System.out.println(k1+" = "+v1));

        // Мой код:
        // Дана строка. Необходимо написать метод, который отсортирует слова в строке по длине с помощью TreeMap. Строки
        // с одинаковой длиной не должны “потеряться”.
        String str1 = "В начале октября владельцы гаджетов Xiaomi из России и Белоруссии начали жаловаться на проблемы в работе устройств";
        String[] allStr = str1.split(" ");
        TreeMap<String, Integer> treeMap1 = new TreeMap<>( (k1, v1) ->  {
            if (k1.length() != v1.length()) return k1.length() - v1.length();
            return k1.compareTo(v1);
        } );
        for (String s : allStr) treeMap1.put(s, s.length());
        treeMap1.forEach( (k1, v1) -> System.out.println(k1 + " = " + v1) );

        // Создать мапу, ключ - случайная строка из Char getName а значение - индекс первой буквы ключа. Сделать так,
        // чтобы значений было 10. Вывести пары (ключ/значение) отсортированные по значению.
        HashMap<String, Integer> hashMap1 = new HashMap<>();
        while (hashMap1.size() < 10) {
            String newStr = Character.getName(new Random().nextInt(50));
            hashMap1.put(newStr, (int) newStr.charAt(0));
        }
        System.out.println("---------");
        System.out.println(hashMap1.toString().replace(",", "\n"));

        System.out.println("---------");
        hashMap1.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
//                .limit(5)  // Выводит первые 5 элементов
                .forEach(k1 -> System.out.println(k1.getKey() + " = " + k1.getValue()));
    }
}
