package com.anna.lesson4.task2;

import java.util.Collection;
import java.util.Date;

import com.anna.lesson4.task1.ComponentInfo;

public class MobileApp {
    private final Customer customer;
    private final TicketProvider ticketProvider;

    public MobileApp(TicketProvider ticketProvider, CustomerProvider customerProvider){
        this.ticketProvider = ticketProvider;

        customer = customerProvider.getCustomer("login", "password");
    }

    public Collection<Ticket> getTickets(){
        return customer.getTickets();
    }

    public void searchTickets(Date date){
        try{            
            System.out.println(ticketProvider.searchTickets(customer.getId(), date));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean buyTicket(String cardNo){
        return ticketProvider.buyTicket(customer.getId(), cardNo);
    }

}
