package Lesson3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Seminar {
    public static void main(String[] args) {
        Animal[] animals = {
                new Cat("Рыжик", 3000),
                new Dog("Бобик", 1000, 0),
                new Cat("Персик", 2000),
                new Dog("Борис", 2500, 50),
                new Dog("Бима", 400, 300),
        };

        for (Animal a : animals) {
            a.run(200);
            a.swim(10);
            a.run(1200);
            a.swim(210);
            a.run(3200);
            a.swim(230);
            a.run(2200);
            a.swim(150);
        }

        System.out.println();
        System.out.printf("Было создано %d животных\n", Animal.getCounter());  // Вместо Animal можно прописать и Cat,
        // и Dog, но счётчик будет от класса Animal (пока не переопределён счётчик в дочерних классах).
        // Переопределяем счётчик:
        System.out.printf("Было создано %d собак\n", Dog.getCounter());
        System.out.printf("Было создано %d котов\n", Cat.getCounter());
        System.out.println();

        Worker worker = new Worker("Фамилия", "Имя", 300);
        System.out.println(worker);

        Worker worker1 = EmpoyeeFabric.generateWorker();
        System.out.println(worker1);

        System.out.println("---------");
        Worker[] workers = EmpoyeeFabric.generateManyWorkers(15);
        Arrays.sort(workers); //, new SalaryComparator()); Если заранее задать сортировку в классе работников, то
        // не надо будет содавать свой компаратор другим классов. Либо компаратор может сортировать по зп (на данный
        // момент по фамилии и имени).
        for (Worker stateMan : workers) System.out.println(stateMan);
    }
}

abstract class Animal {
    protected String name;
    protected int maxRun;
    protected int maxSwim;
    private static int counter;

    public Animal(String name, int maxRun, int maxSwim) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxSwim = maxSwim;
        counter++;
    }

    public void run(int distance) {
        if (distance > maxRun) {
            System.out.printf("%s не удалось пробежать %d метров\n", name, distance);
        }
        else {
            System.out.printf("%s пробежал %d метров\n", name, distance);
        }
    }

    public void swim(int distance) {
        if (distance > maxSwim) {
            System.out.printf("%s не удалось проплыть %d метров\n", name, distance);
        }
        else {
            System.out.printf("%s проплыл %d метров\n", name, distance);
        }
    }

    public static int getCounter() {
        return counter;
    }

    public String getName() {
        return name;
    }

    public int getMaxRun() {
        return maxRun;
    }

    public int getMaxSwim() {
        return maxSwim;
    }
}

class Cat extends Animal {
    private static int counter;

    public Cat(String name, int maxRun) {
        super(name, maxRun, 0);
        counter++;
    }

    public static int getCounter() {
        return counter;
    }

    @Override
    public void swim(int distance) {
        System.out.printf("%s не умеет плавать!\n", name);
    }
}

class Dog extends Animal {
    private static int counter;

    public Dog(String name, int maxRun, int maxSwim) {
        super(name, maxRun, maxSwim);
        counter++;
    }

    public static int getCounter() {
        return counter;
    }
}

// ---------------------------------------------------------------------------------------------------------------------

abstract class Employee implements Comparable<Employee> {
    protected String name;
    protected String surname;
    protected double salary;

    public Employee(String surname, String name, double salary) {
        this.surname = surname;
        this.name = name;
        this.salary = salary;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return String.format("Фамилия: %s,\nИмя: %s,\nСтавка: %.2f руб.,\nЗарплата в месяц: %.2f руб.\n",
                surname, name, salary, calculateSalary());
    }
}

class Worker extends Employee {

    public Worker(String surname, String name, double salary) {
        super(surname, name, salary);
    }

    @Override
    public double calculateSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("Рабочий в штате.\nФамилия: %s,\nИмя: %s,\nЗарплата в месяц: %.2f руб.\n",
                surname, name, calculateSalary());
    }

    @Override
    public int compareTo(Employee o) {
        int surnameRes = surname.compareTo(o.surname);

        if (surnameRes == 0) return name.compareTo(o.name);

        return surnameRes;
    }
}

class Freelancer extends Employee {

    public Freelancer(String surname, String name, double salary) {
        super(surname, name, salary);
    }

    // TODO: Доработать рассчёт зп в рамках домашней работы.
    @Override
    public double calculateSalary() {
        return 0;
    }

    @Override
    public int compareTo(Employee o) {
        int surnameRes = surname.compareTo(o.surname);

        if (surnameRes == 0) return name.compareTo(o.name);

        return surnameRes;
    }
}

class EmpoyeeFabric {
    private static Random random = new Random();

    public  static Worker generateWorker() {
        String[] names = new String[] {"Анатолий", "Виктор", "Дмитрий", "Антон", "Глеб", "Игорь", "Владислав"};
        String[] surnames = new String[] {"Осипов", "Афонин", "Наземнов", "Григорьев", "Астафьев", "Шестаков",
                "Сидоров"};

        int salary = random.nextInt(60000, 120001);
        return new Worker(surnames[random.nextInt(surnames.length)], names[random.nextInt(names.length)], salary);
    }

    // TODO: Домашней работой переделать метод на такой, чтобы он генерировал случайных рабочих разных типов.
    public static Worker[] generateManyWorkers(int count) {
        Worker[] workers = new Worker[count];
        for (int i = 0; i < count; i++) {
            workers[i] = generateWorker();
        }

        return workers;
    }
}

class SalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        /* Создаём свой компаратор:
        if (o1.calculateSalary() > o2.calculateSalary()) return 1;
        else if (o1.calculateSalary() == o2.calculateSalary()) return 0;
        return -1;
        */

        // Встроенный компаратор:
        return Double.compare(o2.calculateSalary(), o1.calculateSalary());
    }
}
