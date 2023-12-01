package Lesson5.models;

import Lesson5.presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TableModel implements Model {
    private Collection<Table> tables;

    /**
     * Метод возвращает коллекцию столиков. Если коллекция пуста, автоматически создаёт 5 столиков.
     *
     * @return Список столов.
     */
    @Override
    public Collection<Table> loadTables() {
        if (tables == null) {
            tables = new ArrayList<>();
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }

        return tables;
    }

    /**
     * Метод резервации столика. Если номер столика есть в списке, резервация пройдёт, иначе ошибка.
     *
     * @param reservationDate дата резерва;
     * @param tableNumber     номер столика;
     * @param name            имя бронирующего.
     * @return id резерва.
     * @throws RuntimeException Был введён некорректный номер столика.
     */
    @Override
    public int reservationTable(Date reservationDate, int tableNumber, String name) {
        for (Table table : loadTables()) {
            if (table.getNumber() == tableNumber) {
                Reservation reservation = new Reservation(table, reservationDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        throw new RuntimeException("Некорректный номер столика.");
    }

    /**
     * Метод удаляет старую бронь и бронирует столик заново.
     *
     * @param oldReservation id старого резерва;
     * @param date           дата нового резерва;
     * @param tableNumber    номер нового столика;
     * @param name           имя бронирующего.
     */
    @Override
    public int changeReservationTable(int oldReservation, Date date, int tableNumber, String name) {
        for (Table table : loadTables()) {
            for (Reservation reservation : table.getReservations()) {
                if (reservation.getId() == oldReservation) {
                    System.out.println("Удаление старого резерва...");
                    System.out.println("Старый резерв успешно удалён.");
                }
                else throw new RuntimeException("Некорректный номер брони.");
            }
        }

        return reservationTable(date, tableNumber, name);
    }
}
