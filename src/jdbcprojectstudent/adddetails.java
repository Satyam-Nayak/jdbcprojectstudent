package jdbcprojectstudent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class adddetails {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Database connection details
            String url = "jdbc:mysql://localhost:3306/satyam";
            String username = "root";
            String password = "SatyamN.26.";

            // Establish the connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // SQL query for insertion
            String query = "INSERT INTO student (sname, number, sid, age) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Taking user input
            System.out.print("Enter Name: ");
            String sname = scanner.nextLine();

            System.out.print("Enter Number: ");
            int number = scanner.nextInt();

            System.out.print("Enter SID: ");
            int sid = scanner.nextInt();

            System.out.print("Enter Age: ");
            int age = scanner.nextInt();

            // Setting values in the query
            preparedStatement.setString(1, sname);
            preparedStatement.setInt(2, number);
            preparedStatement.setInt(3, sid);
            preparedStatement.setInt(4, age);

            // Execute the insertion
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Data inserted successfully!");
            }

            // Close the connection
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
