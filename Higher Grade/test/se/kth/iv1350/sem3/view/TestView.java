package test.se.kth.iv1350.sem3.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;

import src.se.kth.iv1350.sem3.controller.Controller;
import src.se.kth.iv1350.sem3.integration.AccountDatabaseSystem;
import src.se.kth.iv1350.sem3.integration.DiscountDatabaseSystem;
import src.se.kth.iv1350.sem3.integration.InventoryDatabaseSystem;
import src.se.kth.iv1350.sem3.view.View;

/**
 * Integration-level unit tests for the View class.
 * Verifies correct console outputs triggered by example sale flow.
 */
public class TestView {

    private Controller contr;
    private View view;
    private ByteArrayOutputStream printoutBuffer;
    private PrintStream originalSysOut;

    /**
     * Initializes the Controller and View instances before each test.
     * Redirects System.out to capture output for verification.
     */
    @BeforeEach
    void setUp() {
        InventoryDatabaseSystem inv = new InventoryDatabaseSystem();
        DiscountDatabaseSystem disc = new DiscountDatabaseSystem();
        AccountDatabaseSystem acc = new AccountDatabaseSystem();
        contr = new Controller(inv, disc, acc);
        view = new View(contr);

        printoutBuffer = new ByteArrayOutputStream();
        PrintStream inMemoryOut = new PrintStream(printoutBuffer);
        originalSysOut = System.out;
        System.setOut(inMemoryOut);
    }

    /**
     * Cleans up after each test by nullifying the Controller and View instances,
     * resetting the output buffer, and restoring System.out to its original state.
     */
    @AfterEach
    void tearDown() {
        contr = null;
        view = null;
        printoutBuffer = null;
        System.setOut(originalSysOut);
    }

    /**
     * Verifies that the exampleSale method prints the expected output.
     * This includes item names, total revenue, discount messages, and error
     * handling.
     */
    @Test
    void testExampleSalePrintsItemName() {
        view.exampleSale();

        String output = printoutBuffer.toString();
        assertTrue(output.contains("Apple"), "Expected item name 'Apple' not found in output.");
    }

    /**
     * Verifies that the exampleSale method prints the expected output for total
     * revenue.
     */
    @Test
    void testExampleSalePrintsTotalRevenue() {
        view.exampleSale();

        String output = printoutBuffer.toString();
        assertTrue(output.contains("Total revenue:"), "Expected revenue printout not found.");
    }

    /**
     * Verifies that the exampleSale method prints the expected output for discount
     * amounts.
     */
    @Test
    void testExampleSalePrintsDiscount() {
        view.exampleSale();

        String output = printoutBuffer.toString();
        assertTrue(output.contains("The discount amount received is:"), "Expected discount message not found.");
    }

    /**
     * Verifies that the exampleSale method prints the expected output for item not
     * found errors.
     */
    @Test
    void testExampleSalePrintsItemNotFoundMessage() {
        view.exampleSale();

        String output = printoutBuffer.toString();
        assertTrue(output.contains("not found"), "Expected item not found error not found.");
    }

    /**
     * Verifies that the exampleSale method prints the expected output for database
     * failures.
     */
    @Test
    void testExampleSalePrintsDatabaseFailureMessage() {
        view.exampleSale();

        String output = printoutBuffer.toString();
        assertTrue(output.contains("Inventory database failure"), "Expected database failure message not found.");
    }

    /**
     * Verifies that the exampleSale method prints the expected output for payment
     * amounts.
     */
    @Test
    void testExampleSalePrintsChangeAfterPayment() {
        view.exampleSale();

        String output = printoutBuffer.toString();
        assertTrue(output.contains("Change :"), "Expected change amount after payment not found.");
    }
}
