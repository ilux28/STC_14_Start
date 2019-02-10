package ru.innopolis.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5434/postgres";
        String username = "postgres";
        String password = "postgres";
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            //PersonController personController = new PersonController(connection);
            //SubjectDAOClass subjectDAO = new SubjectDAOClass(connection);
            PersonDAOClass personDAOClass = new PersonDAOClass(connection);
            //System.out.println(subjectDAO.getSubjectById(2));

            //Person person = personDAOClass.getPersonById(1);
            //personDAOClass.addPersonInCourse(person);
            List<Person> personList = personDAOClass.getAllPerson();
            for (Person person : personList) {
                System.out.println(person);
                //personDAOClass.addPersonInCourse(person);
            }

            Map<Integer, Integer> courses = personDAOClass.getAllCourses();
            for (Map.Entry<Integer, Integer> item : courses.entrySet()) {
                System.out.println(item.getKey() + " " + item.getValue());
            }
            System.out.println("divide!");
            courses.forEach((k, v) -> System.out.println(k + " " + v));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}