package Lesson3;

import java.io.IOException;

public class Seminar {
    public static void main(String[] args) {
        try {
            doSomething();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try (Counter counter = new Counter()) {
            counter.add();
            counter.add();
            counter.add();
            System.out.println(counter.getCount());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Напишите метод, который прокидывает исключение. Обработайте его в мэине.
    public static void doSomething() throws Exception {
        throw new Exception("Do not doSomething");
    }
}

// Напишите класс, который имеет счётчик. Счётчик должен быть закрыт по методу close.
class Counter implements AutoCloseable{
    private Integer count = 0;

    public Integer getCount() { return count; }

    public void add() throws IOException {
        checkClose();
        count++;
    }

    private void checkClose() throws IOException { if (count == null) throw new IOException("Экземпляр закрыт"); }

    @Override
    public void close() {
        System.out.println("Экземпляр класса закрыт методом");
        count = null;
    }
}
