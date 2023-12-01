package Lesson5.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

public class Table {
    private static int counter;
    private final int number;
    private final Collection<Reservation> reservations = new ArrayList<>();

    /**
     * Конструктор класса столика. Номер столика - автоинкремент от статического поля счётчика.
     */
    public Table() { number = ++counter; }

    /**
     * Геттер номера столика.
     * @return номер столика.
     */
    public int getNumber() { return number; }

    /**
     * Геттер номера резерва.
     * @return номер резерва.
     */
    public Collection<Reservation> getReservations() { return reservations; }

    @Override
    public String toString() { return String.format(Locale.getDefault(), "Столик #%d", number); }
}
