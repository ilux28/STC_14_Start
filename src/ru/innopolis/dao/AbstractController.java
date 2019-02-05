package ru.innopolis.dao;

import org.postgresql.jdbc2.optional.ConnectionPool;

import java.sql.*;
import java.util.List;

public abstract class AbstractController<E, K> implements AutoCloseable {
    private Connection connection;


    protected AbstractController(Connection connection) {
        this.connection = connection;
    }

    public abstract List<E> getAll();

    public abstract E getEntityById(K id);

    public abstract E update(E entity);

    protected boolean delete(Integer id, PreparedStatement preparedStatement) {
        try {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public abstract int create(E entity);

    public PreparedStatement getPrepareStatement(String sql) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }

    PreparedStatement getPrepareStatementKey(String sql) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;

    }

    static int getPreparedGenerateKey(PreparedStatement ps) throws SQLException {
        ps.executeUpdate();
        ResultSet generatedKey = ps.getGeneratedKeys();
        if (generatedKey.next()) {
            return generatedKey.getInt(1);
        } else {
            return -1;
        }
    }

    void closePrepareStatement(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}