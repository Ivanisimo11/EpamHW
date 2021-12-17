package com.company.controller;

import com.company.Group;
import com.company.model.Person;
import com.company.view.PersonView;

import java.util.Scanner;

public class PersonController {
    static String surname;
    static String name;
    static String patronymic;
    static String nickname;
    static String comment;
    static Group group = null;
    static String telephoneNumberHome;
    static String telephoneNumber;
    static String eMail;
    static String skype;
    static String address;
    static String date;
    static Scanner scanner = new Scanner(System.in);
    private static PersonView personView = new PersonView();

    public static void main(String[] args) {
        notebookEntries();
    }

    private static Person addPersonInNotebook() {
        System.out.print("1)Фамилия: ");
        surname = scanner.nextLine();
        System.out.print("2)Имя: ");
        name = scanner.nextLine();
        System.out.print("3)Отчество: ");
        patronymic = scanner.nextLine();
        System.out.print("4)Никнейм: ");
        nickname = scanner.nextLine();
        System.out.print("5)Комментарий: ");
        comment = scanner.nextLine();
        System.out.print("6)Группа(HOME, JOB, FRIENDS, FAMILIAR): ");
        boolean b = true;
        while (b) {
            String temp = scanner.nextLine();
            b = false;
            switch (temp) {
                case "HOME" -> group = Group.HOME;
                case "JOB" -> group = Group.JOB;
                case "FRIENDS" -> group = Group.FRIENDS;
                case "FAMILIAR" -> group = Group.FAMILIAR;
                default -> b = true;
            }
        }
        System.out.print("7)Телефон(домашний): ");
        telephoneNumberHome = scanner.nextLine();
        System.out.print("8)Телефон(мобильный): ");
        telephoneNumber = scanner.nextLine();
        System.out.print("9)Е-майл: ");
        eMail = scanner.nextLine();
        System.out.print("10)Скайп: ");
        skype = scanner.nextLine();
        System.out.print("11)Адрес(город,улица,номер дома): ");
        address = scanner.nextLine();
        System.out.print("12)Дата: ");
        date = scanner.nextLine();

        return new Person(surname, name, patronymic, nickname, comment, group, telephoneNumberHome,
                telephoneNumber, eMail, skype, address, date);
    }

    private static void notebookEntries(){
        while (true) {
            System.out.println("Добавим человека в вашу записную книжку");
            personView.addInNotebook(addPersonInNotebook());
            System.out.println("Желаете добавить еще одного человека в вашу записную книжку?(1-да,0-нет)");
            String yesOrNo = scanner.nextLine();
            while (yesOrNo.charAt(0) > '1' || yesOrNo.charAt(0) < '0') {
                System.out.println("Пожалуйста введите 1 если да , 0 если нет");
                yesOrNo = scanner.nextLine();
            }
            if (yesOrNo.charAt(0) == '0') {
                break;
            }
        }
        System.out.println("Ваша записаня книжка сейчас віглядит вот так");
        personView.viewRecords();
        System.out.println("Желаете добавить еще одного человека в вашу записную книжку?(1-да,0-нет)");
        String yesOrNo = scanner.nextLine();
        while (yesOrNo.charAt(0) > '1' || yesOrNo.charAt(0) < '0') {
            System.out.println("Пожалуйста введите 1 если да , 0 если нет");
            yesOrNo = scanner.nextLine();
        }
        if (yesOrNo.charAt(0) == '1') {
            notebookEntries();
        }
    }
}
