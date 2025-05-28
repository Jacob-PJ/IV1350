package src.se.kth.iv1350.sem3.model.DiscountMethods;

import java.util.List;
import src.se.kth.iv1350.sem3.DTOs.ItemDTO;
import java.math.BigDecimal;

import src.se.kth.iv1350.sem3.integration.DiscountDatabaseSystem;
import src.se.kth.iv1350.sem3.model.DiscountStrategy;
import src.se.kth.iv1350.sem3.model.ItemInCart;

/**
 * Strategy for applying discounts based on customer ID.
 */
public class CustomerBasedDiscount implements DiscountStrategy {
    private final DiscountDatabaseSystem db;

    public CustomerBasedDiscount(DiscountDatabaseSystem db) {
        this.db = db;
    }

    @Override
    public BigDecimal getDiscount(BigDecimal totalPrice, List<ItemInCart> items, String customerId) {
        BigDecimal discount = db.getDiscountFromCustomerId(customerId);
        return discount;
    }
}
