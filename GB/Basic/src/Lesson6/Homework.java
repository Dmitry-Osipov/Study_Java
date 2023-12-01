package Lesson6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Homework {
    // Задание:
    // Реализуйте структуру телефонной книги с помощью HashMap. Программа также должна учитывать, что во входной
    // структуре будут повторяющиеся имена с разными телефонами, их необходимо считать, как одного человека с разными
    // телефонами. Вывод должен быть отсортирован по убыванию числа телефонов.
    public static void main(String[] args) {
        PhoneBook myBook = new PhoneBook();
        myBook.put("Irina", 8989);
        myBook.put("Irina", 8989);
        myBook.put("Irina", 8990);
        System.out.println(myBook.find("Artem"));
        System.out.println(myBook.find("Irina"));
        myBook.put("Mikhail", 1909);
        myBook.put("Mikhail", 1444);
        myBook.put("Mikhail", 4545);
        myBook.put("Mikhail", 9995);
        myBook.put("Ivan", 8909);
        myBook.put("Ivan", 1212);
        myBook.put("Ivan", 1312);
        myBook.getPhoneBook();
    }
}

class PhoneBook {
    private HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();

    public void put(String name, Integer phoneNum) {
        ArrayList<Integer> phones = new ArrayList<>();

        if (phoneBook.containsKey(name)) phones.addAll(phoneBook.get(name));
        if (!phones.contains(phoneNum)) phones.add(phoneNum);

        if (!phoneBook.containsKey(name)) phoneBook.put(name, phones);
        else phoneBook.replace(name, phones);
    }

    public ArrayList<Integer> find(String name) {
        if (!phoneBook.containsKey(name)) return new ArrayList<Integer>();
        return phoneBook.get(name);
    }

    public void getPhoneBook() {
        List<Map.Entry<String, ArrayList<Integer>>> entries = new ArrayList<>(phoneBook.entrySet());
        entries.sort((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));

        phoneBook.clear();
        for (Map.Entry<String, ArrayList<Integer>> entry : entries) phoneBook.put(entry.getKey(), entry.getValue());

        System.out.println(entries);
    }
}
