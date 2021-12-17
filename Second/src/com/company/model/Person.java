package com.company.model;

import com.company.Group;

public class Person {
    private final String surname;
    private final String name;
    private final String patronymic;
    private final String nickname;
    private final String comment;
    private final Group group;
    private final String telephoneNumberHome;
    private final String telephoneNumber;
    private final String eMail;
    private final String skype;
    private final String address;
    private final String date;

    public Person(String surname, String name, String patronymic, String nickname, String comment, Group group,
                  String telephoneNumberHome, String telephoneNumber, String eMail, String skype, String address, String date) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.nickname = nickname;
        this.comment = comment;
        this.group = group;
        this.telephoneNumberHome = telephoneNumberHome;
        this.telephoneNumber = telephoneNumber;
        this.eMail = eMail;
        this.skype = skype;
        this.address = address;
        this.date = date;
    }

    @Override
    public String toString() {
        return  surname + ' ' +  name.charAt(0) + '.' + '\n' +
                "Никнейм: " + nickname + '\n' +
                "Комментарий: " + comment + '\n' +
                "Группа: " + group + '\n' +
                "Телефон(домашний): " + telephoneNumberHome + '\n' +
                "Телефон(мобильный): " + telephoneNumber + '\n' +
                "Е-майл: " + eMail +'\n' +
                "Скайп: " + skype + '\n' +
                "Адрес: " + address + '\n' +
                "Дата записи: " + date + '\n';
    }
}

