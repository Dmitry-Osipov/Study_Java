package Lesson6.srp2;

import java.io.FileWriter;
import java.io.IOException;

public class SaveToFile {
    private String fileName;
    private final Order order;

    public SaveToFile(String fileName, Order order) {
        this.fileName = fileName;
        this.order = order;
    }

    public String getFileName() { return fileName; }

    public void setFileName(String fileName) { this.fileName = fileName; }

    public Order getOrder() { return order; }

    public void saveToJson() {
        try (FileWriter writer = new FileWriter(fileName + ".json", false)) {
            writer.write("{\n");
            writer.write("\"clientName\":\"" + order.getClientName() + "\",\n");
            writer.write("\"product\":\"" + order.getProduct() + "\",\n");
            writer.write("\"count\":" + order.getCount() + ",\n");
            writer.write("\"price\":" + order.getPrice() + "\n");
            writer.write("}\n");
            writer.flush();
        } catch (IOException ex) { System.out.println(ex.getMessage()); }
    }
}
