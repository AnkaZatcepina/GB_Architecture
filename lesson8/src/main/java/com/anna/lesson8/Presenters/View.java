package com.anna.lesson8.Presenters;

import com.anna.lesson8.Models.Table;

import java.util.Collection;

public interface View {

    void registerObserver(ViewObserver observer);

    void showTables(Collection<Table> tables);

    void showReservationTableResult(int reservationNo);

}
