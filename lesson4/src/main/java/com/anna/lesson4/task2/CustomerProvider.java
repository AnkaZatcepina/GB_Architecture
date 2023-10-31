package com.anna.lesson4.task2;
import java.util.concurrent.ThreadLocalRandom;

public class CustomerProvider {

    private final Database database;

    public CustomerProvider(Database database){
        this.database = database;
    }

    public Customer getCustomer(String login, String password){
        //return new Customer();
        int randomNum = ThreadLocalRandom.current().nextInt(0, 10);
        return database.getCustomers().stream().skip(randomNum).findFirst().get();
    }


}
