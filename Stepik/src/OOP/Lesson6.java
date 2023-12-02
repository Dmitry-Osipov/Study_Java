package OOP;

public class Lesson6 {
    public static void main(String[] args) {
        Dog dog1 = new Dog();
        Dog dog2 = new Dog("Бобик");
        dog1.run();
        dog2.run();
        System.out.println(Dog.Stat.counter);
    }
}

class Dog {
    private String name = "";
    private Foot foot = new Foot();
    private int id = 0;

    {
        Stat.counter++;
        id = ++Stat.id;
    }

    public Dog() {}

    public Dog(String name) {
        this.name = name;
    }

    public void run() {
        foot.run();
    }

    class Foot {
        private String name = "Foot";

         void run() {
            System.out.println("Собака " + Dog.this.name + " бежит...");  // Еси прописать просто name, то будет браться
             // name из Foot.
        }
    }

    static class Stat {
        public static int counter = 0;
        public static int id = 0;
    }
}
