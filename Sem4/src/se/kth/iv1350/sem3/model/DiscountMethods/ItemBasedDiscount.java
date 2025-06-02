package src.se.kth.iv1350.sem3.model.DiscountMethods;

import java.util.List;
import java.math.BigDecimal;

import src.se.kth.iv1350.sem3.integration.DiscountDatabaseSystem;
import src.se.kth.iv1350.sem3.model.DiscountStrategy;
import src.se.kth.iv1350.sem3.model.ItemInCart;

/**
 * Implements discounts based on the items in the sale.
 * Uses the <code>DiscountDatabaseSystem</code> to determine item-specific
 * discounts.
 */
public class ItemBasedDiscount implements DiscountStrategy {
    private final DiscountDatabaseSystem db;

    /**
     * Creates an instance of the item based discount strategy using a discount
     * database.
     *
     * @param db Discount database system containing discount information for items.
     */
    public ItemBasedDiscount(DiscountDatabaseSystem db) {
        this.db = db;
    }

    /**
     * Calculates the discount to apply based on the items in the sale.
     *
     * @param totalPrice Total price of the sale before any discounts.
     * @param items      List of items in the current sale.
     * @param customerId The customer's identifier.
     * @return Total discount amount applicable based on the items as a
     *         <code>BigDecimal</code>.
     */
    @Override
    public BigDecimal getDiscount(BigDecimal totalPrice, List<ItemInCart> items, String customerId) {
        return db.getDiscountFromItems(items);
    }
}
