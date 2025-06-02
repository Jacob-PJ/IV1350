package src.se.kth.iv1350.sem3.model;

import java.math.BigDecimal;
import java.util.List;

/**
 * Interface for defining different discount strategies in the sale process.
 */
public interface DiscountStrategy {
    /**
     * Calculates the discount for a sale.
     *
     * @param totalPrice Total price of the sale before discount as a
     *                   <code>BigDecimal</code>.
     * @param items      List of items included in the sale as a <code>List</code>
     *                   of {@link ItemInCart}.
     * @param customerId ID of the customer as a <code>String</code>.
     * @return Discount amount to subtract from the total price as a
     *         <code>BigDecimal</code>.
     */
    BigDecimal getDiscount(BigDecimal totalPrice, List<ItemInCart> items, String customerId);
}
