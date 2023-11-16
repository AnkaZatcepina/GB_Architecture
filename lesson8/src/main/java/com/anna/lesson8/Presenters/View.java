package com.anna.lesson8.Presenters;

import com.anna.lesson8.Models.Table;

import java.util.Collection;

public interface View {

    void registerObserver(ViewObserver observer);

    void showTables(Collection<Table> tables);
    void showTableWithReservations(Table table);

    void showReservationTableResult(int reservationNo);

    void showChangeReservationTableResult(int reservationNo);

    void showGetTableResult(int tableNo);

    void showException(RuntimeException e);

}
