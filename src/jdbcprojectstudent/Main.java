package jdbcprojectstudent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/satyam";
            String username = "root";
            String password = "SatyamN.26.";

            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM student");

            System.out.printf("%-10s %-20s %-10s %-5s\n", "SID", "Name", "Number", "Age");
            System.out.println("---------------------------------------------");

            while (resultSet.next()) {
                System.out.printf("%-10d %-20s %-10d %-5d\n", 
                    resultSet.getInt("sid"), 
                    resultSet.getString("sname"), 
                    resultSet.getInt("number"), 
                    resultSet.getInt("age"));
            }

            connection.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
