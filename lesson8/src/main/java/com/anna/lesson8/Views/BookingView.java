package com.anna.lesson8.Views;

import com.anna.lesson8.Models.Reservation;
import com.anna.lesson8.Models.Table;
import com.anna.lesson8.Presenters.View;
import com.anna.lesson8.Presenters.ViewObserver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class BookingView implements View {

    private Collection<ViewObserver> observers = new ArrayList<>();

    @Override
    public void registerObserver(ViewObserver observer) {
        observers.add(observer);
    }

    @Override
    public void showTables(Collection<Table> tables) {
        for (Table table : tables){
            System.out.println(table);
        }
    }

    @Override
    public void showTableWithReservations(Table table){      
        System.out.println(table);
        for (Reservation reservation : table.getReservations()) {
            System.out.println("--" + reservation);
        }
    }

    @Override
    public void showReservationTableResult(int reservationNo) {
        if (reservationNo > 0)
            System.out.printf("Столик успешно забронирован. Номер резерва #%d\n", reservationNo);
        else
            System.out.println("Невозможно забронировать столик.\nПовторите попытку позже.");
    }

    @Override
    public void showChangeReservationTableResult(int reservationNo) {
        if (reservationNo > 0)
            System.out.printf("Резерв %d изменён.\n", reservationNo);
        else
            System.out.printf("Невозможно изменить резерв %d.\nПовторите попытку позже.", reservationNo);
    } 

    @Override
    public void showException(RuntimeException e){
        System.out.printf(e.getMessage);
    
    }

    public void reservationTable(Date reservtionDate, int tableNo, String name){
        for (ViewObserver observer : observers)
            observer.onReservationTable(reservtionDate, tableNo, name);
    }

    public void changeReservationTable(int oldReservation, Date reservtionDate, int tableNo, String name){
        for (ViewObserver observer : observers)
            observer.onChangeReservationTable(oldReservation, reservtionDate, tableNo, name);
    }

}
