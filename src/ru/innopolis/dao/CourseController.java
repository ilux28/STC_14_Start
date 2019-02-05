package ru.innopolis.dao;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CourseController extends AbstractController<Course, Integer> {

    private static final String GET_ALL_COURSES = "SELECT * FROM COURSE";
    private static final String GET_COURSE_BY_ID_PERSON = "SELECT * FROM COURSE as c where c.personid=?";
    private static final String GET_COURSE_BY_ID_SUBJECT = "SELECT * FROM COURSE as c where c.subjectid=?";
    private static final String UPDATE_COURSE_BY_ID_PERSON_ID_SUBJECT = "update course set name=? where personid=?, subjectid=?";
    private static final String DELETE_COURSE_BY_IDPERSON_ID_SUBJECT = "delete from course where personid=?, subjectid=?";
    private static final String CREATE_COURSE = "insert into course(name) values(?, ?)";

    protected CourseController(Connection connection) {
        super(connection);
    }

    @Override
    public List<Course> getAll() {
        List<Course> courses = new LinkedList<>();
        PreparedStatement ps = getPrepareStatement(GET_ALL_COURSES);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                courses.add(getSetOfCourses(rs));
            }
            return courses;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Course getSetOfCourses(ResultSet rs) throws SQLException {
        Course course = new Course();
        course.setPerson_id(rs.getInt(1));
        course.setSubject_id(rs.getInt(2));
        course.setName(rs.getString(3));
        return course;
    }

    private List<Course> getListCourses(Integer id, String sql) {
        List<Course> courses = new LinkedList<>();
        PreparedStatement ps = getPrepareStatement(sql);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                getSetOfCourses(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

    public List<Course> getListCoursesByIdPerson(Integer personId) {
        return getListCourses(personId, GET_COURSE_BY_ID_PERSON);
    }

    public List<Course> getListCoursesByIdSubject(Integer personId) {
        return getListCourses(personId, GET_COURSE_BY_ID_SUBJECT);
    }

    @Override
    public Course getEntityById(Integer id) {
        return null;
    }

    public boolean delete() {
        return false;
    }

    @Override
    public Course update(Course course) {

        try (PreparedStatement ps = getPrepareStatement(UPDATE_COURSE_BY_ID_PERSON_ID_SUBJECT)) {
            ps.setString(1, course.getName());
            ps.setInt(2, course.getPerson_id());
            ps.setInt(3, course.getSubject_id());
            ps.executeUpdate();
            return course;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean delete(Integer personId, Integer subjectId) {
        try (PreparedStatement ps = getPrepareStatement(DELETE_COURSE_BY_IDPERSON_ID_SUBJECT)) {
            ps.setInt(1, personId);
            ps.setInt(2, subjectId);
            ps.executeQuery();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public int create(Course course) {
        try (PreparedStatement ps = getPrepareStatementKey(CREATE_COURSE)) {
            ps.setInt(1, course.getPerson_id());
            ps.setInt(2, course.getSubject_id());
            ps.setString(3, course.getName());
            ps.executeQuery();
            return getPreparedGenerateKey(ps);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public void close() throws Exception {
    }
}