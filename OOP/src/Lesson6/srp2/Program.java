package Lesson6.srp2;

public class Program {
    public static void main(String[] args) {
        Order order = new Order();
        InputInfoOrder infoOrder = new InputInfoOrder(order);
        SaveToFile saver = new SaveToFile("order", order);
        infoOrder.inputFromConsole();
        saver.saveToJson();
    }
}
