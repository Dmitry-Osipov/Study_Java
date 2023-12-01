package Lesson5.models;

import java.util.Date;

public class Reservation {
    private static int counter = 1000;
    private final int id;
    private Date date;
    private String name;
    private final Table table;

    /**
     * Конструктор класса резерва столика.
     * @param table ссылка на столик;
     * @param date дата бронирования;
     * @param name имя бронирующего.
     */
    public Reservation(Table table, Date date, String name) {
        this.table = table;
        this.date = date;
        this.name = name;
        id = ++counter;
    }

    /**
     * Геттер для id резерва.
     * @return id резерва.
     */
    public int getId() { return id; }
}
