package src.se.kth.iv1350.sem3.integration;

import src.se.kth.iv1350.sem3.DTOs.DiscountDTO;
import src.se.kth.iv1350.sem3.model.ItemInCart;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

/**
 * This class represents a simulated external discount database system.
 * It holds predefined discounts for certain items, as well as
 * flat discounts for customers and total purchases.
 */
public class DiscountDatabaseSystem {
    private final List<DiscountDTO> itemDiscounts = new ArrayList<>();

    /**
     * Creates a new instance of the <code>DiscountDatabaseSystem</code> and
     * preloads it with some discounts for specific item IDs.
     */
    public DiscountDatabaseSystem() {
        itemDiscounts.add(new DiscountDTO(1, 3.0)); // Apple
        itemDiscounts.add(new DiscountDTO(2, 1.5)); // Banana
        itemDiscounts.add(new DiscountDTO(3, 5.0)); // Orange
    }

    /**
     * Calculates the total discount for a list of items by summing individual
     * discounts.
     *
     * @param items List of items to calculate discounts for.
     * @return <code>BigDecimal</code> representing the total discount amount for
     *         all matching items.
     * @link ItemInCart
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
     * Returns a discount amount based on the total sale price.
     * In our case we use a flat discount for testing purposes.
     *
     * @param totalPrice <code>BigDecimal</code> total price of the sale before
     *                   discounts.
     * @return <code>BigDecimal</code> fixed discount amount.
     */
    public BigDecimal getDiscountFromTotal(BigDecimal totalPrice) {
        return BigDecimal.valueOf(5);
    }

    /**
     * Returns a discount amount based on a customer ID.
     * We are using a fixed amount for testing purposes.
     *
     * @param customerId <code>String</code> ID of the customer requesting the
     *                   discount.
     * @return <code>BigDecimal</code> fixed discount amount for the customer.
     */
    public BigDecimal getDiscountFromCustomerId(String customerId) {
        return BigDecimal.valueOf(5);
    }
}
