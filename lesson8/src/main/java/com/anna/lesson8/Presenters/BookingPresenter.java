package com.anna.lesson8.Presenters;

import com.anna.lesson8.Models.TableModel;
import com.anna.lesson8.Views.BookingView;
import com.anna.lesson8.Models.Table;

import java.util.Date;

public class BookingPresenter implements ViewObserver {

    private final Model model;
    private final View view;

    public BookingPresenter(Model model, View view) {
        this.model = model;
        this.view = view;
        this.view.registerObserver(this);
    }
    public void updateTables(){
        view.showTables(model.loadTables());
    }


    private void showReservationTableResult(int reservationNo){
        view.showReservationTableResult(reservationNo);
    }    
    
    private void showChangeReservationTableResult(int reservationNo){
        view.showChangeReservationTableResult(reservationNo);
    }

    @Override
    public void onReservationTable(Date reservtionDate, int tableNo, String name) {
        try {
            int reservationNo = model.reservationTable(reservtionDate, tableNo, name);
            showReservationTableResult(reservationNo);
        }
        catch (RuntimeException e){
            showReservationTableResult(-1);
        }
    }

    @Override
    public void onChangeReservationTable(int oldReservation, Date reservtionDate, int tableNo, String name) {
        try {
            int reservationNo = model.changeReservationTable(oldReservation, reservtionDate, tableNo, name);
            showChangeReservationTableResult(reservationNo);
        }
        catch (RuntimeException e){
            showChangeReservationTableResult(-1);
        }
    }

    public Table getTable(int tableNo) {
        try {
            return model.getTable(tableNo);       
        }
        catch (RuntimeException e){
            view.showException(e);
        }
        return null;
    }
}
