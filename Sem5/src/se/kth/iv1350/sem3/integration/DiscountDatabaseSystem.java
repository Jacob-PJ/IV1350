package src.se.kth.iv1350.sem3.integration;

import src.se.kth.iv1350.sem3.DTOs.DiscountDTO;
import src.se.kth.iv1350.sem3.DTOs.ItemDTO;
import src.se.kth.iv1350.sem3.model.ItemInCart;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

/**
 * This class represents a simulated external discount database system.
 * It provides discount data for items, customers, and entire sales.
 * <p>
 * Since this is a mock implementation for demonstration or testing purposes,
 * discounts are hardcoded and no real database connection exists.
 */
public class DiscountDatabaseSystem {
    private final List<DiscountDTO> itemDiscounts = new ArrayList<>();

    /**
     * Creates a new instance of the discount database system and preloads
     * it with some hardcoded discounts for specific item IDs.
     */
    public DiscountDatabaseSystem() {
        itemDiscounts.add(new DiscountDTO(1, 3.0)); // Apple
        itemDiscounts.add(new DiscountDTO(2, 1.5)); // Banana
        itemDiscounts.add(new DiscountDTO(3, 5.0)); // Orange
    }

    /**
     * Calculates the total discount for a list of items by summing individual
     * discounts
     * for each item ID that has a corresponding entry in the discount database.
     *
     * @param items The list of items to calculate discounts for.
     * @return The total discount amount for all matching items.
     */
    public BigDecimal getDiscountFromItems(List<ItemInCart> items) {
        BigDecimal totalDiscount = BigDecimal.ZERO;
        for (ItemInCart item : items) {
            int itemId = item.getID();
            for (DiscountDTO discount : itemDiscounts) {
                if (discount.getItemID() == itemId) {
                    totalDiscount = totalDiscount.add(
                            BigDecimal.valueOf(discount.getDiscountAmount() * item.getQuantity()));
                    break;
                }
            }
        }
        return totalDiscount;
    }

    /**
     * Returns a fixed discount amount based on the total sale price.
     * <p>
     * In this mock implementation, a flat discount is always applied.
     *
     * @param totalPrice The total price of the sale before discounts.
     * @return A fixed discount amount.
     */
    public BigDecimal getDiscountFromTotal(BigDecimal totalPrice) {
        return BigDecimal.valueOf(20); // Simulated flat discount
    }

    /**
     * Returns a fixed discount amount based on a customer ID.
     * <p>
     * This is a placeholder implementation and always returns the same value.
     *
     * @param customerId The ID of the customer requesting the discount.
     * @return A fixed discount amount for the customer.
     */
    public BigDecimal getDiscountFromCustomerId(String customerId) {
        return BigDecimal.valueOf(25); // Simulated flat customer discount
    }
}
