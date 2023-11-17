package Lesson5.presenters;

import Lesson5.models.Table;

import java.util.Collection;
import java.util.Date;

public interface Model {
    Collection<Table> loadTables();

    int reservationTable(Date reservationDate, int tableNumber, String name);

    int changeReservationTable(int oldReservation, Date date, int tableNumber, String name);
}
