package test.se.kth.iv1350.sem3.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import src.se.kth.iv1350.sem3.DTOs.ItemDTO;
import src.se.kth.iv1350.sem3.model.ItemInCart;
import src.se.kth.iv1350.sem3.model.Sale;

public class TestSale {

    private Sale sale;

    @BeforeEach
    public void setUp() {
        // Initialize the Sale object
        sale = new Sale();
    }

    @AfterEach
    public void tearDown() {
        // Set sale to null
        sale = null;
    }

    // Thurow test that cehcks that item is properly added to the sale
    // and that the quantity is correct
    @Test
    public void testAddItem() {
        ItemDTO itemDTO1 = new ItemDTO("Apple", 1, "Fresh apple", new BigDecimal("10.00"), new BigDecimal("0.10"));
        ItemInCart item1 = new ItemInCart(itemDTO1, 2);
        sale.addItem(item1);

        ItemDTO itemDTO2 = new ItemDTO("Banana", 2, "Ripe banana", new BigDecimal("5.00"), new BigDecimal("0.05"));
        ItemInCart item2 = new ItemInCart(itemDTO2, 3);
        sale.addItem(item2);

        assertEquals(2, sale.getItems().size(), "Sale should contain two different items");

        assertEquals(2, sale.getItems().get(0).getQuantity(), "First item's quantity should match");
        assertEquals(3, sale.getItems().get(1).getQuantity(), "Second item's quantity should match");

        assertEquals(1, sale.getItems().get(0).getID(), "First item's ID should match");
        assertEquals(2, sale.getItems().get(1).getID(), "Second item's ID should match");
    }

    // Making sure that the quantity of an item is updated when the same item is
    // added again
    @Test
    public void testAddItemWithSameID() {
        Sale sale = new Sale();
        ItemDTO itemDTO = new ItemDTO("Apple", 1, "Fresh apple", new BigDecimal("10.00"), new BigDecimal("0.10"));

        ItemInCart itemFirst = new ItemInCart(itemDTO, 2);
        ItemInCart itemSecond = new ItemInCart(itemDTO, 3); // Same item ID

        sale.addItem(itemFirst);
        sale.addItem(itemSecond);

        assertEquals(1, sale.getItems().size(), "Should only have one entry for the item in the sale");
        assertEquals(5, sale.getItems().get(0).getQuantity(), "Quantity should be merged to 5");
    }

    // Makes sure that payment is processed correctly and change is calculated
    // correctly
    @Test
    public void testMakePayment() {
        // Add 2 apples at 10.00 each
        ItemDTO itemDTO = new ItemDTO("Apple", 1, "Fresh apple", new BigDecimal("10.00"), new BigDecimal("0.10"));
        ItemInCart item = new ItemInCart(itemDTO, 2); // Quantity: 2
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
