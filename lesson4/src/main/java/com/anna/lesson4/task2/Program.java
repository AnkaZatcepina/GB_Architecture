package com.anna.lesson4.task2;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

public class Program {

/**
 * Разработать контракты и компоненты системы "Покупка онлайн билетов на автобус в час пик".
 * <p>
 * 1.  Предусловия.
 * 2.  Постусловия.
 * 3.  Инвариант.
 * 4.  Определить абстрактные и конкретные классы.
 * 5.  Определить интерфейсы.
 * 6.  Реализовать наследование.
 * 7.  Выявить компоненты.
 * 8.  Разработать Диаграмму компонент использую нотацию UML 2.0. Общая без деталей.
 */
    public static void main(String[] args) {
        Core core = new Core();
        MobileApp mobileApp = new MobileApp(core.getTicketProvider(), core.getCustomerProvider());
        BusStation busStation = new BusStation(core.getTicketProvider());


        /*if (mobileApp.buyTicket("1000000000000099")){
            mobileApp.searchTicket(new Date());
        }*/
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date today = formatter.parse(formatter.format(new Date()));
            mobileApp.searchTickets(today);
        } 
        catch (java.text.ParseException e) {
        }


        Collection<Ticket> myTickets = mobileApp.getTickets();
        //System.out.println(myTickets);
        for (Ticket ticket : myTickets) {
            System.out.println(ticket.getQrcode());
        }

        if (busStation.checkTicket("QR-1")){
            System.out.println("Проходите");
        }
        else {
            System.out.println("Билет не действителен");
        }        
        if (busStation.checkTicket("QR-1")){
            System.out.println("Проходите");
        }
        else {
            System.out.println("Билет не действителен");
        }


        


    }

}
