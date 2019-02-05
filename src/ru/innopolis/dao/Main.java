package ru.innopolis.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5434/postgres";
        String username = "postgres";
        String password = "postgres";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            PersonController personController = new PersonController(connection);
            /*
            Person person = new Person();
            person.setName("Vlad");
            person.setBirthday(new Timestamp(System.currentTimeMillis()));
            personController.getAll().stream().forEach(System.out::println);
            System.out.println();
            */
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}