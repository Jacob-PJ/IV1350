package src.se.kth.iv1350.sem3.model.DiscountMethods;

import java.util.List;
import java.math.BigDecimal;

import src.se.kth.iv1350.sem3.integration.DiscountDatabaseSystem;
import src.se.kth.iv1350.sem3.model.DiscountStrategy;
import src.se.kth.iv1350.sem3.model.ItemInCart;

/**
 * This class provides a discount strategy based on the total amount of a sale.
 * It uses the <code>DiscountDatabaseSystem</code> to determine the applicable
 * discount.
 */
public class TotalBasedDiscount implements DiscountStrategy {
    private final DiscountDatabaseSystem db;

    /**
     * Creates an instance of the <code>TotalBasedDiscount</code>.
     *
     * @param db Discount database to retrieve discounts from.
     */
    public TotalBasedDiscount(DiscountDatabaseSystem db) {
        this.db = db;
    }

    /**
     * Calculates a discount based on the total price of the sale.
     *
     * @param totalPrice Total price of the sale before discount.
     * @param items      Items in the sale.
     * @param customerId ID of the customer.
     * @return Discount amount to apply to the sale as a <code>BigDecimal</code>.
     */
    @Override
    public BigDecimal getDiscount(BigDecimal totalPrice, List<ItemInCart> items, String customerId) {
        BigDecimal discount = db.getDiscountFromTotal(totalPrice);
        return discount;
    }
}
