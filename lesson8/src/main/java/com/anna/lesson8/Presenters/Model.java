package com.anna.lesson8.Presenters;

import com.anna.lesson8.Models.Reservation;
import com.anna.lesson8.Models.Table;

import java.util.Collection;
import java.util.Date;

public interface Model {

    Collection<Table> loadTables();

    int reservationTable(Date reservationDate, int tableNo, String name);

    Reservation getReservation(int reservationNo);

    Table getTable(int tableNo);

    Reservation deleteReservation(int reservationNo);

    int addReservation(Reservation reservation, int tableNo);

    int changeReservationTable(int oldReservationNo, Date reservationDate, int tableNo, String name);
}
