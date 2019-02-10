package ru.innopolis.dao;

import java.util.List;

public interface InterfacePersonDAO {
    List<Person> getAllPerson();

    Person getPersonById(int id);

    boolean updatePerson(Person person);

    int createPerson(Person person);

    boolean deletePersonById(int id);
}