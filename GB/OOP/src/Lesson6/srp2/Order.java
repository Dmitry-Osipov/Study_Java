package Lesson6.srp2;

public class Order {
    private String clientName;
    private String product;
    private int count;
    private int price;

    public Order() {}

    public Order(String clientName, String product, int count, int price) {
        this.clientName = clientName;
        this.product = product;
        this.count = count;
        this.price = price;
    }

    public String getClientName() { return clientName; }

    public void setClientName(String clientName) { this.clientName = clientName; }

    public String getProduct() { return product; }

    public void setProduct(String product) { this.product = product; }

    public int getCount() { return count; }

    public void setCount(int count) { this.count = count; }

    public int getPrice() { return price; }

    public void setPrice(int price) { this.price = price; }

    @Override
    public String toString() {
        return String.format("Заказ на имя %s, продукт - %s, количеством %d шт., стоимость - %d", clientName, product, count, price);
    }
}
