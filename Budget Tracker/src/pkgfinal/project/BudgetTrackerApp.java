/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkgfinal.project;

/**
 * The BudgetTrackerApp class serves as the entry point for the Budget Tracker application.
 * It manages the initialization and execution flow of the program, including file operations.
 * 
 * @author airaicon
 */
public class BudgetTrackerApp {

    /**
     * The main method is the entry point of the application. It initializes the
     * BudgetManager object, handles file operations, and orchestrates the main menu logic.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Initialize the BudgetManager object to manage transactions
        BudgetManager budgetManager = new BudgetManager();
        
        // File name for storing transaction data
        String Filename = "transaction.txt";
        
        // Load existing transactions from the specified file
        // This step ensures previously saved transactions are accessible when the app starts
        budgetManager.loadTransactionsFromFile(Filename);
        
        // Main menu logic
        // (Implementation is assumed to be provided elsewhere; allows user interaction)
        
        // Save current transactions to the file before exiting
        // This ensures all new or updated transactions are persistently stored
        budgetManager.saveTransactionsToFile(Filename);
    }
    
}
