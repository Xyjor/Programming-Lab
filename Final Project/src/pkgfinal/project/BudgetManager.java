/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkgfinal.project;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * The BudgetManager class manages all transactions in the budget tracker application.
 * It provides methods to add, filter, display, and save/load transactions, as well as
 * calculate financial summaries like income, expenses, and balance.
 * 
 * @author airaicon
 */
public class BudgetManager {

    // List to store all transactions
    List<Transaction> transactions;

    // Variables to store total income and expenses
    private double totalIncome;
    private double totalExpenses;

    /**
     * Constructor initializes an empty transaction list and resets income/expenses.
     */
    public BudgetManager() {
        transactions = new ArrayList<>();
        totalIncome = 0;
        totalExpenses = 0;
    }

    /**
     * Adds a transaction to the list and updates income/expenses accordingly.
     * 
     * @param transaction the Transaction object to be added
     */
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        if (transaction.Expense()) {
            totalExpenses += transaction.getAmount(); // Update total expenses for an expense transaction
        } else {
            totalIncome += transaction.getAmount(); // Update total income for an income transaction
        }
    }

    /**
     * Calculates the remaining balance by subtracting total expenses from total income.
     * 
     * @return the calculated balance
     */
    public double calculateBalance() {
        return totalIncome - totalExpenses;
    }

    /**
     * Displays all stored transactions in the console.
     */
    public void displayTransactions() {
        for (Transaction t : transactions) {
            System.out.println(t); // Transaction's toString() method should handle formatting
        }
    }

    // Getter methods for total income and total expenses
    public double getTotalIncome() {
        return totalIncome;
    }

    public double getTotalExpenses() {
        return totalExpenses;
    }

    /**
     * Adds a transaction by prompting user input for details.
     */
    public void addTransactionFromInput() {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter transaction date (YYYY-MM-DD): ");
        String date = in.nextLine();

        System.out.print("Enter category (e.g., Food, Transport, Daily goods): ");
        String category = in.nextLine();

        System.out.print("Enter amount: ");
        double amount = in.nextDouble();

        System.out.print("Is this an expense? [True/False]: ");
        boolean Expense = in.nextBoolean();

        // Create and add the transaction
        Transaction transaction = new Transaction(date, category, amount, Expense);
        addTransaction(transaction);

        System.out.println("Transaction added successfully!");
    }

    /**
     * Filters and displays transactions based on a specific category.
     * 
     * @param category the category to filter by
     */
    public void filterByCategory(String category) {
        List<Transaction> filteredTransactions = transactions.stream()
                .filter(t -> t.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());

        if (filteredTransactions.isEmpty()) {
            System.out.println("No transactions found for category: " + category);
        } else {
            System.out.println("Transactions for category: " + category);
            for (Transaction t : filteredTransactions) {
                System.out.println(t);
            }
        }
    }

    /**
     * Filters and displays transactions based on a specific date.
     * 
     * @param date the date to filter by (format: YYYY-MM-DD)
     */
    public void filtterByDate(String date) {
        List<Transaction> filteredTransactions = transactions.stream()
                .filter(t -> t.getDate().equals(date))
                .collect(Collectors.toList());

        if (filteredTransactions.isEmpty()) {
            System.out.println("No transactions found for date: " + date);
        } else {
            System.out.println("Transactions for date: " + date);
            for (Transaction t : filteredTransactions) {
                System.out.println(t);
            }
        }
    }

    /**
     * Displays a summary of total income, expenses, and remaining balance.
     */
    public void Summary() {
        System.out.println("=== Budget Summary ===");
        System.out.println("Total Income: ₱" + totalIncome);
        System.out.println("Total Expenses: ₱" + totalExpenses);
        System.out.println("Remaining Balance: ₱" + calculateBalance());
        System.out.println("======================");
    }

    /**
     * Saves all transactions to a file for persistent storage.
     * 
     * @param fileName the name of the file to save transactions to
     */
    public void saveTransactionsToFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Transaction transaction : transactions) {
                writer.write(transaction.getDate() + "," 
                        + transaction.getCategory() + "," 
                        + transaction.getAmount() + "," 
                        + transaction.Expense());
                writer.newLine();
            }
            System.out.println("Transactions saved successfully to " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving transactions to file: " + e.getMessage());
        }
    }

    /**
     * Loads transactions from a file into the application.
     * 
     * @param Filename the name of the file to load transactions from
     */
    public void loadTransactionsFromFile(String Filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(Filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Parse each line into transaction details
                String[] parts = line.split(",");
                String date = parts[0];
                String category = parts[1];
                double amount = Double.parseDouble(parts[2]);
                boolean Expense = Boolean.parseBoolean(parts[3]);

                // Create a transaction object and add it to the list
                Transaction transaction = new Transaction(date, category, amount, Expense);
                addTransaction(transaction);
            }
            System.out.println("Transactions loaded successfully from " + Filename);
        } catch (IOException e) {
            System.out.println("Error loading transactions from file: " + e.getMessage());
        }
    }
} // End of BudgetManager class
