package src.se.kth.iv1350.sem3.controller;

import java.math.BigDecimal;
import java.util.List;

import src.se.kth.iv1350.sem3.DTOs.ItemDTO;
import src.se.kth.iv1350.sem3.integration.AccountDatabaseSystem;
import src.se.kth.iv1350.sem3.integration.DiscountDatabaseSystem;
import src.se.kth.iv1350.sem3.integration.InventoryDatabaseSystem;
import src.se.kth.iv1350.sem3.integration.Printer;
import src.se.kth.iv1350.sem3.model.ItemInCart;
import src.se.kth.iv1350.sem3.model.Messages;
import src.se.kth.iv1350.sem3.model.Receipt;
import src.se.kth.iv1350.sem3.model.Sale;
import src.se.kth.iv1350.sem3.integration.Display;

public class Controller {

    private InventoryDatabaseSystem inv;
    private DiscountDatabaseSystem discDB;
    private AccountDatabaseSystem acc;
    private final Printer printer;
    private final Messages messages;
    private final Display display;

    private Sale sale;
    private Receipt receipt;

    // constructor which initliazes the integration layer
    public Controller(InventoryDatabaseSystem inv, DiscountDatabaseSystem discDB, AccountDatabaseSystem acc) {
        this.inv = inv;
        this.discDB = discDB;
        this.acc = acc;

        this.printer = new Printer();
        this.messages = new Messages();
        display = new Display();
    }

    // starts a new sale and initializes the sale object, and prints a message to
    // the printer
    public void startSale() {
        sale = new Sale();
        receipt = new Receipt(sale);
        display.showMessage(messages.createStartSaleMessage());
    }

    // adds an item to the sale and prints a message to the printer
    public void addItem(int itemID, int quantity) {

        ItemDTO foundItem = inv.fetchItem(itemID);
        if (foundItem == null) {
            display.showMessage(messages.createItemNotFoundMessage(itemID));
            return;
        }
        ItemInCart item = new ItemInCart(foundItem, quantity);
        sale.addItem(item);

        display.showMessage(messages.createAddedItemMessage(item));
        display.showMessage(messages.createRunningCostMessage(sale));
    }

    // Asks the user for a payment and calcualtes changes
    public void makePayment(BigDecimal payment) {
        sale.makePayment(payment);
    }

    // ends the sale and prints the receipt to the printer
    public void endSale() {
        receipt.generateReciept();
        printer.printReceipt(receipt.getReceipt());
        sale = null;
    }

    public List<ItemInCart> getItemsInCurrentSale() {
        return sale.getItems();
    }

    public boolean isSaleActive() {
        return sale != null;
    }

    public BigDecimal getTotalPrice() {
        return sale.getTotalPriceOfSale();
    }

    public BigDecimal getPayment() {
        return sale.getPayment();
    }

    public BigDecimal getChange() {
        return sale.getChange();
    }

}
