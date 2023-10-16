package com.anna.lesson1.store.inmemorymodel;

import java.util.Collection;
import java.util.HashSet;

import com.anna.lesson1.store.modelelements.Order;

public class Store {

    private Collection<Order> orders = new HashSet<Order>();

    public boolean addOrder(Order order){
        orders.add(order);
        return true;
    }

    public boolean cancelOrder(int id){
        //TODO: Отмена заказа
        return true;
    }

    public boolean paymentOrder(int id)
    {
        //TODO: Оплата заказа
        return true;
    }

}

