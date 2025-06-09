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

/**
 * Unit tests for the {@link Controller} class.
 * Verifies correct behavior for starting sales, adding items,
 * handling invalid input, and processing payments.
 */
public class TestController {

    private Controller controller;
    private InventoryDatabaseSystem inv;
    private DiscountDatabaseSystem discDB;
    private AccountDatabaseSystem acc;

    /**
     * Initializes the database systems and controller before each test.
     */
    @BeforeEach
    public void setUp() {
        inv = new InventoryDatabaseSystem();
        discDB = new DiscountDatabaseSystem();
        acc = new AccountDatabaseSystem();
        controller = new Controller(inv, discDB, acc);
        controller.startSale();
    }

    /**
     * Cleans up test resources after each test.
     */
    @AfterEach
    void tearDown() {
        controller = null;
        inv = null;
        discDB = null;
        acc = null;
    }

    /**
     * Tests that starting a sale activates a new sale.
     * Ends a previous sale and verifies that a new sale is started successfully.
     */
    @Test
    public void testStartSale() {
        controller.endSale();
        controller.startSale();
        assertTrue(controller.isSaleActive(), "Sale should be active after starting a new sale");
    }

    /**
     * Tests that adding multiple items correctly updates the sale with appropriate
     * quantities and item IDs.
     */
    @Test
    public void testAddItem() {
        int itemID1 = 1;
        int quantity1 = 2;

        int itemID2 = 2;
        int quantity2 = 3;

        controller.addItem(itemID1, quantity1);
        controller.addItem(itemID2, quantity2);

        assertEquals(quantity1, controller.getSaleQuantityOfItemAtIndex(0),
                "Item quantity should match the added quantity");
        assertEquals(quantity2, controller.getSaleQuantityOfItemAtIndex(1),
                "Item quantity should match the added quantity");

        assertEquals(itemID1, controller.getSaleIdOfItemAtIndex(0),
                "Item ID should match the added item ID");
        assertEquals(itemID2, controller.getSaleIdOfItemAtIndex(1),
                "Item ID should match the added item ID");

        assertEquals(2, controller.getSaleTotalItemCount(),
                "Sale should contain two items after adding them");
    }

    /**
     * Verifies that no item is added if the item ID is invalid.
     */
    @Test
    public void testAddItemWithInvalidID() {
        int invalidItemID = 9999;
        int quantity = 1;

        controller.startSale();
        controller.addItem(invalidItemID, quantity);

        assertTrue(controller.getSaleTotalItemCount() == 0,
                "No items should be added for an invalid item ID");
    }

    /**
     * Verifies that payment is processed and correct change is calculated.
     */
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

    /**
     * Tests that ending a sale properly deactivates it.
     */
    @Test
    public void testEndSale() {
        controller.startSale();
        controller.endSale();

        assertFalse(controller.isSaleActive(), "Sale should be inactive after ending it");
    }
}
