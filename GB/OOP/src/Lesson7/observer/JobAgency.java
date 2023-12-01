package Lesson7.observer;

import java.util.ArrayList;
import java.util.Collection;

public class JobAgency implements Publisher {

    private Collection<Observer> observers = new ArrayList<>();


    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void sendOffer(String companyName, int salary, Vacancy vacancy) {
        for (Observer observer : observers){
            if (observer.getName() == vacancy.getName()) observer.receiveOffer(companyName, salary);
        }
    }
}
