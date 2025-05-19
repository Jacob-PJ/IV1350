package src.se.kth.iv1350.sem3.integration;

import src.se.kth.iv1350.sem3.DTOs.DiscountDTO;
import src.se.kth.iv1350.sem3.model.ItemInCart;
import src.se.kth.iv1350.sem3.DTOs.ItemDTO;

import java.util.ArrayList;
import java.util.List;

public class DiscountDatabaseSystem {
    private final List<DiscountDTO> itemDiscounts = new ArrayList<>();

    public DiscountDatabaseSystem() {
        itemDiscounts.add(new DiscountDTO(1, 3.0));
        itemDiscounts.add(new DiscountDTO(2, 1.5));
        itemDiscounts.add(new DiscountDTO(3, 5.0));
    }

    /**
     * Updates the discount amount for a specific item ID.
     *
     * @param itemID      The ID of the item to update.
     * @param newDiscount The new discount amount to set.
     * @return true if update was successful, false if item was not found.
     */
    public boolean updateItemDiscount(int itemID, double newDiscount) {
        for (DiscountDTO discount : itemDiscounts) {
            if (discount.getItemID() == itemID) {
                discount.setDiscountAmount(newDiscount);
                return true;
            }
        }
        return false;
    }

    public double getDiscountFromItems(List<ItemDTO> items) {
        double totalDiscount = 0;
        for (ItemDTO cartItem : items) {
            int itemId = cartItem.getID();
            for (DiscountDTO discount : itemDiscounts) {
                if (discount.getItemID() == itemId) {
                    totalDiscount += discount.getDiscountAmount();
                    break;
                }
            }
        }
        return totalDiscount;
    }

    public double getDiscountFromTotal(double totalPrice) {
        return 30;
    }

    public double getDiscountFromCustomerId(String customerId) {
        return 25;
    };

}
