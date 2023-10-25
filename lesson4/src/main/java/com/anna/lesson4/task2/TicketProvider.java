package com.anna.lesson4.task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TicketProvider {

    private final Database database;
    private final PaymentProvider paymentProvider;


    public TicketProvider(Database database, PaymentProvider paymentProvider){
        this.database = database;
        this.paymentProvider = paymentProvider;
    }

   /**
     * Получить список билетов клиента на дату
     * @param clientId идентификатор клиента
     * @param date дата билета
     * @return список билетов
     * @throws RuntimeException Некорректный номер клиента/Нет билетов
     */
    public Collection<Ticket> searchTickets(int clientId, Date date) throws RuntimeException{
        // Предусловие
        if (clientId < 0)
        {
            throw new RuntimeException("Некорректный номер клиента");
        }

        // Выполнение подпрограммы
        Collection<Ticket> tickets = new ArrayList<>();
        for (Ticket ticket: database.getTickets()) {
            if (ticket.getCustomerId() == clientId && ticket.getDate().compareTo(date) == 0)
                tickets.add(ticket);
        }

        // Постусловие
        if (tickets.size() == 0) {
            throw new RuntimeException("Нет билетов");
        }
        return tickets;

    }

    public boolean buyTicket(int clientId, String cardNo){

        int orderId = database.createTicketOrder(clientId);
        double amount = database.getTicketAmount();
        return paymentProvider.buyTicket(orderId,  cardNo, amount);

    }

    public boolean checkTicket(String qrcode){
        for (Ticket ticket: database.getTickets()) {
            if (ticket.getQrcode().equals(qrcode) && ticket.isEnable()){
                ticket.setEnable(false);
                // Save database ...
                return true;
            }
        }
        return false;
    }


}
