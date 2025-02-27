package org.prog.sql;

//TODO: usual Homework: Create table Addresses, where you write
// Person's Name, LastName, City Name, Street Name, Address

//TODO: usual homework + : re-write this test using BeforeSuite and AfterSuite

//TODO: Homework * : Create table Phones : PhoneId, PhoneName, PhonePrice
// - using selenium go to allo.ua, search for a phone
// - get phone name
// - get phone price
// - store phone name and phone price to DB

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchPhones {
    private static final String URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String USER = "root";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        String selectSQL = "SELECT * FROM Phones;";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(selectSQL)) {

            while (rs.next()) {
                int id = rs.getInt("PhoneId");
                String name = rs.getString("PhoneName");
                double price = rs.getDouble("PhonePrice");

                System.out.println("ID: " + id + ", Name: " + name + ", Price: $" + price);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
