package ATM;

import java.sql.*;

public class ATMSystem {
    private static final String URL = "jdbc:mysql://localhost:3306/atm";
    private static final String USER = "root";
    private static final String PASSWORD = "miras123";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            // Display all accounts
            System.out.println("List of accounts:");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM account");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") +
                        ", Account Number: " + resultSet.getString("account_number") +
                        ", Balance: " + resultSet.getDouble("balance"));
            }

            // Add a new account
            String insertQuery = "INSERT INTO account (account_number, pin_code, balance, bank_id) VALUES ('555666', '3333', 1200.00, 1)";
            int rowsInserted = statement.executeUpdate(insertQuery);
            if (rowsInserted > 0) {
                System.out.println("New account added successfully.");
            }

            // Update account balance
            String updateQuery = "UPDATE account SET balance = balance - 200 WHERE account_number = '555666'";
            int rowsUpdated = statement.executeUpdate(updateQuery);
            if (rowsUpdated > 0) {
                System.out.println("Account balance updated successfully.");
            }

            // Delete an account
            String deleteQuery = "DELETE FROM account WHERE account_number = '555666'";
            int rowsDeleted = statement.executeUpdate(deleteQuery);
            if (rowsDeleted > 0) {
                System.out.println("Account deleted successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}