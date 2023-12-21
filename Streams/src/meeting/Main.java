package meeting;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = Data.getPersons();
        List<Person> persons2 = persons.stream()
                .filter(person -> person.getAge() > 30)  // Конвеерный метод, возвращает другой stream.
                .sorted()  // Person должен имплементировать интерфейс Comparable.
                .collect(Collectors.toList());  // Терминальный метод, возвращает другой объект.
        persons2.forEach(System.out::println);  // Даём ссылку на метод класса.

        System.out.println();

        List<Person> persons3 = persons.stream()
                .map(person -> new Person(person.getName(), person.getSurname(), person.getAge() + 100))  // Для
                // каждого объекта создаём новый объект, у которого возраст больше на 100 лет.
                .toList();
        for (Person person : persons3) System.out.println(person);

        System.out.println();

        Optional<Person> personal = persons.stream()
                .filter(person -> person.getAge() > 30)
                .findFirst();
        System.out.println(personal.get());

        System.out.println();

        long count = persons.stream()
                .filter(person -> person.getAge() > 30)
                .count();
        System.out.println(count);
    }
}
