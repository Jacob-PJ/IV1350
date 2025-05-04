package se.kth.iv1350.sem3.DTOs;

import java.util.ArrayList;
import java.util.List;

public class SaleDTO {
    private int saleID;
    private double totalCost;
    private List<ItemDTO> list = new ArrayList<>();// {[itemIdentifier,quantity]],[itemidentifier2, quantity],[]}
    private double payment;
    private double change;
    private double totalDiscount;
    private int length;

    /**
     * Constructor for a SaleDTO
     * 
     * @param saleID    the id of the current sale
     * @param totalCost total cost of our current items
     * @param list      a string containing all the scanned items
     */
    public SaleDTO(int saleID) {
        this.saleID = saleID;
        this.totalCost = 0;
        this.list = null;
        this.payment = 0;
        this.change = 0;
        this.totalDiscount = 0;
        this.length = 0;

    }

    /**
     * A method to update the total cost of our current sale
     * 
     * @param newTotalCost the value that the totalCost will become
     * 
     */
    public void updateTotalCost(int newTotalCost) {
        this.totalCost += newTotalCost;
    }

    public List<ItemDTO> fetchCurrentSalesItemList() {
        return list;
    }

    public double getTotalCost() {
        return this.totalCost;
    }

    public double getPayment() {
        return this.payment;
    }

    public double getChange() {
        return this.change;
    }

    public void updateChange() {
        this.change = this.payment - this.totalCost;
    }

    public void updatePayment(int payment) {
        this.payment = payment;
    }

    public int getSaleID() {
        return this.saleID;
    }

    public int getQuantityOfItem(int itemIdentifier) {
        for (ItemDTO items : list) {
            if (items.getItemIdentifier() == itemIdentifier) {
                return items.getQuantity();
            } else

                return 0;
        }
        return 0;
    }

    public void updateTotalDiscount(int[][] amount) {

        // define
    }

    public int listLength() {
        return length;
    }

    public void updateList(ItemDTO item, int itemIdentifier, int quantity) {
        for (ItemDTO items : list) {
            if (items.getItemIdentifier() == itemIdentifier) {
                items.setQuantity(items.getQuantity() + quantity); // Update quantity if item exists
                return;
            }
        }
        // If item does not exist, add a new ItemDTO to the list
        list.add(item);
        length = list.size();
    }
}
