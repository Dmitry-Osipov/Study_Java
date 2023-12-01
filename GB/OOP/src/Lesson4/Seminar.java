package Lesson4;

import java.util.ArrayList;

public class Seminar {
    public static void main(String[] args) {
        ArrayList arrayList1 = new ArrayList();

        arrayList1.add(1);
        arrayList1.add("ABC");
        arrayList1.add(false);

        MyArrayList<Integer> myArrayList = new MyArrayList<>(new Integer[100]);
        myArrayList.add(2);
        myArrayList.add(10);
        myArrayList.add(5);
        System.out.println("Кол-во элементов в моей коллекции: " + myArrayList.size());

        Person person = new Person("FIO #1", "100002340");
        Entity entity = new Entity("NAME #1", "200001212");
        CreditAccount<Person> creditAccount = new CreditAccount<>(person, 30);
        DebitAccount<Entity> debitAccount = new DebitAccount<>(entity, 3000000);
        Transaction<Account> transaction = new Transaction<>(debitAccount, creditAccount, 2000);
        transaction.execute();
    }
}

class MyArrayList<T> {
    private T[] array;
    private int lastIndex = -1;

    public MyArrayList(T[] array) { this.array = array; }

    public void add(T item) { array[++lastIndex] = item; }

    public int size() { return lastIndex + 1; }

    public int capacity() { return array.length; }
}

interface PersonalData {
    public String getINN();
}

class Person implements PersonalData {
    private String fio;
    private String inn;

    public Person(String fio, String inn) {
        this.fio = fio;
        this.inn = inn;
    }

    public String getFio() { return fio; }

    @Override
    public String getINN() { return inn; }

    @Override
    public String toString() { return String.format("%s; %s.", fio, inn); }
}

class Entity implements PersonalData {
    private String name;
    private String inn;

    public Entity(String name, String inn) {
        this.name = name;
        this.inn = inn;
    }

    public String getName() { return name; }

    @Override
    public String getINN() { return inn; }

    @Override
    public String toString() { return String.format("%s; %s.", name, inn); }
}

abstract class Account<T extends PersonalData> {
    private T data;
    private double amount;

    public Account(T data, double amount) {
        this.data = data;
        this.amount = amount;
    }

    public void setAmount(double amount) { this.amount = amount; }

    public T getData() { return data; }

    public double getAmount() { return amount; }

    @Override
    public String toString() { return String.format("Клиент: %s\nБаланс на счёте: %s$", data, amount); }
}

class CreditAccount<T extends PersonalData> extends Account<T> {
    public CreditAccount(T data, double amount) { super(data, amount); }
}

class DebitAccount<T extends PersonalData> extends Account<T> {
    public DebitAccount(T data, double amount) { super(data, amount); }
}

class Transaction<T extends Account> {
    private final T from;
    private final T to;
    private final double amount;

    public Transaction(T from, T to, double amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public void execute() {
        if (from.getAmount() >= amount) {
            System.out.printf("Транзакция проведена успешно на сумму: %.2f $\n", amount);
            System.out.printf("Счёт списания: #%s; %.2f $ \nСчёт зачисления: %s\n",
                    from.getData(), from.getAmount(), to.getData());
            from.setAmount(from.getAmount() - amount);
            to.setAmount(to.getAmount() + amount);
        }
        else {
            System.out.println("Операция невозможна. Недостаточно средств на счёте.");
        }
    }
}
