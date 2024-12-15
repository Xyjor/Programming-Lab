/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkgfinal.project;

import java.awt.List;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class represents a single financial transaction. Each transaction has a
 * date, category, amount, and type (income or expense).
 *
 * @author airaicon
 */
public class Transaction {

    private String date; // Date of the transaction in YYYY-MM-DD format
    private String category; // The category for the transaction (e.g., Food, Rent, Entertainment)
    private double amount; // The monetary value of the transaction
    boolean Expense; // True if the transaction is an expense, false if it's an income

    /**
     * Constructor to initialize a Transaction object with specific details.
     *
     * @param date The date of the transaction in YYYY-MM-DD format.
     * @param category The category to which the transaction belongs.
     * @param amount The amount of the transaction.
     * @param Expense True if the transaction is an expense, false if it's an
     * income.
     */
    public Transaction(String date, String category, double amount, boolean Expense) {
        this.date = date;
        this.category = category;
        this.amount = amount;
        this.Expense = Expense;
    }

    /**
     * Getter method for the date of the transaction.
     *
     * @return The date of the transaction as a string.
     */
    public String getDate() {
        return date;
    }

    /**
     * Getter method for the category of the transaction.
     *
     * @return The category of the transaction as a string.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Setter method for the category of the transaction. Note: The parameter
     * for this method is missing and should be included.
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Getter method for the amount of the transaction.
     *
     * @return The amount of the transaction as a double.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Setter method for the amount of the transaction.
     *
     * @param amount The new amount to set for the transaction.
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Method to determine if the transaction is an expense.
     *
     * @return True if the transaction is an expense, false if it's an income.
     */
    public boolean Expense() {
        return Expense;
    }

    /**
     * Returns a string representation of the transaction, displaying its type,
     * date, category, and amount. This method is useful for debugging or
     * displaying transaction details.
     *
     * @return A formatted string containing transaction details.
     */
    @Override
    public String toString() {
        return (Expense ? "Expense" : "Income") + " | Date " + date + " | Category " + category + " | Amount " + amount;
    }
}
