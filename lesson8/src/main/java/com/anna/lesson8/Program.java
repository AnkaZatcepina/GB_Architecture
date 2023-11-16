package com.anna.lesson8;

import com.anna.lesson8.Models.TableModel;
import com.anna.lesson8.Presenters.BookingPresenter;
import com.anna.lesson8.Presenters.Model;
import com.anna.lesson8.Views.BookingView;

import java.util.Date;

public class Program {

    //TODO: метод changeReservationTable должен заработать
    public static void main(String[] args) {
        Model model = new TableModel();
        BookingView view = new BookingView();
        BookingPresenter presenter = new BookingPresenter(model, view);
        presenter.updateTables();

        view.reservationTable(new Date(), 3, "Станислав");
        view.showTableWithReservations(presenter.getTable(3));
        view.changeReservationTable(1001, new Date(), 2, "Станислав");
        view.showTableWithReservations(presenter.getTable(3));
        view.showTableWithReservations(presenter.getTable(2));
    }

}
