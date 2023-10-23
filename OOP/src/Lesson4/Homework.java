package Lesson4;

import java.util.ArrayList;

public class Homework {
    public static void main(String[] args) {
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        Apple apple4 = new Apple();
        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();
        Orange orange4 = new Orange();

        Box<Apple> appleBox1 = new Box<>();
        Box<Apple> appleBox2 = new Box<>();
        Box<Orange> orangeBox1 = new Box<>();
        Box<Orange> orangeBox2 = new Box<>();

        System.out.println(appleBox1.compare(appleBox2));
        System.out.println(appleBox1.compare(orangeBox1));

        appleBox2.add(apple1);
        // appleBox2.add(orange2); - дженерик не позволит отработать.

        appleBox2.add(apple2);
        appleBox2.add(apple3);
        appleBox2.add(apple4);
        orangeBox2.add(orange1);
        orangeBox2.add(orange2);
        orangeBox2.add(orange3);
        orangeBox2.add(orange4);

        System.out.println(appleBox1.getWeight() + " " + appleBox2.getWeight());
        appleBox2.pour(appleBox1, 2);
        System.out.println(appleBox1.getWeight() + " " + appleBox2.getWeight());
        appleBox2.pour(appleBox1, 5);
        // orangeBox2.pour(appleBox1); - аналогично прошлому дженерик не даст отработать.
    }
}

abstract class Fruit {
    private final float weight;

    public Fruit(float weight) { this.weight = weight; }

    public float getWeight() { return weight; }
}

class Orange extends Fruit {
    public Orange() { super(1.5f); }
}

class Apple extends Fruit {
    public Apple() { super(1.0f); }
}

class Box<T extends Fruit> {
    private ArrayList<T> fruits = new ArrayList<>();

    public float getWeight() {
        if (fruits.isEmpty()) return 0;
        return fruits.getFirst().getWeight() * fruits.size();
    }

    public boolean compare(Box box) { return getWeight() == box.getWeight(); }

    public void add(T fruit) { fruits.add(fruit); }

    public void pour(Box<T> toBox, int quantity) {
        if (fruits.size() < quantity) System.out.println("В этой коробке нет столько фруктов");
        else for (int i = 0; i < quantity; i++) toBox.add(fruits.removeLast());
    }
}
