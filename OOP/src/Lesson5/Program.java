package Lesson5;

import Lesson5.models.Table;
import Lesson5.models.TableModel;
import Lesson5.presenters.BookingPresenter;
import Lesson5.views.BookingView;

import java.util.Date;

public class Program {
    public static void main(String[] args) {
        TableModel model = new TableModel();
        BookingView view = new BookingView();
        BookingPresenter presenter = new BookingPresenter(model, view);
        // Обновляем номера столов, доступные для резерва.
        presenter.updateTablesUI();
        // Резервируем стол.
        view.reservationTable(new Date(), 3, "Дмитрий");
        // Меняем бронь.
        view.changeReservationTable(1001, new Date(), 1, "Дмитрий");
    }
}
