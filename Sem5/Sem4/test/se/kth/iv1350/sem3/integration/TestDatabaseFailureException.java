package test.se.kth.iv1350.sem3.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import src.se.kth.iv1350.sem3.integration.DatabaseFailureException;
import src.se.kth.iv1350.sem3.integration.InventoryDatabaseSystem;
import src.se.kth.iv1350.sem3.integration.ItemNotFoundException;

/**
 * Unit test for {@link DatabaseFailureException}.
 * This class verifies that the correct exception message is thrown when
 * a database failure occurs in the {@link InventoryDatabaseSystem}.
 */
public class TestDatabaseFailureException {
    private InventoryDatabaseSystem inv;

    /**
     * Initializes <code>InventoryDatabaseSystem</code> before each test.
     */
    @BeforeEach
    void setUp() {
        inv = new InventoryDatabaseSystem();
    }

    /**
     * Tears down <code>InventoryDatabaseSystem</code> after each test.
     */
    @AfterEach
    void tearDown() {
        inv = null;
    }

    /**
     * Tests that a {@link DatabaseFailureException} is thrown with the expected
     * message when calling <code>fetchItem</code> with an ID that triggers a
     * simulated
     * database failure.
     */
    @Test
    void testDatabaseFailureException() {
        String expectedMessage = "Inventory database failure";
        String actualMessage = "";

        try {
            inv.fetchItem(-1);
        } catch (DatabaseFailureException dfe) {
            actualMessage = "ERROR: " + dfe.getMessage(); // Simulate message formatting as done in the app
        } catch (ItemNotFoundException infe) {
            actualMessage = infe.getMessage(); // Not expected in this case
        }

        assertEquals("ERROR: " + expectedMessage, actualMessage,
                "Expected an error message indicating a database failure.");
    }
}
