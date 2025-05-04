package se.kth.iv1350.sem3.startUp;

import se.kth.iv1350.sem3.integration.InventoryDatabaseSystem;
import se.kth.iv1350.sem3.integration.DiscountDatabaseSystem;
import se.kth.iv1350.sem3.integration.AccountDatabaseSystem;

import se.kth.iv1350.sem3.controller.Controller;
import se.kth.iv1350.sem3.view.View;

public class StartUp {
    public static void startUp(String[] args) {
        /*
         * InventoryDatabaseSystem inv = new InventoryDatabaseSystem();
         * DiscountDatabaseSystem discDB = new DiscountDatabaseSystem();
         * AccountDatabaseSystem acc = new AccountDatabaseSystem();
         * Controller contr = new Controller(inv, discDB, acc);
         */
        Controller contr = new Controller();

        View view = new View(contr);
    }
}
