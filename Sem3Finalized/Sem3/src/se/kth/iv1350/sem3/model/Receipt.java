package se.kth.iv1350.sem3.model;

import se.kth.iv1350.sem3.DTOs.SaleDTO;
import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.sem3.DTOs.ItemDTO;

public class Receipt {
    private double totalCost;
    // private double totalVAT;
    private List<ItemDTO> list;
    private int saleID;
    private double amountPaid;
    private double change;

    /**
     * Generates a Receipt
     * 
     * @param currentSale   contains information of the sale we are handling its
     *                      receipt
     * @param moneyReceived contains the amount the customer paid
     * @param change        contains the amount the cashier needs to pay
     */

    public Receipt(Sale currentSale) {
        this.totalCost = currentSale.getSaleInfo().getTotalCost();
        // this.totalVAT=currentSale.getTotalVAT();
        this.list = currentSale.fetchCurrentSalesItemList();
        this.saleID = currentSale.getSaleInfo().getSaleID();
        this.amountPaid = currentSale.getSaleInfo().getPayment();
        this.change = currentSale.getSaleInfo().getChange();

    }

    public void makeReceipt() {
        System.out.println("Receipt for sale ID: " + this.saleID);
        System.out.println("Here are the items that you have bought!");
        System.out.println(this.list.toString());
        System.out.println("The total cost of the items is: " + this.totalCost);
        System.out.println("The amount you have paid is: " + this.amountPaid);
        System.out.println("The change you will get is: " + this.change);

    }

}
