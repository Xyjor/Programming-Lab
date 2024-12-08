/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg1st.semester;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author YANGYANG_COMP111
 */
public class Store {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        
        // Shop items and prices
        String[] items = {"Apple", "Banana", "Orange", "Milk", "Bread"};
        int[] prices = {10, 15, 20, 25, 30};
        
        int totalTransactions = 0;
        int totalProfit = 0;
        
        System.out.println("Welcome to the Interactive Shop!");

        boolean anotherCustomer;
        do {
            int customerTotal = 0;
            int[] purchasedItems = new int[items.length];
            boolean shopping = true;
            
            while (shopping) {
                System.out.println("\nAvailable items:");
                for (int i = 0; i < items.length; i++) {
                    System.out.println((i + 1) + ". " + items[i] + " - $" + prices[i]);
                }

                // Choosing an item
                System.out.print("Choose an item by number (1-5): ");
                int choice = scanner.nextInt() - 1;
                
                if (choice < 0 || choice >= items.length) {
                    System.out.println("Invalid choice. Please select a valid item.");
                    continue;
                }
                
                // Quantity
                System.out.print("Enter quantity for " + items[choice] + ": ");
                int quantity = scanner.nextInt();
                
                int cost = prices[choice] * quantity;
                purchasedItems[choice] += quantity;
                customerTotal += cost;
                
                System.out.println("Added " + quantity + " " + items[choice] + "(s) to cart. Current cart total: $" + customerTotal);
                
                // Another item
                System.out.print("Do you want to purchase another item? (yes/no): ");
                scanner.nextLine();  // Consume newline left-over
                String response = scanner.nextLine();
                shopping = response.equalsIgnoreCase("yes");
            }
            
            // Payment processing
            boolean transactionCompleted = handlePayment(scanner, customerTotal);
            
            if (transactionCompleted) {
                totalProfit += customerTotal;
                totalTransactions++;
                
                // Display receipt for the current customer
                System.out.println("\n=== Customer Receipt ===");
                for (int i = 0; i < items.length; i++) {
                    if (purchasedItems[i] > 0) {
                        System.out.println(items[i] + " x" + purchasedItems[i] + " - $" + (prices[i] * purchasedItems[i]));
                    }
                }
                System.out.println("Total: $" + customerTotal);
                System.out.println("========================\n");
            } else {
                System.out.println("Transaction voided due to insufficient payment.");
            }
            
            // Ask if there's another customer
            System.out.print("Is there another customer? (yes/no): ");
            anotherCustomer = scanner.nextLine().equalsIgnoreCase("yes");
            
        } while (anotherCustomer);
        
        // Final summary
        System.out.println("\n=== Shop Summary ===");
        System.out.println("Total Transactions: " + totalTransactions);
        System.out.println("Total Profit: $" + totalProfit);
        System.out.println("Shop is now closed. Thank you for visiting!");
        
        scanner.close();
    }
    
    // Method to handle payment process
    public static boolean handlePayment(Scanner scanner, int totalCost) {
        int attempts = 0;
        int payment = 0;
        
        do {
            System.out.print("Enter payment amount: $");
            payment += scanner.nextInt();
            int remaining = totalCost - payment;
            
            if (remaining > 0) {
                System.out.println("Insufficient payment. You still need to pay $" + remaining);
            } else if (remaining < 0) {
                System.out.println("Payment accepted. Change: $" + (-remaining));
                scanner.nextLine();  // Consume newline left-over
                return true;
            } else {
                System.out.println("Payment accepted. No change.");
                scanner.nextLine();  // Consume newline left-over
                return true;
            }
            
            attempts++;
        } while (attempts < 3 && payment < totalCost);
        
        scanner.nextLine(); // Consume newline left-over after last payment attempt
        
        return payment >= totalCost;
    }
}