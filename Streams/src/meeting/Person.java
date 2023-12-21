package meeting;

public class Person implements Comparable<Person> {
    private String surname;
    private String name;
    private int age;

    public Person(String name, String surname, int age) {
        this.surname = surname;
        this.name = name;
        this.age = age;
    }

    public String getSurname() { return surname; }

    public void setSurname(String surname) { this.surname = surname; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }

    public void setAge(byte age) { this.age = age; }

    @Override
    public String toString() {
        return "Person{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Person o) { return name.compareTo(o.getName()); }
}
