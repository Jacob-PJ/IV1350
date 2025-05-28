package src.se.kth.iv1350.sem3.model;

import java.math.BigDecimal;

import java.util.List;
import src.se.kth.iv1350.sem3.DTOs.ItemDTO;

public interface DiscountStrategy {
    /**
     * Calculates discount for a sale.
     *
     * @param totalPrice The total price before discount.
     * @param items      List of items in the sale.
     * @param customerId The ID of the customer.
     * @return The discount amount to subtract.
     */
    BigDecimal getDiscount(BigDecimal totalPrice, List<ItemInCart> items, String customerId);
}
