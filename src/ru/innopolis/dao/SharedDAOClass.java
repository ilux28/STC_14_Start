package ru.innopolis.dao;

import java.sql.*;

public class SharedDAOClass {
    private Connection connection;


    SharedDAOClass(Connection connection) {
        this.connection = connection;
    }


    protected boolean deleteByTwoId(int firstId, int secondId, PreparedStatement preparedStatement) {
        try {
            preparedStatement.setInt(1, firstId);
            preparedStatement.setInt(2, secondId);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    boolean deleteEntityById(int id, String deletePersonById) {
        try (PreparedStatement ps = this.getPrepareStatement(deletePersonById)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    PreparedStatement getPrepareStatement(String sql) {
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

    int getPreparedGenerateKey(PreparedStatement ps) throws SQLException {
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