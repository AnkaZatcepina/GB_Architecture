package com.anna.lesson4.task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Customer {

    private static int counter;
    private final int id;

    private Collection<Ticket> tickets;

    {
        id = ++counter;
        tickets = new ArrayList<Ticket>();
    }

    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Collection<Ticket> tickets) {
        this.tickets = tickets;
    }

    public int getId() {
        return id;
    }

}
