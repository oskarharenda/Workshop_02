package plCoderslabWorkshop2.utils;

import java.sql.*;

public class DBUtil {
    private static String DB_URL="jdbc:mysql://localhost:3306/workshop2?useSSL=false&characterEncoding=utf8";
    private static String DB_USER="root";
    private static String DB_PASS="coderslab";

    public static Connection Conetion() throws SQLException {//metoda która zwraca połączenie -
        return DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
    }

    //String query - polecenie do bazy danych!!!

    public static void insert(Connection conn, String query, String... params) {
        //Connection conn-jakie połaćzenie
        // polecenie do bazyy sql
        // String... params - zmienna liczba argumentów za
        try ( PreparedStatement statement = conn.prepareStatement(query)) {
            for (int i = 0; i < params.length; i++) {
                statement.setString(i + 1, params[i]);
            }
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void printData(Connection conn, String query, String... columnNames) throws SQLException {
        //metoda

        try (PreparedStatement statement = conn.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery();) {
            while (resultSet.next()) {
                for (String param : columnNames) {
                    System.out.println(resultSet.getString(param));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static final String DELETE_QUERY = "DELETE FROM tableName where id = ?";

    public static void remove(Connection conn, String tableName, int id) {
        try (PreparedStatement statement =
                     conn.prepareStatement(DELETE_QUERY.replace("tableName", tableName));) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
