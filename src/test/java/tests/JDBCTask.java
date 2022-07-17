package tests;
import java.sql.*;
import org.sqlite.JDBC;

public class JDBCTask {

    public static void main(String[] args){

        //1 вариант регистрации драйвера
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver"); //Для mysql
            Class.forName("org.sqlite.JDBC"); //Тестовая БД

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            //String URL = "jdbc:mysql://192.168.236.120:3306/users"; Для БД MySQL, с моего компа недоступна
            String URL = "jdbc:sqlite:C:/Users/smakarova/Downloads/WorkWithDB/myfin.db";
            String USER = "root";
            String PASS = "root";

            //Connection connection = DriverManager.getConnection(URL, USER, PASS); Для лабы
            Connection connection = DriverManager.getConnection(URL); //На своей тестовой бд

            System.out.println(getById(connection,"4"));
            System.out.println(getByStr(connection,"Хлеб"));
            System.out.println(updatePriceById(connection,"4", 300));
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //реализовать
//    метод получения по айди  //ResultSet
    public static String getById (Connection connection, String id) {
        StringBuilder sb = new StringBuilder();
        ResultSet rs;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM products WHERE id = ?");
            preparedStatement.setString(1, id);
            // Выполнение запроса
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                sb.append("id: ").append(rs.getInt("id")).append("; ")
                        .append("good: ").append(rs.getString("good")).append("; ")
                        .append("category_name: ").append(rs.getString("category_name")).append("; ")
                        .append("price: ").append(rs.getInt("price")).append("; ")
                        .append("\n");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
//    метод получения списка продуктов по названию //ResultSet
public static String getByStr (Connection connection, String name) {
    StringBuilder sb = new StringBuilder();
    ResultSet rs;
    try {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM products WHERE good = ?");
        preparedStatement.setString(1, name);
        // Выполнение запроса
        rs = preparedStatement.executeQuery();
        while (rs.next()){
            sb.append("id: ").append(rs.getInt("id")).append("; ")
                    .append("good: ").append(rs.getString("good")).append("; ")
                    .append("category_name: ").append(rs.getString("category_name")).append("; ")
                    .append("price: ").append(rs.getInt("price")).append("; ")
                    .append("\n");
        }
    }
    catch (SQLException e) {
        e.printStackTrace();
    }
    return sb.toString();
}
//    метод изменения клиентских данных(фамилия, имя, возраст) //возвращать кол во апдейтнутых записей  (executeUpdate)
public static int updatePriceById (Connection connection, String id, Integer price) {
    Savepoint currentSavepoint = null;
    int returnInt = 0;
    try {
        connection.setAutoCommit(false);
        currentSavepoint = connection.setSavepoint();
        PreparedStatement preparedStatement = connection.prepareStatement("Update products Set price = ? WHERE id = ?");
        preparedStatement.setInt(1, price);
        preparedStatement.setString(2, id);
        returnInt = preparedStatement.executeUpdate();
        connection.commit();
    }
    catch (SQLException e) {
        e.printStackTrace();
        try {
            connection.rollback(currentSavepoint);
        }
        catch (SQLException err)
        {
            e.printStackTrace();
        }
    }
    return returnInt;
}
}
