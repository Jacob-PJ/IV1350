package se.kth.iv1350.sem3.model;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.sem3.DTOs.SaleDTO;
import se.kth.iv1350.sem3.DTOs.ItemDTO;

public class Sale {
    private SaleDTO currentSale;
    private int saleID;
    LocalDateTime timeOfSale;
    private int finalizedSale;

    public Sale(int saleID) {
        setTimeOfSale();
        Random random = new Random();
        this.saleID = saleID;
        this.currentSale = new SaleDTO(this.saleID);
        // Receipt reciept = new Receipt(currentSale, saleID, saleID);
        this.finalizedSale = 0;
    }

    private void setTimeOfSale() {
        timeOfSale = LocalDateTime.now();
    }

    public void updateTotalcost(int amount) {
        currentSale.updateTotalCost(amount);
    }

    public SaleDTO getSaleInfo() {
        return this.currentSale;
    }

    /**
     * A method to update the total cost of our current sale
     * 
     * @param newTotalCost the value that the totalCost will become
     * 
     */

    public void calculateChange() {
        currentSale.updateChange();
    }

    public void updatePayment(int payment) {
        currentSale.updatePayment(payment);
    }

    public void endSale() {
        this.finalizedSale = 1;
    }

    public void addDiscount(int[][] listOfDiscounts) {
        currentSale.updateTotalDiscount(listOfDiscounts);

        for (int i = 0; i < listOfDiscounts.length; i++) {
            int itemIdentifier = listOfDiscounts[i][0];

            for (ItemDTO item : currentSale.fetchCurrentSalesItemList()) {
                if (item.getItemIdentifier() == itemIdentifier) {
                    int quantity = item.getQuantity();
                    currentSale.updateTotalCost(quantity * listOfDiscounts[i][1]);
                }
            }
        }
    }

    public List<ItemDTO> fetchCurrentSalesItemList() {
        return currentSale.fetchCurrentSalesItemList();
    }

    public void updateList(ItemDTO item, int itemIdentifier, int quantity) {
        currentSale.updateList(item, itemIdentifier, quantity);
    }

    public LocalDateTime getTimeOfSale() {
        return timeOfSale;
    }

    public int getSaleID() {
        return saleID;
    }
}
