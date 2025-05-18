package test.se.kth.iv1350.sem3.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import src.se.kth.iv1350.sem3.model.ItemInCart;
import src.se.kth.iv1350.sem3.DTOs.ItemDTO;

public class TestItemInCart {
    private ItemInCart itemInCart;
    private ItemDTO itemDTO;

    @BeforeEach
    public void setUp() {
        // Create a ItemInCart object to test
        int qunatity = 5;
        itemDTO = new ItemDTO("Test Item", 1, "Test Description", new BigDecimal(100), new BigDecimal(0.25));
        itemInCart = new ItemInCart(itemDTO, qunatity);
    }

    @AfterEach
    // Set evreything to null
    public void tearDown() {
        itemDTO = null;
        itemInCart = null;
    }

    // Makes sure that increasing the quantity of an item in the cart works
    @Test
    public void increaseQuantity() {
        int increment = 3;
        itemInCart.increaseQuantity(increment);
        assertEquals(8, itemInCart.getQuantity());
    }

}