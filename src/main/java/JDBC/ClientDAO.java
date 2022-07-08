package JDBC;

import java.sql.*;

public class ClientDAO {

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
//            Statement statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //Метод получения клиента по ID
    public ResultSet getClientById(String Id, Connection connection) throws SQLException {
        PreparedStatement getClientByIdStatement = connection
                .prepareStatement("SELECT * FROM S_CONTACT WHERE ROW_ID= ? ");
        getClientByIdStatement.setString(1, Id);
        ResultSet rs = getClientByIdStatement.executeQuery();
        rs.close();
        return rs;
    }

    //Метод получения списка клиентов по имени
    public static ResultSet getClientsByName(String Name, Connection connection) throws SQLException {
        PreparedStatement getClientsByNameStatement = connection
                .prepareStatement("SELECT * FROM S_CONTACT WHERE FIRST_NAME='" + Name + "'");
        ResultSet rs = getClientsByNameStatement.executeQuery();
        rs.close();
        return rs;
    }

    //Метод изменения клиентских данных - имя
    public static int updateClientsNameById(String Id, String newName, Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        Integer executedQueryCount = statement
                .executeUpdate("update S_CONTACT set FIRST_NAME='" + newName + "'" + " where ROW_ID='" + Id + "'");
        statement.close();
        return executedQueryCount;
    }
}

