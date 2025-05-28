package src.se.kth.iv1350.sem3.startUp;

import src.se.kth.iv1350.sem3.controller.Controller;
import src.se.kth.iv1350.sem3.integration.AccountDatabaseSystem;
import src.se.kth.iv1350.sem3.integration.DiscountDatabaseSystem;
import src.se.kth.iv1350.sem3.integration.InventoryDatabaseSystem;
import src.se.kth.iv1350.sem3.view.View;

public class StartUp {

    // Main method to start the program
    public static void main(String[] args) {
        InventoryDatabaseSystem inv = new InventoryDatabaseSystem();
        DiscountDatabaseSystem discDB = new DiscountDatabaseSystem();
        AccountDatabaseSystem acc = new AccountDatabaseSystem();
        Controller contr = new Controller(inv, discDB, acc);
        View view = new View(contr);

        view.exampleSale();
    }
}
