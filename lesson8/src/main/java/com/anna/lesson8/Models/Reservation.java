package com.anna.lesson8.Models;

import java.util.Date;

public class Reservation {

    public Reservation(int tableNo, Date date, String name) {
        this.tableNo = tableNo;
        this.date = date;
        this.name = name;
    }

    private static int counter = 1000;
    private final int id;

    private final int tableNo;

    {
        id = ++counter;
    }
    private Date date;

    private String name;

    public Date getDate() {
        return date;
    }

    public String getName() {
        return name;
    }    
    
    public void setDate(Date date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }



    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Резерв #%d на %s, дата %s", id, name, date);
    }
}
