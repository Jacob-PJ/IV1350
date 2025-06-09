package test.se.kth.iv1350.sem3.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import src.se.kth.iv1350.sem3.DTOs.ItemDTO;
import src.se.kth.iv1350.sem3.model.ItemInCart;
import src.se.kth.iv1350.sem3.model.Sale;

/**
 * Unit tests for the Sale class.
 * Verifies correct behavior for item management and payment processing during a
 * sale.
 */
public class TestSale {

    private Sale sale;

    /**
     * Sets up a new Sale instance before each test.
     */
    @BeforeEach
    public void setUp() {
        sale = new Sale();
    }

    /**
     * Clears the Sale instance after each test.
     */
    @AfterEach
    public void tearDown() {
        sale = null;
    }

    /**
     * Tests that adding different items results in separate entries in the sale.
     * Verifies that their IDs and quantities are correctly recorded.
     */
    @Test
    public void testAddItem() {
        ItemDTO itemDTO1 = new ItemDTO("Apple", 1, "Fresh apple", new BigDecimal("10.00"), new BigDecimal("0.10"));
        ItemInCart item1 = new ItemInCart(itemDTO1, 2);
        sale.addItem(item1);

        ItemDTO itemDTO2 = new ItemDTO("Banana", 2, "Ripe banana", new BigDecimal("5.00"), new BigDecimal("0.05"));
        ItemInCart item2 = new ItemInCart(itemDTO2, 3);
        sale.addItem(item2);

        assertEquals(2, sale.getTotalItemCount(), "Sale should contain two different items");

        assertEquals(2, sale.getQuantityOfItemAtIndex(0), "First item's quantity should match");
        assertEquals(3, sale.getQuantityOfItemAtIndex(1), "Second item's quantity should match");

        assertEquals(1, sale.getIdOfItemAtIndex(0), "First item's ID should match");
        assertEquals(2, sale.getIdOfItemAtIndex(1), "Second item's ID should match");
    }

    /**
     * Verifies that adding the same item ID multiple times results in updated
     * quantity
     * rather than duplicate entries.
     */
    @Test
    public void testAddItemWithSameID() {
        ItemDTO itemDTO = new ItemDTO("Apple", 1, "Fresh apple", new BigDecimal("10.00"), new BigDecimal("0.10"));

        ItemInCart itemFirst = new ItemInCart(itemDTO, 2);
        ItemInCart itemSecond = new ItemInCart(itemDTO, 3); // Same item ID

        sale.addItem(itemFirst);
        sale.addItem(itemSecond);

        assertEquals(1, sale.getTotalItemCount(), "Should only have one entry for the item in the sale");
        assertEquals(5, sale.getQuantityOfItemAtIndex(0), "Quantity should be merged to 5");
    }

    /**
     * Verifies that the payment and change calculations are handled correctly
     * after a purchase.
     */
    @Test
    public void testMakePayment() {
        ItemDTO itemDTO = new ItemDTO("Apple", 1, "Fresh apple", new BigDecimal("10.00"), new BigDecimal("0.10"));
        ItemInCart item = new ItemInCart(itemDTO, 2);
        sale.addItem(item);

        BigDecimal payment = new BigDecimal("30.00");
        sale.makePayment(payment);

        BigDecimal expectedTotal = new BigDecimal("20.00"); // 2 × 10.00
        BigDecimal expectedChange = payment.subtract(expectedTotal); // 10.00

        assertEquals(payment, sale.getPayment(), "Payment should be 30.00");
        assertEquals(expectedChange, sale.getChange(), "Change should be 10.00");
        assertEquals(expectedTotal, sale.getTotalPriceOfSale(), "Total price should be 20.00");
    }
}
