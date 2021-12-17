package com.company.controller;

import com.company.Group;
import com.company.model.Person;
import com.company.view.PersonView;

import java.util.Scanner;
import java.util.regex.Pattern;

public class PersonController {
    static String surname;
    static String regexSurname = "^[A-Z][a-z]{1,20}$";
    static String name;
    static String regexName = "^[A-Z][a-z]{1,20}$";
    static String patronymic;
    static String regexPatronymic = "^[A-Z][a-z]{1,20}$";
    static String nickname;
    static String regexNickname = "^[A-Za-z1-9]{1,10}$";
    static String comment;
    static String regexComment = "^[A-Za-z1-9]{1,100}$";
    static Group group = null;
    static String telephoneNumberHome;
    static String regexTelephoneNumberHome = "^[+][1-9]{1,20}$";
    static String telephoneNumber;
    static String regexTelephoneNumber = "^[+][1-9]{1,20}$";
    static String eMail;
    static String regexEMail = "^[a-zA-Z0-9]{1,20}+@[a-z]{1,4}\\.[a-z]{1,4}$";
    static String skype;
    static String regexSkype = "^[a-zA-Z0-9]{1,20}+@[a-z]{1,4}\\.[a-z]{1,4}$";
    static String address;
    static String regexAddress = "^[a-zA-Z]{3,},[a-zA-Z]{3,},[1-9]{1,3}$";
    static String date;
    static String regexDate = "^[1-9]{2}.[1-9]{2}.[1-9]{4}$";
    static Scanner scanner = new Scanner(System.in);
    private static PersonView personView = new PersonView();

    public static void main(String[] args) {
        notebookEntries();
    }

    private static Person addPersonInNotebook() {
        System.out.print("1)Фамилия: ");
        surname = scanner.nextLine();
        while (!checkRegex(surname, regexSurname)) {
            System.out.println("Данные введены не коректно,попробуйте еще раз");
            surname = scanner.nextLine();
        }
        System.out.print("2)Имя: ");
        name = scanner.nextLine();
        while (!checkRegex(name, regexName)) {
            System.out.println("Данные введены не коректно,попробуйте еще раз");
            name = scanner.nextLine();
        }
        System.out.print("3)Отчество: ");
        patronymic = scanner.nextLine();
        while (!checkRegex(patronymic, regexPatronymic)) {
            System.out.println("Данные введены не коректно,попробуйте еще раз");
            patronymic = scanner.nextLine();
        }
        System.out.print("4)Никнейм: ");
        nickname = scanner.nextLine();
        while (!checkRegex(nickname, regexNickname)) {
            System.out.println("Данные введены не коректно,попробуйте еще раз");
            nickname = scanner.nextLine();
        }
        System.out.print("5)Комментарий: ");
        comment = scanner.nextLine();
        while (!checkRegex(comment, regexComment)) {
            System.out.println("Данные введены не коректно,попробуйте еще раз");
            comment = scanner.nextLine();
        }
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
        while (!checkRegex(telephoneNumberHome, regexTelephoneNumberHome)) {
            System.out.println("Данные введены не коректно,попробуйте еще раз");
            telephoneNumberHome = scanner.nextLine();
        }
        System.out.print("8)Телефон(мобильный): ");
        telephoneNumber = scanner.nextLine();
        while (!checkRegex(telephoneNumber,regexTelephoneNumber )) {
            System.out.println("Данные введены не коректно,попробуйте еще раз");
            telephoneNumber = scanner.nextLine();
        }
        System.out.print("9)Е-майл: ");
        eMail = scanner.nextLine();
        while (!checkRegex(eMail, regexEMail)) {
            System.out.println("Данные введены не коректно,попробуйте еще раз");
            eMail = scanner.nextLine();
        }
        System.out.print("10)Скайп: ");
        skype = scanner.nextLine();
        while (!checkRegex(skype, regexSkype)) {
            System.out.println("Данные введены не коректно,попробуйте еще раз");
            skype = scanner.nextLine();
        }
        System.out.print("11)Адрес(город,улица,номер дома): ");
        address = scanner.nextLine();
        while (!checkRegex(address, regexAddress)) {
            System.out.println("Данные введены не коректно,попробуйте еще раз");
            address = scanner.nextLine();
        }
        System.out.print("12)Дата: ");
        date = scanner.nextLine();
        while (!checkRegex(date, regexDate)) {
            System.out.println("Данные введены не коректно,попробуйте еще раз");
            date = scanner.nextLine();
        }

        return new Person(surname, name, patronymic, nickname, comment, group, telephoneNumberHome,
                telephoneNumber, eMail, skype, address, date);
    }

    private static boolean checkRegex(String s, String regex) {
        return Pattern.matches(regex, s);
    }

    private static void notebookEntries() {
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
