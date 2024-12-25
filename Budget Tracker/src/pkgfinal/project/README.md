*Name: Rojyx L. Yangyang
*Block: BSCoE - I
*Final Project Title: Budget Tracker
*Date: 2024 - 12 - 15

# |Project Overview and Problem Statement

The Budget Tracker application is designed to help users manage their personal finances efficiently.
The key problem this application addresses is the lack of a simple, user-friendly tool that allows individuals to record, categorize, and analyze their financial transactions. 
By offering features for tracking income and expenses, viewing transaction summaries, and filtering specific entries, the Budget Tracker empowers users to maintain better control over their financial health.

# |Approach and Solution Design

The approach to solving the problem is through an intuitive graphical user interface (GUI) built using Java Swing. 
The key design elements include the following components:

1. *Main Interface:*
   - A window displaying a table to visualize transaction records.
   - Input fields and buttons to add new transactions, view summaries, save data to files, and load data from files.

2. *Data Management:*
   - Transactions are stored and managed using the `BudgetManager` class, which handles operations like adding, filtering, saving, and loading transaction data.
   - Transactions are displayed in a tabular format with columns for Date, Category, Amount, and Type (Income/Expense).

3. *User Interaction:*
   - Users can add new transactions by filling out input fields and clicking the 'Add Transaction' button.
   - Users can filter transactions by date or category and see the filtered results in the table.
   - The 'View Summary' button displays a financial summary including total income, total expenses, and the remaining balance.

4. *Data Persistence:*
   - Users can save their transaction data to a file and load it back, ensuring data is not lost between sessions.

# |Code Explanations

1. **Main Components:**
   - *BGTGUI Class*: Manages the graphical interface and user interactions.
   - *BudgetManager Class*: Manages transaction data, storing a list of transactions and performing operations like adding, filtering, and summarizing them.
   - *Transaction Class*: Represents an individual financial transaction with attributes like date, category, amount, and type (income or expense).

2. **Key Methods in BGTGUI:**
   - *createAndShowGUI()*: Sets up the main window, tables, input fields, buttons, and event listeners.
   - *saveTransactionsToFile()*: Saves transaction data to a file for future reference.
   - *loadTransactionsFromFile()*: Loads previously saved transaction data from a file.
   - *createModernButton()*: Creates styled buttons for the interface.

3. **Event Listeners:**
   - Add Button: Adds a new transaction to the table and updates the BudgetManager's transaction list.
   - Summary Button: Shows a summary of total income, total expenses, and balance.
   - Save Button: Saves transactions to a file.
   - Load Button: Loads transactions from a file.
   - Filter Buttons: Filter transactions by date or category.

# |Example Inputs and Outputs

**Example 1:**
- *Input:*
  - Date: 2024-12-15
  - Category: Groceries
  - Amount: 50.00
  - Type: Expense (checked)
- *Result:*
  - Transaction is added to the table with the following row: 2024-12-15 | Groceries | 50.00 | Expense
  - Balance is updated in the summary window.

**Example 2:**
- *Input:
  - Click "View Summary" Button
- *Result:*
  - A dialog appears showing the total income, total expenses, and balance, e.g.,
    - Total Income: $2000
    - Total Expenses: $500
    - Remaining Balance: $1500

**Example 3:**
- *Input:*
  - Click "Save to File" Button
- *Result:*
  - A file dialog appears, allowing the user to select where to save the file.

# |Features of the Budget Tracker Application

1. **Transaction Management:**
   - Add transactions with date, category, amount, and type (income/expense).
   - View all transactions in a tabular format.

2. **Data Persistence:**
   - Save transaction data to a file.
   - Load previously saved data back into the application.

3. **Data Filtering and Sorting:**
   - Filter transactions by category.
   - Filter transactions by date.

4. **Financial Summary:**
   - View a financial summary showing total income, total expenses, and remaining balance.

5. **User-Friendly Design:**
   - Intuitive, clean, and modern UI with categorized input fields, buttons, and tables.
   - Error handling to notify users of invalid input.

6. **Cross-Platform Compatibility:**
   - Runs on any platform that supports Java (Windows, macOS, Linux).

# |How to Run the Application

1. **Prerequisites:**
   - Ensure Java Development Kit (JDK) is installed on your system.
   - Set up a Java Integrated Development Environment (IDE) such as IntelliJ IDEA, Eclipse, or Visual Studio Code with Java extensions.

2. **Steps to Run:**
   - Open the source code file `BGTGUI.java` in your IDE.
   - Compile the file to ensure there are no syntax errors.
   - Run the `BGTGUI` class as a Java application.
   - The Budget Tracker window will appear, allowing you to start managing transactions.

3. **Alternative Method:**
   - Use the command line to compile the file using `javac BGTGUI.java`.
   - Run the application using `java BGTGUI`.

# |Additional Notes

- *Error Handling:* Invalid input is handled with error messages to help users correct their entries.
- *Extensibility:* This application can be extended with new features like data visualization, expense forecasting, and multi-user support.
- *Usability:* The clean and modern user interface makes the application accessible to users with minimal technical skills.
- *Possible Enhancements:* Future development could include user authentication, enhanced data security, and cloud storage integration.

