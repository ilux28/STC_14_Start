package ru.innopolis.dao;

import java.io.Closeable;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class PersonController extends AbstractController<Person, Integer> {

    private static final String SELECT_ALL_PERSONS = "SELECT * FROM PERSON";
    private static final String GET_PERSON_BY_ID = "SELECT * FROM PERSON as p where p.id = ?";
    private static final String UPDATE_PERSON_BY_ID = "update person set name=?, birthday=? where id= ?";
    private static final String DELETE_PERSON_BY_ID = "delete from person where id = ?";
    private static final String CREATE_PERSON = "insert into person(name, birthday) values(?, ?)";


    protected PersonController(Connection connection) {
        super(connection);
    }

    @Override
    public List<Person> getAll() {
        List<Person> persons = new LinkedList<>();

        try (PreparedStatement ps = getPrepareStatement(SELECT_ALL_PERSONS)) {
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
    public Person getEntityById(Integer id) {

        Person person = new Person();
        try (PreparedStatement ps = getPrepareStatement(GET_PERSON_BY_ID)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            person.setId(rs.getInt(1));
            person.setName(rs.getString(2));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public Person update(Person person) {
        try (PreparedStatement ps = getPrepareStatement(UPDATE_PERSON_BY_ID)) {
            ps.setInt(3, person.getId());
            ps.setTimestamp(2, person.getBirthday());
            ps.setString(1, person.getName());
            ps.executeUpdate();
            return person;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean deletePerson(Integer id) {
        try (PreparedStatement ps = getPrepareStatement(DELETE_PERSON_BY_ID)) {
            return super.delete(id, ps);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public int create(Person entity) {
        try (PreparedStatement ps = getPrepareStatementKey(CREATE_PERSON)) {
            ps.setString(1, entity.getName());
            ps.setTimestamp(2, entity.getBirthday());
            return getPreparedGenerateKey(ps);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public void close() throws Exception {

    }
}