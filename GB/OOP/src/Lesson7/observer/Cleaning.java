package Lesson7.observer;


public class Cleaning implements Observer {
    private String name;
    private int salary = 25000;

    public Cleaning(String name) {
        this.name = name;
    }

    @Override
    public void receiveOffer(String nameCompany, int salary) {
        if (this.salary <= salary){
            System.out.printf("Специалист \"%s\": Мне нужна эта работа! (компания: %s; заработная плата: %d)\n",
                    name, nameCompany, salary);
            this.salary = salary;
        }
        else {
            System.out.printf("Специалист \"%s\": Я найду работу получше! (компания: %s; заработная плата: %d)\n",
                    name, nameCompany, salary);
        }
    }

    @Override
    public String getName() {
        return name;
    }
}
