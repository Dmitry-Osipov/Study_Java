package Lesson5.presenters;

import java.util.Date;

public class BookingPresenter implements ViewObserver {
    private final Model model;
    private final View view;

    /**
     * Инициализатор класса презентера бронирования столика.
     * @param model игрушечная база данных столика.
     * @param view представление для пользователя.
     */
    public BookingPresenter(Model model, View view) {
        this.model = model;
        this.view = view;
        this.view.registerObserver(this);
    }

    /**
     * Метод обновляет список столиков в рамках UI.
     */
    public void updateTablesUI() { view.showTables(model.loadTables()); }

    /**
     * Метод отвечает за реакцию наблюдателя на резерв столика.
     * @param date дата резерва;
     * @param tableNumber номер столика;
     * @param name имя бронирующего.
     */
    @Override
    public void onReservationTable(Date date, int tableNumber, String name) {
        System.out.println("Презентер зафиксировал попытку бронирование столика.");

        int reservationNumber;
        try {
            reservationNumber = model.reservationTable(date, tableNumber, name);
        }
        catch (RuntimeException e) {
            reservationNumber = -1;
        }

        view.showReservationTableResult(reservationNumber);
    }

    /**
     * Метод отвечает за реакцию наблюдателя на изменение резерва столика.
     * @param oldReservation id старого столика;
     * @param date новая дата резерва;
     * @param tableNumber новый номер столика;
     * @param name имя бронирующего.
     */
    @Override
    public void onChangeReservationTable(int oldReservation, Date date, int tableNumber, String name) {
        System.out.println("Презентер зафиксировал попытку изменения брони.");

        int newReservationNumber;
        try {
            newReservationNumber = model.changeReservationTable(oldReservation, date, tableNumber, name);
        }
        catch (RuntimeException e) {
            System.out.println(e);
            newReservationNumber = -1;
        }

        view.showReservationTableResult(newReservationNumber);
    }
}
