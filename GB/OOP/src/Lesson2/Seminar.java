package Lesson2;

import java.util.ArrayList;

public class Seminar {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Рыжий");
        cat1.setName("Персик");
        cat1.voice();

        Dog dog1 = new Dog(12);
        dog1.setName("Бобик");
        dog1.voice();

        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(cat1);  // Не требуется преобразование типов, ибо оно происходит автоматически и безопасно.
        animals.add(dog1);
        Animal.voices(animals);

        ArrayList<Runnable> animals1 = new ArrayList<>();
        animals1.add(cat1);
        animals1.add(dog1);
        Animal.runners(animals1);
    }
}

abstract class Animal {  // Благодаря модификатору abstract мы не можем создать экземпляр этого класса. А также мы можем
    // добавить модификатор abstract к различным методам.
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void voice(); /*{
        System.out.println("Животное падаёт голос");
    }*/

    public void jump() {  // Даже если не переопределить этот метод в дочерних классах, программа всё равно отработает
        // при вызове этой функции в дочерних классах.
        System.out.println("Животное прыгает");
    }

    static void voices(ArrayList<Animal> animals) {
        for (Animal animal : animals) {
            if (animal instanceof Cat) {  // Проверка на соответствие типов. Если преобразовать Dog к Cat, то получим
                // ошибку, ибо 1 - ошибка преобразования, 2 - ошибка атрибута (у собаки нет цвета).
                Cat cat = (Cat) animal;
                System.out.println("Цвет котика: " + cat.getColor());
            }

            if (animal instanceof Dog dog) {  // А это усовершенствованная версия проверки.
                System.out.println("Вес собаки: " + dog.getWeight());
            }

            animal.voice();
        }
    }
    
    static void runners(ArrayList<Runnable> animals) {  // Благодаря апкасту через интерфейс мы избегаем ошибок и проверок.
        for (Runnable animal : animals) animal.run();
    }

    @Override
    public String toString() {
        return name;
    }
}

interface Runnable {  // Абсолютно каждый метод интерфейса не имеет конкретной реализации. Её нужно добавить
    // самостоятельно в дочерних классах.
    void run();
}

class Dog extends Animal implements Runnable {
    private double weight;

    public Dog(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public void voice() {  // Т.к. Этот метод абстрактный у материнского класса, то мы должны реализовать его в дочерних.
        System.out.println("Гав");
    }

    @Override
    public void jump() {
        System.out.println("Собака прыгает");
    }

    @Override
    public void run() {
        System.out.println(getName() + " бежит");
    }
}

class Cat extends Animal implements Runnable {
    private String color;

    public Cat(String color) {
            this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void voice() {
        System.out.println("Мяу");
    }

    @Override
    public void jump() {
        System.out.println("Кошка прыгает");
    }

    @Override
    public void run() {
        System.out.println(getName() + " бежит");
    }
}
