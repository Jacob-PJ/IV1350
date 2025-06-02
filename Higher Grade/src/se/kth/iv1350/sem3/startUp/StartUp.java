package src.se.kth.iv1350.sem3.startUp;

import src.se.kth.iv1350.sem3.controller.Controller;
import src.se.kth.iv1350.sem3.integration.AccountDatabaseSystem;
import src.se.kth.iv1350.sem3.integration.DiscountDatabaseSystem;
import src.se.kth.iv1350.sem3.integration.InventoryDatabaseSystem;
import src.se.kth.iv1350.sem3.view.View;
import src.se.kth.iv1350.sem3.util.RandomCompositor;
import src.se.kth.iv1350.sem3.util.RandomInheritance;

/**
 * Starts the application.
 * Initializes the core components and runs a sample sale.
 */
public class StartUp {

    /**
     * The main method serves as the entry point of the program.
     * It sets up the system by creating instances of the database systems,
     * controller, and view, then runs a sample sale simulation.
     * After that, it demonstrates adapting java.util.Random using both
     * inheritance and composition.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        InventoryDatabaseSystem inv = new InventoryDatabaseSystem();
        DiscountDatabaseSystem discDB = new DiscountDatabaseSystem();
        AccountDatabaseSystem acc = new AccountDatabaseSystem();
        Controller contr = new Controller(inv, discDB, acc);
        View view = new View(contr);

        view.exampleSale();

        RandomInheritance ria = new RandomInheritance();
        ria.nextInt(100);

        RandomCompositor rca = new RandomCompositor();
        rca.nextEvenInt(100);
    }
}
