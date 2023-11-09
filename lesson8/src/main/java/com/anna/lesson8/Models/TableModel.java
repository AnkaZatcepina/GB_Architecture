package com.anna.lesson8.Models;

import com.anna.lesson8.Presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TableModel implements Model {

    private Collection<Table> tables;

    @Override
    public Collection<Table> loadTables() {
        if (tables == null){
            tables = new ArrayList<>();
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }
        return tables;
    }

    @Override
    public int reservationTable(Date reservationDate, int tableNo, String name) {
        for (Table table : tables){
            if (table.getNo() == tableNo){
                Reservation reservation = new Reservation(tableNo, reservationDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        throw new RuntimeException("Некорректный номер столика");
    }

    @Override
    public Reservation getReservation(int reservationNo){
        for (Table table : tables){
            for (Reservation reservation: table.getReservations()){
                if (reservationNo == reservation.getId()) {
                    return reservation;                  
                } 
            }
        }
        throw new RuntimeException("Некорректный номер резерва");
    }

    @Override
    public Reservation deleteReservation(int reservationNo){
        for (Table table : tables){
            for (Reservation reservation: table.getReservations()){
                if (reservationNo == reservation.getId()) {
                    table.getReservations().remove(reservation);  
                    return reservation;              
                } 
            }
        }
        throw new RuntimeException("Некорректный номер резерва");
    }    
    
    @Override
    public int addReservation(Reservation reservation, int tableNo){
        for (Table table : tables){
            if (table.getNo() == tableNo){
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        throw new RuntimeException("Некорректный номер столика");
    }

    @Override
    public int changeReservationTable(int oldReservationNo, Date reservationDate, int tableNo, String name){
        try {
            Reservation reservation = deleteReservation(oldReservationNo);
            reservation.setDate(reservationDate);
            reservation.setName(name);
            return addReservation(reservation, tableNo);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Table getTable(int tableNo){
        for (Table table : tables){
            if (tableNo == table.getNo()) {
                    return table;                  
                } 
            }
        throw new RuntimeException("Некорректный номер столика");
    }
}
