package com.shesterikoff.babblo.persistent;

import java.sql.*;

    public class DAO {
        private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        private static final String DB_URL = "jdbc:mysql://localhost/bablo";
        private static final String USER = "nik";
        private static final String PASS = "SimplePassword";

        // Создаем новый connection и возвращаем его
        private static Connection getDBConnection() {
            Connection connection = null;

            try {
                Class.forName(JDBC_DRIVER);
                connection = DriverManager.getConnection(DB_URL, USER, PASS);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            return connection;
        }

        // Создание preparedStatement с помощью полученного в качестве аргумента SQL
        public static PreparedStatement createPreparedStatement(String SQL) {
            Connection connection = getDBConnection();
            PreparedStatement preparedStatement = null;

            try {
                preparedStatement = connection.prepareStatement(SQL);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return preparedStatement;
        }

        // Выполняет созданный SELECT в БД и возвращает ResultSet
        protected static ResultSet executePreparedStatement(PreparedStatement preparedStatement) {
            ResultSet resultSet = null;
            try {
                resultSet = preparedStatement.executeQuery();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return resultSet;
        }

        // Выполняет INSERT, UPDATE или DELETE и возвращает какое-то число.
        protected static int executePreparedUpdate(PreparedStatement preparedStatement) {
            int result = 0;

            try {
                result = preparedStatement.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return result;
        }
}
