package test.se.kth.iv1350.sem3.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Locale;

import src.se.kth.iv1350.sem3.DTOs.ItemDTO;
import src.se.kth.iv1350.sem3.model.ItemInCart;
import src.se.kth.iv1350.sem3.model.Messages;
import src.se.kth.iv1350.sem3.model.Sale;

/**
 * Unit tests for the Messages class.
 * Verifies that the formatted messages returned by the class match expected
 * output.
 */
public class TestMessages {

    private Messages messages;

    /**
     * Initializes the Messages object before each test.
     */
    @BeforeEach
    public void setUp() {
        messages = new Messages();
    }

    /**
     * Clears the Messages object after each test.
     */
    @AfterEach
    public void tearDown() {
        messages = null;
    }

    /**
     * Verifies that the message for an added item is formatted correctly.
     */
    @Test
    public void testCreateAddedItemMessage() {
        int quantity = 5;
        int itemID = 1;
        String itemName = "Test Item";
        String itemDescription = "Test Description";
        BigDecimal itemPrice = new BigDecimal(100.00);
        BigDecimal itemVAT = new BigDecimal(0.25);

        ItemDTO itemDTO = new ItemDTO(itemName, itemID, itemDescription, itemPrice, itemVAT);
        ItemInCart itemInCart = new ItemInCart(itemDTO, quantity);

        String expectedMessage = "Added " + quantity + " items with ID " + itemID + ":\n";
        expectedMessage += "Item ID: " + itemID + "\n";
        expectedMessage += "Item name: " + itemName + "\n";
        expectedMessage += "Item cost: " + String.format(Locale.US, "%.2f", itemPrice) + " SEK\n";
        expectedMessage += "VAT: " + itemVAT.multiply(BigDecimal.valueOf(100)) + " %\n";
        expectedMessage += "Item description: " + itemDescription + "\n\n";

        String actualMessage = messages.createAddedItemMessage(itemInCart);
        assertEquals(expectedMessage, actualMessage);
    }

    /**
     * Verifies that the message for running cost is formatted correctly based on
     * the sale contents.
     */
    @Test
    public void testCreateRunningCostMessage() {
        Sale sale = new Sale();

        ItemDTO itemDTO = new ItemDTO("Test Item", 1, "Test Description", new BigDecimal("100.00"),
                new BigDecimal("0.25"));
        ItemInCart item = new ItemInCart(itemDTO, 2);
        sale.addItem(item);

        String expectedMessage = "Total cost (incl. VAT): 200.00 SEK\n";
        expectedMessage += "Total VAT: 50.00 SEK\n\n";

        String actualMessage = messages.createRunningCostMessage(sale);
        assertEquals(expectedMessage, actualMessage);
    }

    /**
     * Verifies that the start sale message is correctly formatted.
     */
    @Test
    public void testCreateStartSaleMessage() {
        String expectedMessage = "------------------Starting Sale-------------------\n";
        String actualMessage = messages.createStartSaleMessage();
        assertEquals(expectedMessage, actualMessage);
    }
}
