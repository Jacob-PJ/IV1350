package test.se.kth.iv1350.sem3.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import src.se.kth.iv1350.sem3.view.ErrorMessages;

class TestErrorMessages {

    private ErrorMessages errorMessages;

    @BeforeEach
    void setUp() {
        errorMessages = new ErrorMessages();
    }

    @AfterEach
    void tearDown() {
        errorMessages = null;
    }

    @Test
    void testCreateItemNotFoundMessage() {
        int itemID = 42;
        String expected = "ERROR: Item ID 42 not found";
        String actual = errorMessages.createItemNotFoundMessage(itemID);
        assertEquals(expected, actual, "Should return correct item not found error message");
    }

    @Test
    void testCreateDatabaseFailureMessage() {
        String expected = "ERROR: Inventory database failure: ";
        String actual = errorMessages.createDatabaseFailureMessage();
        assertEquals(expected, actual, "Should return correct database failure error message");
    }
}
