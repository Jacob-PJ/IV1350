package src.se.kth.iv1350.sem3.model.DiscountMethods;

import java.util.List;
import src.se.kth.iv1350.sem3.DTOs.ItemDTO;

import src.se.kth.iv1350.sem3.integration.DiscountDatabaseSystem;
import src.se.kth.iv1350.sem3.model.DiscountStrategy;

/**
 * Strategy for applying item-based discounts.
 */
public class ItemBasedDiscount implements DiscountStrategy {
    private final DiscountDatabaseSystem db;

    public ItemBasedDiscount(DiscountDatabaseSystem db) {
        this.db = db;
    }

    @Override
    public double getDiscount(double totalPrice, List<ItemDTO> items, String customerId) {
        return db.getDiscountFromItems(items);
    }
}
