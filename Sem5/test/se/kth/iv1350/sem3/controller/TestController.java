package test.se.kth.iv1350.sem3.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import src.se.kth.iv1350.sem3.controller.Controller;
import src.se.kth.iv1350.sem3.integration.AccountDatabaseSystem;
import src.se.kth.iv1350.sem3.integration.DiscountDatabaseSystem;
import src.se.kth.iv1350.sem3.integration.InventoryDatabaseSystem;

public class TestController {

    private Controller controller;

    private InventoryDatabaseSystem inv;
    private DiscountDatabaseSystem discDB;
    private AccountDatabaseSystem acc;

    @BeforeEach
    public void setUp() {

        // Initialize the database systems
        inv = new InventoryDatabaseSystem();
        discDB = new DiscountDatabaseSystem();
        acc = new AccountDatabaseSystem();

        // Initialize the controller
        controller = new Controller(inv, discDB, acc);
        controller.startSale();
    }

    @AfterEach
    void tearDown() {
        // Set evreything to null
        controller = null;
        inv = null;
        discDB = null;
        acc = null;
    }

    // End the current sale and start a new one to ensure evrything is reset and
    // check that a sale is active
    @Test
    public void testStartSale() {

        controller.endSale();
        controller.startSale();
        assertTrue(controller.isSaleActive(), "Sale should be active after starting a new sale");
    }

    // Thurow test that cehcks that item is properly added to the sale
    // and that the quantity is correct
    @Test
    public void testAddItem() {
        int itemID1 = 1;
        int quantity1 = 2;

        int itemID2 = 2;
        int quantity2 = 3;

        controller.addItem(itemID1, quantity1);
        controller.addItem(itemID2, quantity2);
        assertEquals(quantity1, controller.getItemsInCurrentSale().get(0).getQuantity(),
                "Item quantity should match the added quantity");
        assertEquals(quantity2, controller.getItemsInCurrentSale().get(1).getQuantity(),
                "Item quantity should match the added quantity");

        assertEquals(itemID1, controller.getItemsInCurrentSale().get(0).getID(),
                "Item ID should match the added item ID");
        assertEquals(itemID2, controller.getItemsInCurrentSale().get(1).getID(),
                "Item ID should match the added item ID");

        assertEquals(2, controller.getItemsInCurrentSale().size(),
                "Sale should contain two items after adding them");
    }

    // Makes sure that the item is not added to the sale if the item ID is invalid
    @Test
    public void testAddItemWithInvalidID() {
        int invalidItemID = 9999; // Assuming this ID doesn't exist
        int quantity = 1;

        controller.startSale(); // required to initialize a sale
        controller.addItem(invalidItemID, quantity);

        // Verify that no items were added
        assertTrue(controller.getItemsInCurrentSale().isEmpty(), "No items should be added for an invalid item ID");
    }

    // Makes sure that payment is processed correctly and change is calculated
    // correctly
    @Test
    public void testMakePayment() {

        int itemID = 1; // Apple
        int quantity = 2;
        controller.addItem(itemID, quantity);

        BigDecimal payment = new BigDecimal("30.00");
        controller.makePayment(payment);

        BigDecimal expectedTotal = new BigDecimal("20"); // 2 apples at 10.00 each
        BigDecimal expectedChange = payment.subtract(expectedTotal); // 10.00

        assertEquals(payment, controller.getPayment(), "Payment should be 30");
        assertEquals(expectedChange, controller.getChange(), "Change should be 10 after payment");
        assertEquals(expectedTotal, controller.getTotalPrice(), "Total price should be 20");
    }

    // Testing that there is no active sale after ending the sale
    @Test
    public void testEndSale() {
        controller.startSale(); // required to start the sale

        controller.endSale(); // we're testing this method

        assertFalse(controller.isSaleActive(), "Sale should be inactive after ending it");
    }

}
