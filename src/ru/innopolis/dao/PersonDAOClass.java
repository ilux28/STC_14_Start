package ru.innopolis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PersonDAOClass implements InterfacePersonDAO {

    private Connection connection;
    private SharedDAOClass sharedDAOClass;

    public PersonDAOClass(Connection connection) {
        this.connection = connection;
        sharedDAOClass = new SharedDAOClass(connection);
    }

    private static final String SELECT_ALL_PERSONS = "SELECT * FROM PERSON";
    private static final String GET_PERSON_BY_ID = "SELECT * FROM PERSON where id = ?";
    private static final String UPDATE_PERSON_BY_ID = "update person set name=?, birthday=? where id= ?";
    private static final String DELETE_PERSON_BY_ID = "delete from person where id = ?";
    private static final String CREATE_PERSON = "insert into person(name, birthday) values(?, ?)";
    private static final String ADD_PERSON_ON_COURSE_WITH_SUBJECT = "insert into course(personid, subjectid) values(?, ?)";
    private static final String GET_ALL_COURSES = "SELECT * FROM course";
    private static final String GET_ALL_COURSES_OF_PERSON = "SELECT * FROM course where personid=?";
    private static final String DELETE_SUBJECT_BY_PERSON = "delete from course where personid = ?, subjectid = ?";

    @Override
    public List<Person> getAllPerson() {
        List<Person> persons = new LinkedList<>();
        try (PreparedStatement ps = sharedDAOClass.getPrepareStatement(SELECT_ALL_PERSONS)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Person person = new Person();
                person.setId(rs.getInt(1));
                person.setName(rs.getString(2));
                person.setBirthday(rs.getTimestamp(3));
                persons.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persons;
    }

    @Override
    public Person getPersonById(int id) {
        Person person = new Person();
        try (PreparedStatement ps = sharedDAOClass.getPrepareStatement(GET_PERSON_BY_ID)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                person.setId(rs.getInt(1));
                person.setName(rs.getString(2));
                person.setBirthday(rs.getTimestamp(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public boolean updatePerson(Person person) {
        try (PreparedStatement ps = sharedDAOClass.getPrepareStatement(UPDATE_PERSON_BY_ID)) {
            ps.setInt(3, person.getId());
            ps.setTimestamp(2, person.getBirthday());
            ps.setString(1, person.getName());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public int createPerson(Person person) {
        try (PreparedStatement ps = sharedDAOClass.getPrepareStatementKey(CREATE_PERSON)) {
            ps.setString(1, person.getName());
            ps.setTimestamp(2, person.getBirthday());
            return sharedDAOClass.getPreparedGenerateKey(ps);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public boolean deletePersonById(int id) {
        return sharedDAOClass.deleteEntityById(id, DELETE_PERSON_BY_ID);
    }

    public boolean addPersonInCourseWithSubject(Person person, Subject subject) {
        try (PreparedStatement ps = sharedDAOClass.getPrepareStatementKey(ADD_PERSON_ON_COURSE_WITH_SUBJECT)) {
            ps.setInt(1, person.getId());
            ps.setInt(2, subject.getId());
            ps.executeQuery();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Map<Integer, Integer> getAllCourses() {
        Map<Integer, Integer> map = new HashMap<>();
        try (PreparedStatement ps = sharedDAOClass.getPrepareStatementKey(GET_ALL_COURSES)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                map.put(rs.getInt(1), rs.getInt(2));
            }
            return map;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Map<Integer, Integer> getAllCoursesByPerson(Person person) {
        Map<Integer, Integer> map = new HashMap<>();
        try (PreparedStatement ps = sharedDAOClass.getPrepareStatementKey(GET_ALL_COURSES_OF_PERSON)) {
            ps.setInt(1, person.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                map.put(rs.getInt(1), rs.getInt(2));
            }
            return map;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean deleteSubjectByPerson(Person person, Subject subject) {
        try (PreparedStatement ps = sharedDAOClass.getPrepareStatement(DELETE_SUBJECT_BY_PERSON)) {
            ps.setInt(person.getId(), subject.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}