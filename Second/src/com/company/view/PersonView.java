package com.company.view;

import com.company.model.Person;

import java.util.ArrayList;

public class PersonView {
    private ArrayList<Person> notebook = new ArrayList<>();

    public void addInNotebook(Person person){
        notebook.add(person);
    }

    public void viewRecords(){
        for (Person person : notebook) {
            System.out.println(person);
            System.out.println("_______________________________________________________________");
        }
    }
}
