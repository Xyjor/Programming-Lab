/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkgfinal.project;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;

/**
 * Improved Budget Tracker GUI with enhanced user interface and usability.
 * @author airaicon
 */
public class BGTGUI {

    private final BudgetManager budgetManager;

    public BGTGUI() {
        budgetManager = new BudgetManager();
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        // Main application frame
        JFrame frame = new JFrame("Rojyx's Budget Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 750);
        frame.setResizable(true);
        frame.setLayout(new BorderLayout(15, 15));
        frame.getContentPane().setBackground(new Color(230, 240, 255));
        frame.setLocationRelativeTo(null);

        // Title label
        JLabel titleLabel = new JLabel("Budget Tracker", JLabel.CENTER);
        titleLabel.setFont(new Font("Montserrat", Font.BOLD, 24));
        titleLabel.setForeground(new Color(25, 25, 112));
        frame.add(titleLabel, BorderLayout.NORTH);

        // Main content panel
        JPanel mainPanel = new JPanel(new BorderLayout(15, 15));
        mainPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        mainPanel.setBackground(new Color(230, 240, 255));

        // Transaction table
        String[] columnNames = {"Date", "Category", "Amount (PHP)", "Type"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable transactionTable = new JTable(tableModel);
        transactionTable.setFont(new Font("Montserrat", Font.PLAIN, 14));
        transactionTable.setRowHeight(30);
        JScrollPane tableScrollPane = new JScrollPane(transactionTable);
        tableScrollPane.setBorder(BorderFactory.createTitledBorder("Transactions"));
        mainPanel.add(tableScrollPane, BorderLayout.CENTER);

        // Transaction input panel
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBorder(BorderFactory.createTitledBorder("Add Transaction"));
        inputPanel.setBackground(new Color(230, 240, 255));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Input fields
        addInputField(inputPanel, gbc, "Date (YYYY-MM-DD):", 0);
        JTextField dateField = new JTextField(15);
        gbc.gridx = 1;
        inputPanel.add(dateField, gbc);

        addInputField(inputPanel, gbc, "Category:", 1);
        JTextField categoryField = new JTextField(15);
        gbc.gridx = 1;
        inputPanel.add(categoryField, gbc);

        addInputField(inputPanel, gbc, "Amount:", 2);
        JTextField amountField = new JTextField(15);
        gbc.gridx = 1;
        inputPanel.add(amountField, gbc);

        addInputField(inputPanel, gbc, "Expense:", 3);
        JCheckBox expenseBox = new JCheckBox("Check if Expense");
        expenseBox.setBackground(new Color(230, 240, 255));
        gbc.gridx = 1;
        inputPanel.add(expenseBox, gbc);

        // Buttons panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        buttonPanel.setBackground(new Color(230, 240, 255));

        JButton addButton = createButton("Add Transaction");
        JButton summaryButton = createButton("View Summary");
        JButton saveButton = createButton("Save to File");
        JButton loadButton = createButton("Load from File");
        JButton resetFiltersButton = createButton("Reset Filters");

        buttonPanel.add(addButton);
        buttonPanel.add(summaryButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);
        buttonPanel.add(resetFiltersButton);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        inputPanel.add(buttonPanel, gbc);

        mainPanel.add(inputPanel, BorderLayout.NORTH);

        // Filter panel
        JPanel filterPanel = new JPanel(new GridLayout(2, 3, 15, 10));
        filterPanel.setBorder(BorderFactory.createTitledBorder("Filter Transactions"));
        filterPanel.setBackground(new Color(230, 240, 255));

        JTextField filterCategoryField = new JTextField();
        JTextField filterDateField = new JTextField();

        filterPanel.add(new JLabel("Category:"));
        filterPanel.add(filterCategoryField);
        JButton filterCategoryButton = createButton("Filter by Category");
        filterPanel.add(filterCategoryButton);

        filterPanel.add(new JLabel("Date:"));
        filterPanel.add(filterDateField);
        JButton filterDateButton = createButton("Filter by Date");
        filterPanel.add(filterDateButton);

        mainPanel.add(filterPanel, BorderLayout.SOUTH);
        frame.add(mainPanel, BorderLayout.CENTER);

        // Button functionality
        addButton.addActionListener(e -> addTransaction(dateField, categoryField, amountField, expenseBox, tableModel));
        summaryButton.addActionListener(e -> showSummary(frame));
        saveButton.addActionListener(e -> saveTransactions(frame));
        loadButton.addActionListener(e -> loadTransactions(frame, tableModel));
        filterCategoryButton.addActionListener(e -> filterTransactionsByCategory(filterCategoryField, tableModel));
        filterDateButton.addActionListener(e -> filterTransactionsByDate(filterDateField, tableModel));
        resetFiltersButton.addActionListener(e -> resetFilters(tableModel));

        frame.setVisible(true);
    }

    private void addInputField(JPanel panel, GridBagConstraints gbc, String label, int row) {
        gbc.gridx = 0;
        gbc.gridy = row;
        panel.add(new JLabel(label), gbc);
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Montserrat", Font.BOLD, 14));
        button.setBackground(new Color(70, 130, 180));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        return button;
    }

    private void addTransaction(JTextField dateField, JTextField categoryField, JTextField amountField, JCheckBox expenseBox, DefaultTableModel tableModel) {
        try {
            String date = dateField.getText();
            String category = categoryField.getText();
            double amount = Double.parseDouble(amountField.getText());
            boolean isExpense = expenseBox.isSelected();

            Transaction transaction = new Transaction(date, category, amount, isExpense);
            budgetManager.addTransaction(transaction);

            tableModel.addRow(new Object[]{
                date, category, amount, isExpense ? "Expense" : "Income"
            });

            dateField.setText("");
            categoryField.setText("");
            amountField.setText("");
            expenseBox.setSelected(false);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please check your entries.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void showSummary(JFrame frame) {
        JOptionPane.showMessageDialog(frame,
            "Total Income: ₱" + budgetManager.getTotalIncome() +
            "\nTotal Expenses: ₱" + budgetManager.getTotalExpenses() +
            "\nRemaining Balance: ₱" + budgetManager.calculateBalance(),
            "Budget Summary", JOptionPane.INFORMATION_MESSAGE);
    }

    private void saveTransactions(JFrame frame) {
       JFileChooser fileChooser = new JFileChooser();
    if (fileChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
        File file = fileChooser.getSelectedFile();

        // Ensure the file has a .csv extension
        if (!file.getName().toLowerCase().endsWith(".csv")) {
            file = new File(file.getAbsolutePath() + ".csv");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Transaction transaction : budgetManager.transactions) {
                writer.write(transaction.getDate() + "," + transaction.getCategory() + "," 
                             + transaction.getAmount() + "," + transaction.Expense());
                writer.newLine();
            }
            JOptionPane.showMessageDialog(frame, "Transactions saved successfully as " + file.getName());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Error saving transactions: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

    private void loadTransactions(JFrame frame, DefaultTableModel tableModel) {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                budgetManager.transactions.clear();
                tableModel.setRowCount(0);
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    String date = parts[0];
                    String category = parts[1];
                    double amount = Double.parseDouble(parts[2]);
                    boolean isExpense = Boolean.parseBoolean(parts[3]);

                    Transaction transaction = new Transaction(date, category, amount, isExpense);
                    budgetManager.addTransaction(transaction);

                    tableModel.addRow(new Object[]{date, category, amount, isExpense ? "Expense" : "Income"});
                }
                JOptionPane.showMessageDialog(frame, "Transactions loaded successfully.");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(frame, "Error loading transactions: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void filterTransactionsByCategory(JTextField filterField, DefaultTableModel tableModel) {
        String category = filterField.getText().trim();
        tableModel.setRowCount(0);
        budgetManager.transactions.stream()
                .filter(transaction -> transaction.getCategory().equalsIgnoreCase(category))
                .forEach(transaction -> tableModel.addRow(new Object[]{
                    transaction.getDate(), transaction.getCategory(), transaction.getAmount(),
                    transaction.Expense() ? "Expense" : "Income"
                }));
    }

    private void filterTransactionsByDate(JTextField filterField, DefaultTableModel tableModel) {
        String date = filterField.getText().trim();
        tableModel.setRowCount(0);
        budgetManager.transactions.stream()
                .filter(transaction -> transaction.getDate().equals(date))
                .forEach(transaction -> tableModel.addRow(new Object[]{
                    transaction.getDate(), transaction.getCategory(), transaction.getAmount(),
                    transaction.Expense() ? "Expense" : "Income"
                }));
    }

    private void resetFilters(DefaultTableModel tableModel) {
        tableModel.setRowCount(0);
        budgetManager.transactions.forEach(transaction -> tableModel.addRow(new Object[]{
            transaction.getDate(), transaction.getCategory(), transaction.getAmount(),
            transaction.Expense() ? "Expense" : "Income"
        }));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BGTGUI::new);
    }
}