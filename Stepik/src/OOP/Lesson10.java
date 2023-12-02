package OOP;

public class Lesson10 {
    public static void main(String[] args) {
        Car car = new ToyotaCorolla("Corolla");  // Можно указать обобщённую ссылку.
        car.go();
        car.stop();
        car.draw();

        final byte N = 2;
        Car[] cars = new Car[N];
        cars[0] = car;
        cars[1] = new ToyotaCamry("Camry");

        for (Car c : cars) {
            c.go();
            c.stop();
            c.draw();
            System.out.println(c.getModel());
        }
    }
}

abstract class Car {
    protected String model;

    public Car(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public abstract void go();
    public abstract void stop();
    public abstract void draw();
    public void setModel(String model) {
        this.model = model;
    }
}

class ToyotaCorolla extends Car {
    public ToyotaCorolla(String model) {
        super(model);
    }

    @Override
    public void go() {
        System.out.println("Toyota Corolla едет");
    }

    @Override
    public void stop() {
        System.out.println("Toyota Corolla остановилась");
    }

    @Override
    public void draw() {
        System.out.println("Рисуем Toyota Corolla...");
    }
}

class ToyotaCamry extends Car {
    public ToyotaCamry(String model) {
        super(model);
    }

    @Override
    public void go() {
        System.out.println("Toyota Camry едет");
    }

    @Override
    public void stop() {
        System.out.println("Toyota Camry остановилась");
    }

    @Override
    public void draw() {
        System.out.println("Рисуем Toyota Camry...");
    }
}
