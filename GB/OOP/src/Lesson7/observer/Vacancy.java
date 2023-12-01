package Lesson7.observer;

public class Vacancy {
    private String name;
    private int salary;

    public Vacancy(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("Вакансия на позицию \"%s\", Оплата: %s", name, salary);
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }
}
