package Lesson5.views;

import Lesson5.models.Table;
import Lesson5.presenters.View;
import Lesson5.presenters.ViewObserver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class BookingView implements View {
    private Collection<ViewObserver> observers = new ArrayList<>();


    /**
     * Метод выводит на экран все доступные для бронирования столики.
     * @param tables коллекция столиков.
     */
    @Override
    public void showTables(Collection<Table> tables) { for (Table table : tables) System.out.println(table); }

    /**
     * Добавление нового наблюдателя.
     * @param observer наблюдатель.
     */
    @Override
    public void registerObserver(ViewObserver observer) { observers.add(observer); }

    /**
     * Отображение результата бронирования.
     * @param reservationNumber номер резерва.
     */
    @Override
    public void showReservationTableResult(int reservationNumber) {
        if (reservationNumber > 0) System.out.printf("Столик успешно забронирован. Номер резерва: #%d\n", reservationNumber);
        else System.out.println("Произошла ошибка бронирования. Повторите операцию позже.");
    }

    /**
     * Метод бронирования столика.
     * @param date дата бронирования;
     * @param tableNumber номер столика;
     * @param name имя бронирующего.
     */
    public void reservationTable(Date date, int tableNumber, String name) {
        System.out.println("Происходит бронирование столика.");
        System.out.println("Происходит уведомление наблюдателей...");
        for (ViewObserver observer : observers) observer.onReservationTable(date, tableNumber, name);
    }

    /**
     * Метод изменения брони.
     * @param oldReservation id старого резерва;
     * @param date новая дата резерва;
     * @param tableNumber новый номер столика;
     * @param name имя бронирующего.
     */
    public void changeReservationTable(int oldReservation, Date date, int tableNumber, String name) {
        System.out.println("Происходит изменение бронирования столика.");
        System.out.println("Происходит уведомление наблюдателей...");
        for (ViewObserver observer : observers) observer.onChangeReservationTable(oldReservation, date, tableNumber, name);
    }
}
