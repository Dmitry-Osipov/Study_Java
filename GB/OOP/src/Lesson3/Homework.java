package Lesson3;

import java.util.*;

public class Homework {
    public static void main(String[] args) {
        MySalaryEmployee mySalaryEmployee = new MySalaryEmployee(null, "Владислав", 5000, 202);
        System.out.println(mySalaryEmployee);

        MyFreelancer myFreelancer = new MyFreelancer("Сидоров", "Дмитрий", 500, 202);
        System.out.println(myFreelancer);

        MyEmployee myEmployee = MyEmployeeFabric.generateEmployee();
        System.out.println(myEmployee);

        System.out.println("-------------");
        MyEmployee[] workers = MyEmployeeFabric.generateManyEmployees(20);

        Arrays.sort(workers);
        for (MyEmployee worker : workers) System.out.println(worker);

        System.out.println("-------------");
        Arrays.sort(workers, new MySalaryComparator());
        for (MyEmployee worker : workers) System.out.println(worker);
    }
}

abstract class MyEmployee implements Comparable<MyEmployee> {
    protected String surname;
    protected String name;
    protected double rate;
    protected Integer employeeCode = 0;
    protected static Set<Integer> employeeCodes = new HashSet<>();
    private static Random random = new Random();

    public MyEmployee(String surname, String name, double rate, Integer employeeCode) {
        setSurname(surname);
        setName(name);
        setRate(rate);

        if (employeeCode <= 0 || employeeCodes.contains(employeeCode)) this.employeeCode = random.nextInt(1, 1000000000);
        else this.employeeCode = employeeCode;

        employeeCodes.add(employeeCode);
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (Objects.equals(surname, "") || surname == null) {
            this.surname = "Фамилия";
        }
        else this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (Objects.equals(name, "") || name == null) this.name = "Имя";
        else this.name = name;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        if (rate <= 0) this.rate = 300;
        else this.rate = rate;
    }

    public Integer getEmployeeCode() {
        return employeeCode;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return String.format("Код: %s,\nФамилия: %s,\nИмя: %s,\nСтавка: %.2f руб.,\nЗарплата в месяц: %.2f руб.\n",
                employeeCode, surname, name, rate, calculateSalary());
    }

    @Override
    public int compareTo(MyEmployee o) {
        return employeeCode.compareTo(o.employeeCode);
    }
}

class MySalaryEmployee extends MyEmployee {
    private final double MROT = 16242.00;

    public MySalaryEmployee(String surname, String name, double rate, Integer employeeCode) {
        super(surname, name, rate, employeeCode);
    }

    public double getMROT() {
        return MROT;
    }

    @Override
    public double calculateSalary() {
        return Math.max(rate, MROT);
    }

    @Override
    public String toString() {
        return String.format("Сотрудник в штате:\nКод: %s, \nФамилия: %s;\nИмя: %s;\nЗарплата в месяц: %.2f руб.\n",
                employeeCode, surname, name, calculateSalary());
    }

}

class MyFreelancer extends MyEmployee {

    public MyFreelancer(String surname, String name, double rate, Integer employeeCode) {
        super(surname, name, rate, employeeCode);
    }

    @Override
    public double calculateSalary() {
        return 20.8 * 8 * rate;
    }

    @Override
    public String toString() {
        return "Подрядчик:\n" + super.toString();
    }
}

abstract class MyEmployeeFabric {
    private static Random random = new Random();

    public static MyEmployee generateEmployee() {
        String[] names = new String[] {"Анатолий", "Виктор", "Дмитрий", "Антон", "Глеб", "Игорь", "Владислав"};
        String[] surnames = new String[] {"Осипов", "Афонин", "Наземнов", "Григорьев", "Астафьев", "Шестаков",
                "Сидоров"};

        int rate = random.nextInt(0, 500000);
        int employeeCode = random.nextInt(1, 1000000000);

        if (rate % 2 == 0) return new MySalaryEmployee(
                surnames[random.nextInt(surnames.length)],
                names[random.nextInt(names.length)], rate, employeeCode);

        return new MyFreelancer(
                surnames[random.nextInt(surnames.length)],
                names[random.nextInt(names.length)], rate, employeeCode);
    }

    public static MyEmployee[] generateManyEmployees(int quantity) {
        MyEmployee[] workers = new MyEmployee[quantity];
        for (int i = 0; i < quantity; i++) {
            workers[i] = generateEmployee();
        }

        return workers;
    }
}

class MySalaryComparator implements Comparator<MyEmployee> {
    @Override
    public int compare(MyEmployee o1, MyEmployee o2) {
        return Double.compare(o2.calculateSalary(), o1.calculateSalary());
    }
}
