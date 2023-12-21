package meeting;

import java.util.ArrayList;
import java.util.List;

public class Data {
    private static List<Person> persons = new ArrayList<>();

    static {
        Person person1 = new Person("Иван", "Петров", 12);
        Person person2 = new Person("Дмитрий", "Романов", 22);
        Person person3 = new Person("Николай", "Кегля", 100);
        Person person4 = new Person("Пётр", "Ян", 61);
        Person person5 = new Person("Митяй", "Филов", 49);
        Person person6 = new Person("Александр", "Гончаров", 85);
        Person person7 = new Person("Валерий", "Смутьянов", 64);
        Person person8 = new Person("Алексей", "Митрофанов", 44);
        Person person9 = new Person("Василий", "Березовский", 34);
        Person person10 = new Person("Дмитрий", "Колужский", 29);

        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);
        persons.add(person5);
        persons.add(person6);
        persons.add(person7);
        persons.add(person8);
        persons.add(person9);
        persons.add(person10);
    }

    public static List<Person> getPersons() { return persons; }
}
