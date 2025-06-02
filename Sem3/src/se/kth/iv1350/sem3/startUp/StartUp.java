package src.se.kth.iv1350.sem3.startUp;

import src.se.kth.iv1350.sem3.controller.Controller;
import src.se.kth.iv1350.sem3.integration.AccountDatabaseSystem;
import src.se.kth.iv1350.sem3.integration.DiscountDatabaseSystem;
import src.se.kth.iv1350.sem3.integration.InventoryDatabaseSystem;
import src.se.kth.iv1350.sem3.view.View;

/**
 * Starts the application.
 * Initializes the core components and runs a sample sale.
 */
public class StartUp {

    /**
     * The main method serves as the entry point of the program.
     * It sets up the system by creating instances of the database systems,
     * controller, and view, then runs a sample sale simulation.
     *
     * @param args Command line arguments (not used). <code>String[]</code>
     */
    public static void main(String[] args) {
        InventoryDatabaseSystem inv = new InventoryDatabaseSystem();
        DiscountDatabaseSystem discDB = new DiscountDatabaseSystem();
        AccountDatabaseSystem acc = new AccountDatabaseSystem();
        Controller contr = new Controller(inv, discDB, acc);
        View view = new View(contr);

        view.exampleSale();
    }
}
