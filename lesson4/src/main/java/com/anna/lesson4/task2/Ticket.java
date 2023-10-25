package com.anna.lesson4.task2;

import java.text.SimpleDateFormat;
import java.util.Date;

class Ticket{

    private int id;
    private static int counter;
    private int customerId;
    private Date date;
    private String qrcode;
    private boolean enable = true;
    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    {
        id = ++counter;
        
    }

    public Ticket(int customerId){
        this.qrcode = "QR-" + id;
        this.customerId = customerId;
        try {
        this.date = formatter.parse(formatter.format(new Date()));
        } 
        catch (java.text.ParseException e) {
        }
    }

    @Override
    public String toString(){
        return this.id + " "+ this.qrcode;
    }

    public int getId() {
        return id;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getQrcode() {
        return qrcode;
    }

    public int getCustomerId() {
        return customerId;
    }

    public Date getDate() {
        return date;
    }
}
