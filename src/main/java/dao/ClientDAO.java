package dao;

import java.sql.*;

public class ClientDAO {

    private static String USER = "jdbc:mysql://localhost:3306/users";
    private static String LOGIN = "root";
    private static String PASS = "root";
    private static final String driverClassName = "com.mysql.cj.jdbc.Driver";

    static {
        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //    метод получения клиента по айди
    public static ResultSet printClientId(Integer id) throws SQLException {
        Connection connection = DriverManager.getConnection(USER, LOGIN, PASS);
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Client WHERE ID= ? ");
        preparedStatement.setInt(1, id);
        ResultSet result = preparedStatement.executeQuery();
        preparedStatement.close();
        return result;
    }

    //    метод получения списка клиентов по фамилии
    public static ResultSet printClientName(String lastName) throws SQLException {
        Connection connection = DriverManager.getConnection(USER, LOGIN, PASS);
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Client WHERE lastName= ? ");
        preparedStatement.setString(1, lastName);
        ResultSet result = preparedStatement.executeQuery();
        preparedStatement.close();
        return result;
    }

    //    метод изменения клиентских данных(фамилия, имя, возраст)
    public static Integer updateClient(Integer id, String firstName, String lastName, Integer age) {
        Connection connection = null;
        Statement statement = null;
        Savepoint currentSavepoint = null;
        Integer resultInt = null;

        try {
            connection = DriverManager.getConnection(USER, LOGIN, PASS);
            statement = connection.createStatement();
            resultInt = statement.executeUpdate("Update Client set firstName='" + firstName + "', lastName='"
                    + lastName + "', age='" + age +"' where id='" + id);
            connection.setAutoCommit(false);
            currentSavepoint = connection.setSavepoint();
            connection.commit();
            statement.close();

        } catch (SQLException e) {
            try {
                connection.rollback(currentSavepoint);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException | NullPointerException throwables) {
                throwables.printStackTrace();
            } finally {
                return resultInt;
            }
        }
    }
}

