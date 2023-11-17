package Lesson5.presenters;

import java.util.Date;

public interface ViewObserver {
    void onReservationTable(Date date, int tableNumber, String name);

    void onChangeReservationTable(int oldReservation, Date date, int tableNumber, String name);
}
