package se.kth.iv1350.sem3.integration;

import java.util.List;

import se.kth.iv1350.sem3.DTOs.ItemDTO;
import se.kth.iv1350.sem3.DTOs.ItemDiscountDTO;

public class DiscountDatabaseSystem {

    ItemDiscountDTO[] itemDiscounts = new ItemDiscountDTO[100];

    public DiscountDatabaseSystem() {

    }

    public int[][] fetchDiscount(String customerIdentifier, List<ItemDTO> list) {
        int[][] listOfDiscounts = new int[list.size()][2]; // Use list.size() for the number of items

        for (int i = 0; i < list.size(); i++) {
            ItemDTO item = list.get(i); // Get the current ItemDTO from the list
            for (int j = 0; j < itemDiscounts.length; j++) {
                if (itemDiscounts[j] != null && item.getItemIdentifier() == itemDiscounts[j].getItemId()) {
                    listOfDiscounts[i][0] = itemDiscounts[j].getItemId();
                    listOfDiscounts[i][1] = itemDiscounts[j].getDiscountAmount();
                }
            }
        }

        // Add other conditions for discounts if needed

        return listOfDiscounts;
    }
}
