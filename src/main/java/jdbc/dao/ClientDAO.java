package jdbc.dao;


import org.jetbrains.annotations.NotNull;

import java.sql.*;

public class ClientDAO {
    //реализовать:
//    метод получения клиента по айди  //ResultSet
//    метод получения списка клиентов по фамилии/имени //ResultSet
//    метод изменения клиентских данных(фамилия, имя, возраст) //возвращать кол во апдейтнутых записей  (executeUpdate)
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //дефолтная загрузка класса

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String URL = "jdbc:mysql://192.168.236.120:3306/users";
            String USER = "root";
            String PASS = "root";
            Connection connection = DriverManager.getConnection(URL, USER, PASS);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //    метод получения клиента по айди  //ResultSet
    public static ResultSet getClient(String id, Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection
                .prepareStatement("SELECT * FROM CLIENTS WHERE ROW_ID = " + id);
        ResultSet rs = preparedStatement.executeQuery();
        preparedStatement.close();
        return rs;
    }

    //    метод получения списка клиентов по фамилии/имени //ResultSet
    public static ResultSet getClientListByName(String lastName,  Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection
                .prepareStatement("SELECT * FROM S_CONTACT WHERE LAST_NAME = " + lastName);
        ResultSet rs = preparedStatement.executeQuery();
        preparedStatement.close();
        return rs;
    }

    //        метод изменения клиентских данных(фамилия, имя, возраст) //возвращать кол во апдейтнутых записей  (executeUpdate)
    public static int updateClientsNameById(String Id, String lastName, String firstName, int age, Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        Integer executedQueryCount = statement
                .executeUpdate("update S_CONTACT set LAST_NAME='" + lastName + "', FIRST_NAME ='" + firstName +"', AGE ='"+ age +"' WHERE ROW_ID='" + Id + "'");
        statement.close();
        return executedQueryCount;
    }
}