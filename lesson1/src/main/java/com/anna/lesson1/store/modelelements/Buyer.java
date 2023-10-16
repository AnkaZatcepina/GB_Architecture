package com.anna.lesson1.store.modelelements;

import java.util.Date;

public class Buyer {

    //region Инициализатор и конструкции

    {
        id = ++counter;
    }

    //endregion

    //region Свойства

    public int getId() {
        return id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    //endregion

    //region Поля
    private static int counter = 0;
    private int id;
    private String gender;
    private String name;
    private String lastName;
    private String patronymic;
    private Date birthday;

    //endregion

}

