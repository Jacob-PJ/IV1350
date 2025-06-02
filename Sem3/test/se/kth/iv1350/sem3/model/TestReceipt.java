package test.se.kth.iv1350.sem3.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Locale;

import src.se.kth.iv1350.sem3.DTOs.ItemDTO;
import src.se.kth.iv1350.sem3.model.ItemInCart;
import src.se.kth.iv1350.sem3.model.Receipt;
import src.se.kth.iv1350.sem3.model.Sale;

/**
 * Unit tests for the Receipt class.
 * Verifies that the receipt content is generated correctly based on the sale.
 */
public class TestReceipt {

    private Sale sale;
    private Receipt receipt;

    /**
     * Initializes the sale and receipt before each test.
     */
    @BeforeEach
    public void setUp() {
        sale = new Sale();
        receipt = new Receipt(sale);
    }

    /**
     * Clears references after each test.
     */
    @AfterEach
    public void tearDown() {
        sale = null;
        receipt = null;
    }

    /**
     * Verifies that the generated receipt contains the correct structure and values
     * based on a sale with a known item and payment.
     */
    @Test
    public void testGetReceipt() {
        ItemDTO itemDTO = new ItemDTO("Test Item", 1, "Test Desc", new BigDecimal("10.00"), new BigDecimal("0.10"));
        ItemInCart item = new ItemInCart(itemDTO, 2); // 2 items
        sale.addItem(item);
        sale.makePayment(new BigDecimal("30.00"));

        receipt.generateReciept();
        String actualReceipt = receipt.getReceipt();

        String expectedReceipt = "- - - - - - - - - - - - - - - - - - Begin receipt - - - - - - - - - - - - - - - - - - -\n";
        expectedReceipt += "Time of Sale : " + sale.getTimeOfSaleAsString() + "\n";
        expectedReceipt += "Test Item 2 x " + String.format(Locale.US, "%.2f", new BigDecimal("10.00"));
        expectedReceipt += " " + String.format(Locale.US, "%.2f", new BigDecimal("20.00")) + " SEK\n";
        expectedReceipt += "Total price : " + String.format(Locale.US, "%.2f", new BigDecimal("20.00")) + " SEK\n";
        expectedReceipt += "VAT : " + String.format(Locale.US, "%.2f", new BigDecimal("2.00")) + " SEK\n";
        expectedReceipt += "Cash : " + String.format(Locale.US, "%.2f", new BigDecimal("30.00")) + " SEK\n";
        expectedReceipt += "Change : " + String.format(Locale.US, "%.2f", new BigDecimal("10.00")) + " SEK\n";
        expectedReceipt += "Total Discount : " + String.format(Locale.US, "%.2f", BigDecimal.ZERO) + " SEK\n";
        expectedReceipt += "- - - - - - - - - - - - - - - - - - End receipt - - - - - - - - - - - - - - - - - - - - -\n";

        assertEquals(expectedReceipt, actualReceipt);
    }
}
