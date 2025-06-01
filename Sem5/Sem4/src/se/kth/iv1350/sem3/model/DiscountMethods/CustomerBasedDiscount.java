package src.se.kth.iv1350.sem3.model.DiscountMethods;

import java.util.List;
import java.math.BigDecimal;

import src.se.kth.iv1350.sem3.DTOs.ItemDTO;
import src.se.kth.iv1350.sem3.integration.DiscountDatabaseSystem;
import src.se.kth.iv1350.sem3.model.DiscountStrategy;
import src.se.kth.iv1350.sem3.model.ItemInCart;

/**
 * Implements a discount strategy that applies discounts based on customer ID.
 * Uses the <code>DiscountDatabaseSystem</code> to retrieve a fixed discount for
 * a given customer.
 */
public class CustomerBasedDiscount implements DiscountStrategy {
    private final DiscountDatabaseSystem db;

    /**
     * Creates an instance of the customer discount strategy using the
     * given database.
     *
     * @param db Discount database system that provides customer discount data.
     */
    public CustomerBasedDiscount(DiscountDatabaseSystem db) {
        this.db = db;
    }

    /**
     * Calculates the discount to apply based on the customer ID.
     *
     * @param totalPrice Total price of the sale before discount.
     * @param items      List of items involved in the sale.
     * @param customerId Identifier of the customer to determine discounts.
     * @return Discount amount to be subtracted from the total price as a
     *         <code>BigDecimal</code>.
     */
    @Override
    public BigDecimal getDiscount(BigDecimal totalPrice, List<ItemInCart> items, String customerId) {
        BigDecimal discount = db.getDiscountFromCustomerId(customerId);
        return discount;
    }
}
