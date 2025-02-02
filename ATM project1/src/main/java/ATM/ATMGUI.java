package ATM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ATMGUI extends JFrame {
    private static final String URL = "jdbc:mysql://localhost:3306/atm";
    private static final String USER = "root";
    private static final String PASSWORD = "miras123";

    private JTextArea displayArea;
    private JTextField accountField, pinField, balanceField, bankField;

    public ATMGUI() {
        setTitle("ATM System");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Display Area
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        add(scrollPane, BorderLayout.CENTER);

        // Panel for input fields
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 5, 5));
        inputPanel.add(new JLabel("Account Number:"));
        accountField = new JTextField();
        inputPanel.add(accountField);

        inputPanel.add(new JLabel("PIN Code:"));
        pinField = new JTextField();
        inputPanel.add(pinField);

        inputPanel.add(new JLabel("Balance:"));
        balanceField = new JTextField();
        inputPanel.add(balanceField);

        inputPanel.add(new JLabel("Bank ID:"));
        bankField = new JTextField();
        inputPanel.add(bankField);

        add(inputPanel, BorderLayout.NORTH);

        // Buttons for actions
        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 5, 5));
        JButton viewBtn = new JButton("View Accounts");
        JButton addBtn = new JButton("Add Account");
        JButton updateBtn = new JButton("Update Balance");
        JButton deleteBtn = new JButton("Delete Account");

        buttonPanel.add(viewBtn);
        buttonPanel.add(addBtn);
        buttonPanel.add(updateBtn);
        buttonPanel.add(deleteBtn);

        add(buttonPanel, BorderLayout.SOUTH);

        // Action Listeners
        viewBtn.addActionListener(e -> displayAccounts());
        addBtn.addActionListener(e -> addAccount());
        updateBtn.addActionListener(e -> updateBalance());
        deleteBtn.addActionListener(e -> deleteAccount());
    }

    // Method to display all accounts
    private void displayAccounts() {
        displayArea.setText("Loading Accounts...\n");
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM account")) {

            while (rs.next()) {
                displayArea.append("ID: " + rs.getInt("id") +
                        ", Account: " + rs.getString("account_number") +
                        ", Balance: $" + rs.getDouble("balance") + "\n");
            }
        } catch (SQLException ex) {
            displayArea.setText("Error fetching accounts: " + ex.getMessage());
        }
    }

    // Method to add a new account
    private void addAccount() {
        String accountNumber = accountField.getText();
        String pinCode = pinField.getText();
        String balance = balanceField.getText();
        String bankId = bankField.getText();

        String query = "INSERT INTO account (account_number, pin_code, balance, bank_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, accountNumber);
            stmt.setString(2, pinCode);
            stmt.setDouble(3, Double.parseDouble(balance));
            stmt.setInt(4, Integer.parseInt(bankId));

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                displayArea.setText("✅ New Account Created Successfully!");
            }
        } catch (SQLException ex) {
            displayArea.setText("❌ Error creating account: " + ex.getMessage());
        }
    }

    // Method to update account balance
    private void updateBalance() {
        String accountNumber = accountField.getText();
        String balance = balanceField.getText();

        String query = "UPDATE account SET balance = ? WHERE account_number = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setDouble(1, Double.parseDouble(balance));
            stmt.setString(2, accountNumber);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                displayArea.setText("✅ Balance Updated Successfully!");
            } else {
                displayArea.setText("❌ Account Not Found!");
            }
        } catch (SQLException ex) {
            displayArea.setText("❌ Error updating balance: " + ex.getMessage());
        }
    }

    // Method to delete an account
    private void deleteAccount() {
        String accountNumber = accountField.getText();

        String query = "DELETE FROM account WHERE account_number = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, accountNumber);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                displayArea.setText("✅ Account Deleted Successfully!");
            } else {
                displayArea.setText("❌ Account Not Found!");
            }
        } catch (SQLException ex) {
            displayArea.setText("❌ Error deleting account: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ATMGUI atmGUI = new ATMGUI();
            atmGUI.setVisible(true);
        });
    }
}