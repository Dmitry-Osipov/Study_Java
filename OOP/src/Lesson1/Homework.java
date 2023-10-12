package Lesson1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Homework {
    public static void main(String[] args) {
        // Создать наследника реализованного класса ГорячийНапиток с дополнительным полем int температура.
        // Создать класс ГорячихНапитковАвтомат реализующий интерфейс ТорговыйАвтомат и реализовать перегруженный метод
        // getProduct(int name, int volume, int temperature), выдающий продукт соответствующий имени, объёму и температуре.
        // В main проинициализировать несколько ГорячихНапитков и ГорячихНапитковАвтомат и воспроизвести логику,
        // заложенную в программе.
        // Всё вышеуказанное создать согласно принципам ООП, пройденным на семинаре.
        HotDrink hotDrink1 = new HotDrink("Горячий напиток #1", "ООО Просвящение",
                299.99, 0.5, 78);
        HotDrink hotDrink2 = new HotDrink(null, "ООО Просвящение", 399.99, 1, 80);
        HotDrink hotDrink3 = new HotDrink("Горячий напиток #3", null, 199.99, -3, 95);
        HotDrink hotDrink4 = new HotDrink(null, null, 1199.99, 3, 12);

        ArrayList<Product> products = new ArrayList<>();
        products.add(hotDrink1);
        products.add(hotDrink2);
        products.add(hotDrink3);
        products.add(hotDrink4);
        HotDrinksAutoMachine hotDrinksAutoMachine = new HotDrinksAutoMachine(products);

        System.out.println(products.size());
        hotDrinksAutoMachine.getProduct("Горячий напиток #3", 0.2, 95);
        hotDrinksAutoMachine.getProduct("<No Name>", 1.0);
        hotDrinksAutoMachine.getProduct("<No Name>", 60);
        hotDrinksAutoMachine.getProduct("Горячий напиток #1");
        System.out.println(products.size());
    }
}

class HotDrink extends BottleOfWater {
    protected int temperature;
    protected final int MINTEMPERATURE = 60;

    public HotDrink(String title, String manufacturer, double cost, double volume, int temperature) {
        super(title, manufacturer, cost, volume);
        checkTemperature(temperature);
    }

    public int getTemperature() { return temperature; }

    public void setTemperature(int temperature) { checkTemperature(temperature); }

    private void checkTemperature(int temperature) { this.temperature = Math.max(MINTEMPERATURE, temperature); }
}

class HotDrinksAutoMachine extends VendingMachine {
    public HotDrinksAutoMachine(List<Product> products) {
        super(products);
    }

    public HotDrink getProduct(String name, double volume, int temperature) {
        return getProductByCriteria(product ->
                product instanceof HotDrink hotDrink &&
                        hotDrink.title.equals(name) &&
                        hotDrink.volume == volume &&
                        hotDrink.temperature == temperature);
    }

    public HotDrink getProduct(String name, double volume) {
        return getProductByCriteria(product ->
                product instanceof HotDrink hotDrink &&
                        hotDrink.title.equals(name) &&
                        hotDrink.volume == volume);
    }

    public HotDrink getProduct(String name, int temperature) {
        return getProductByCriteria(product ->
                product instanceof HotDrink hotDrink &&
                        hotDrink.title.equals(name) &&
                        hotDrink.temperature == temperature);
    }

    public HotDrink getProduct(String name) {
        return getProductByCriteria(product ->
                product instanceof HotDrink hotDrink &&
                        hotDrink.title.equals(name));
    }

    private HotDrink getProductByCriteria(Predicate<Product> criteria) {
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if (criteria.test(product)) return (HotDrink) products.remove(i);
        }

        return null;
    }
}
