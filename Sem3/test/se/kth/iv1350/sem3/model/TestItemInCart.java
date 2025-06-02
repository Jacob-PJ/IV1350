package test.se.kth.iv1350.sem3.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import src.se.kth.iv1350.sem3.model.ItemInCart;
import src.se.kth.iv1350.sem3.DTOs.ItemDTO;

/**
 * Unit test class for ItemInCart.
 * Verifies functionality such as quantity tracking.
 */
public class TestItemInCart {
    private ItemInCart itemInCart;
    private ItemDTO itemDTO;

    /**
     * Sets up test environment by initializing ItemDTO and ItemInCart objects.
     */
    @BeforeEach
    public void setUp() {
        int quantity = 5;
        itemDTO = new ItemDTO("Test Item", 1, "Test Description", new BigDecimal(100), new BigDecimal(0.25));
        itemInCart = new ItemInCart(itemDTO, quantity);
    }

    /**
     * Cleans up test environment by nullifying test objects.
     */
    @AfterEach
    public void tearDown() {
        itemDTO = null;
        itemInCart = null;
    }

    /**
     * Tests that the quantity increases correctly when more items are added.
     */
    @Test
    public void increaseQuantity() {
        int increment = 3;
        itemInCart.increaseQuantity(increment);
        assertEquals(8, itemInCart.getQuantity(), "Expected quantity after increment is 8.");
    }
}
