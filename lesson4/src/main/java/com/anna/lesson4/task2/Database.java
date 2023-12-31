package com.anna.lesson4.task2;

import java.util.ArrayList;
import java.util.Collection;

public class Database {

    private static int counter;

    public Database(){

        /**
         * Создать фейковую БД
         */

        for (int i = 0; i < 10; i++) {
            Customer customer = new Customer();
            for (int j = 0; j < 10; j++) {
                Ticket ticket = new Ticket(i); 
                tickets.add(ticket); 
                Collection <Ticket> customerTickets = customer.getTickets();
                customerTickets.add(ticket);    
                customer.setTickets(customerTickets);  
            }
            customers.add(customer);
        }

        /*
        Ticket ticket1 = new Ticket();
        Ticket ticket2 = new Ticket();


        tickets.add(ticket1);
        tickets.add(ticket2);

        Customer customer1 = new Customer();

        customer1.getTickets().add(ticket1);
        customer1.getTickets().add(ticket2);

        Customer customer2 = new Customer();
        Customer customer3 = new Customer();
        Customer customer4 = new Customer();
        Customer customer5 = new Customer();


        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
        customers.add(customer5); 
        */
    }

    private Collection<Ticket> tickets = new ArrayList<>();
    private Collection<Customer> customers = new ArrayList<>();

    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public Collection<Customer> getCustomers() {
        return customers;
    }

    /**
     * Получить актуальную стоимость билета
     * @return
     */
    public double getTicketAmount(){
        return 55;
    }

    /**
     * Получить идентификатор заявки на покупку билета
     * @return
     */
    public int createTicketOrder(int clientId){
        return ++counter;
    }

}
