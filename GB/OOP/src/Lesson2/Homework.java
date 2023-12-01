package Lesson2;

import java.util.ArrayList;

import static java.lang.System.exit;

public class Homework {
    public static void main(String[] args) {
        Kitty kitty1 = new Kitty("Barsik", 5);
        Kitty kitty2 = new Kitty("Tuzik", 15);
        Kitty kitty3 = new Kitty("Manya", 25);
        Kitty kitty4 = new Kitty("Vaska", 3);
        Kitty kitty5 = new Kitty("Balu", 10);
        Kitty kitty6 = new Kitty("Ryzik", 11);
        Kitty kitty7 = new Kitty("Berry", 12);
        Kitty kitty8 = new Kitty("Cherry", 13);
        Kitty kitty9 = new Kitty("Fox", 12);
        Kitty kitty = new Kitty("Marta", 4);
        Plate plate = new Plate(100);

        ArrayList<Kitty> kitties = new ArrayList<>();
        kitties.add(kitty1);
        kitties.add(kitty2);
        kitties.add(kitty3);
        kitties.add(kitty4);
        kitties.add(kitty5);
        kitties.add(kitty6);
        kitties.add(kitty7);
        kitties.add(kitty8);
        kitties.add(kitty9);
        kitties.add(kitty);

        for (Kitty cat : kitties) cat.eat(plate);

        plate.info();
        plate.addFeed(20);
        plate.info();
    }
}

abstract class Checker {
    protected void checkInt(int value) {
        if (value < 0) {
            System.out.println("Невозможное значение для параметра");
            exit(-1);
        }
    }
}

class Kitty extends Checker {
    private String name;
    private int appetite;
    private boolean satiety = false;

     public Kitty(String name, int appetite) {
         this.name = name;
         setAppetite(appetite);
     }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getAppetite() { return appetite; }

    public void setAppetite(int appetite) {
         checkInt(appetite);
         this.appetite = appetite;
    }

    public boolean isSatiety() { return satiety; }

    public void eat(Plate plate) {
         if (satiety) {
             System.out.println(name + " не хочет есть");
             return;
         }

         if (plate.getFood() - appetite < 0) {
             System.out.println("Досыпьте еду в миску для котика " + name);
             return;
         }

         plate.setFood(plate.getFood() - appetite);
         satiety = true;
         System.out.println("Котик " + name + " покушал =)");
    }
}

class Plate extends Checker {
    private int food;

    public Plate(int food) {
        checkInt(food);
        this.food = food;
    }

    public int getFood() { return food; }

    public void setFood(int food) {
        checkInt(food);
        this.food = food;
    }

    public void info() { System.out.println("plate: " + food); }

    public void addFeed(int food) { setFood(this.food + food); }
}
