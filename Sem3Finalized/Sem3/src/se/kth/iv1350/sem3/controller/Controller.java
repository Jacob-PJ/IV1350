package se.kth.iv1350.sem3.controller;

import se.kth.iv1350.sem3.DTOs.ItemDTO;
import se.kth.iv1350.sem3.DTOs.SaleDTO;
import se.kth.iv1350.sem3.integration.AccountDatabaseSystem;
import se.kth.iv1350.sem3.integration.DiscountDatabaseSystem;
import se.kth.iv1350.sem3.integration.InventoryDatabaseSystem;
import se.kth.iv1350.sem3.integration.Printer;
import se.kth.iv1350.sem3.model.Receipt;
import se.kth.iv1350.sem3.model.Sale;
import se.kth.iv1350.sem3.DTOs.ItemDTO;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private Sale currentSale;
    private InventoryDatabaseSystem inv;
    private DiscountDatabaseSystem discDB;
    private AccountDatabaseSystem acc;
    private Printer printer;

    public Controller() {
        printer = new Printer();
        inv = new InventoryDatabaseSystem();
        acc = new AccountDatabaseSystem();

    }

    public void startSale() {
        currentSale = new Sale(acc.getNewSaleID());
    }

    public void registercustomerForDiscount(String customerIdentifier) {

        List<ItemDTO> list = currentSale.fetchCurrentSalesItemList();
        int[][] listOfDiscoutns = discDB.fetchDiscount(customerIdentifier, list);
        currentSale.addDiscount(listOfDiscoutns);
    }

    public void payment(int payment) {
        currentSale.updatePayment(payment);
        currentSale.calculateChange();
    }

    public void endSale() {
        currentSale.endSale();// Reminder for myself no need to create a new one just
        inv.reduceStock(currentSale.fetchCurrentSalesItemList()); // communicate with VAT and update the prices
        Receipt receipt = new Receipt(currentSale);
        printer.Print(receipt);
        acc.incrementAmountOfSales();

    }

    public void enterItemIdentifier(int itemIdentifier, int quantity) {
        boolean itemInvStatus = inv.getItemInvStatus(itemIdentifier);
        ItemDTO item = inv.fetchItem(itemIdentifier, itemInvStatus);
        currentSale.updateList(item, itemIdentifier, quantity);
    }

    public Sale getCurrentSale() {
        return currentSale;
    }

}
