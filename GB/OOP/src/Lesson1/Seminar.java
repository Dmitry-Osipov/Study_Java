package Lesson1;

import java.util.ArrayList;
import java.util.List;

public class Seminar {
    public static void main(String[] args) {
        Product product1 = new Product("Продукт #1", "Производитель #1", 199.99);
        System.out.println(product1.getCost());
        product1.setCost(249.99);
        System.out.println(product1.displayInfo());

        BottleOfWater bottleOfWater1 = new BottleOfWater("Бутылка #1", "OOO Источник",
                499.99, 0.5);
        BottleOfWater bottleOfWater2 = new BottleOfWater("Бутылка #2", "OOO Источник",
                799.99, 1);
        System.out.println(bottleOfWater1.displayInfo());

        ArrayList<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(bottleOfWater1);
        products.add(bottleOfWater2);
        VendingMachine vendingMachine = new VendingMachine(products);
        System.out.println(vendingMachine.getBottleOfWater("Бутылка #1", 0.5));
        System.out.println(vendingMachine.getBottleOfWater("Бутылка #3", 1));
    }
}

class Product {
    protected String title;
    protected String manufacturer;
    protected double cost;
    protected double defaultCost = 100;

    public Product(String title, String manufacturer, Double cost) {
        checkTitle(title);
        checkManufacturer(manufacturer);
        checkCost(cost);
    }

    public void setTitle(String title) {
        checkTitle(title);
    }

    public String getTitle() {
        return title;
    }

    public void setManufacturer(String manufacturer) {
        checkManufacturer(manufacturer);
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setCost(Double cost) {
        checkCost(cost);
    }

    public double getCost() {
        return cost;
    }

    public void setDefaultCost(double defaultCost) {
        if (defaultCost <= this.defaultCost) System.out.println("Ошибка");
        else this.defaultCost = defaultCost;
    }

    public double getDefaultCost() {
        return defaultCost;
    }

    private void checkTitle(String title) {
        if (title == null || title.length() < 3) this.title = "<No Name>";
        else this.title = title;
    }

    private void checkManufacturer(String manufacturer) {
        if (manufacturer == null || manufacturer.length() < 3) this.manufacturer = "<No Brand>";
        else this.manufacturer = manufacturer;
    }

    private void checkCost(double cost) { this.cost = Math.max(cost, defaultCost); }

    public String displayInfo() {
        return String.format("Название: %s, \nПроизводитель: %s, \nСтоимость: %s", title, manufacturer, cost);
    }
}

class BottleOfWater extends Product {
    protected double volume;

    public BottleOfWater(String title, String manufacturer, double cost, double volume) {
        super(title, manufacturer, cost);
        checkVolume(volume);
    }

    @Override
    public String displayInfo() {
        return super.displayInfo() + String.format("\nОбъём: %s", volume);
    }

    private void checkVolume(double volume) {
        if (volume <= 0) this.volume = 0.2;
        else this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        checkVolume(volume);
    }
}

class VendingMachine {
    protected List<Product> products;

    public VendingMachine(List<Product> products) {
        this.products = products;
    }

    public BottleOfWater getBottleOfWater(String title, double volume) {
        for (Product item : products) {
            if (item instanceof BottleOfWater bottleOfWater) {
                if (bottleOfWater.getTitle().equals(title) && bottleOfWater.getVolume() == volume) return bottleOfWater;
            }
        }

        return null;
    }
}
