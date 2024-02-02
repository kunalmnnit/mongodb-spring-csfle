package com.mongodb.quickstart.javaspringbootcsfle.model;

import java.util.List;

public class PersonEntityWrapper {
    private List<PersonEntity> persons;

    public PersonEntityWrapper() {
    }

    public PersonEntityWrapper(List<PersonEntity> persons) {
        this.persons = persons;
    }

    public List<PersonEntity> getPersons() {
        return persons;
    }

    public void setPersons(List<PersonEntity> persons) {
        this.persons = persons;
    }
}
