package ru.innopolis.dao;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class SubjectController extends AbstractController<Subject, Integer> {

    private static final String GET_ALL_SUBJECTS = "SELECT * FROM SUBJECT";
    private static final String GET_SUBJECT_BY_ID = "SELECT * FROM SUBJECT as s where s.id = ?";
    private static final String UPDATE_SUBJECT_BY_ID = "update subject set description=? where id= ?";
    private static final String DELETE_SUBJECT_BY_ID = "delete from subject where id = ?";
    private static final String CREATE_SUBJECT = "insert into subject(description) values(?)";

    protected SubjectController(Connection connection) {
        super(connection);
    }

    @Override
    public List<Subject> getAll() {
        List<Subject> subjects = new LinkedList<>();
        PreparedStatement ps = getPrepareStatement(GET_ALL_SUBJECTS);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Subject subject = new Subject();
                subject.setId(rs.getInt(1));
                subject.setDescription(rs.getString(2));
                subjects.add(subject);
            }
            return subjects;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Subject getEntityById(Integer id) {
        PreparedStatement ps = getPrepareStatement(GET_SUBJECT_BY_ID);
        Subject subject = new Subject();
        try {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            subject.setId(rs.getInt(1));
            subject.setDescription(rs.getString(2));
            return subject;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Subject update(Subject subject) {
        try (PreparedStatement ps = getPrepareStatement(UPDATE_SUBJECT_BY_ID)) {
            ps.setInt(2, subject.getId());
            ps.setString(1, subject.getDescription());
            ps.executeUpdate();
            return subject;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean deleteSubject(Integer id) {
        try (PreparedStatement ps = getPrepareStatement(DELETE_SUBJECT_BY_ID)) {
            return super.delete(id, ps);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public int create(Subject subject) {
        try (PreparedStatement ps = getPrepareStatementKey(CREATE_SUBJECT)) {
            ps.setString(1, subject.getDescription());
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