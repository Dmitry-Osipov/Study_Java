package Lesson7.observer;

public class Student implements Observer {

    private String name;

    public Student(String name) {
        this.name = name;
    }

    private int salary = 2000;

    @Override
    public void receiveOffer(String nameCompany, int salary) {
        if (this.salary <= salary){
            System.out.printf("Студент \"%s\": Мне нужна эта работа! (компания: %s; заработная плата: %d)\n",
                    name, nameCompany, salary);
            this.salary = salary;
        }
        else {
            System.out.printf("Студент \"%s\": Я найду работу получше! (компания: %s; заработная плата: %d)\n",
                    name, nameCompany, salary);
        }
    }

    @Override
    public String getName() {
        return name;
    }
}
