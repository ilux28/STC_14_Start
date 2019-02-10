package ru.innopolis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class SubjectDAOClass implements InterfaceSubjectDAO {

    private Connection connection;
    private SharedDAOClass sharedDAOClass;

    private static final String GET_ALL_SUBJECTS = "SELECT * FROM SUBJECT";
    private static final String GET_SUBJECT_BY_ID = "SELECT * FROM SUBJECT where id = ?";
    private static final String UPDATE_SUBJECT_BY_ID = "update subject set description=? where id= ?";
    private static final String DELETE_SUBJECT_BY_ID = "delete from subject where id = ?";
    private static final String CREATE_SUBJECT = "insert into subject(description) values(?)";
    private static final String ADD_SUBJECT_IN_COURSE_BY_PERSON = "insert into course(personid, subjectid) values(?, ?)";

    SubjectDAOClass(Connection connection) {
        this.connection = connection;
        sharedDAOClass = new SharedDAOClass(this.connection);
    }


    @Override
    public List<Subject> getAllSubjects() {
        List<Subject> subjects = new LinkedList<>();
        try (PreparedStatement ps = sharedDAOClass.getPrepareStatement(GET_ALL_SUBJECTS)) {
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
    public Subject getSubjectById(int id) {
        Subject subject = new Subject();
        try (PreparedStatement ps = sharedDAOClass.getPrepareStatement(GET_SUBJECT_BY_ID)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                subject.setId(rs.getInt(1));
                subject.setDescription(rs.getString(2));
            }
            return subject;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean updateSubject(Subject subject) {
        try (PreparedStatement ps = sharedDAOClass.getPrepareStatement(UPDATE_SUBJECT_BY_ID)) {
            ps.setInt(2, subject.getId());
            ps.setString(1, subject.getDescription());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public int createSubject(String description) {
        try (PreparedStatement ps = sharedDAOClass.getPrepareStatementKey(CREATE_SUBJECT)) {
            ps.setString(1, description);
            return sharedDAOClass.getPreparedGenerateKey(ps);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public boolean deleteSubjectById(int id) {
        return sharedDAOClass.deleteEntityById(id, DELETE_SUBJECT_BY_ID);
    }
}