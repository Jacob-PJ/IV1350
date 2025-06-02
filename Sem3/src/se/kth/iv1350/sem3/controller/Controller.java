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
import src.se.kth.iv1350.sem3.model.LastMessage;

/**
 * The <code>Controller</code> coordinates actions between the view and model
 * layers.
 * It handles the logic of a sale by communicating with model components and
 * passing necessary data between them.
 */
public class Controller {

    private InventoryDatabaseSystem inv;
    private DiscountDatabaseSystem discDB;
    private AccountDatabaseSystem acc;
    private final Printer printer;
    private final Messages messages;

    private Sale sale;
    private Receipt receipt;

    private LastMessage lastMessage;

    /**
     * Creates a new instance and initializes the controller with the necessary
     * external systems.
     *
     * @param inv    The {@link InventoryDatabaseSystem}.
     * @param discDB The {@link DiscountDatabaseSystem}.
     * @param acc    The {@link AccountDatabaseSystem}.
     */
    public Controller(InventoryDatabaseSystem inv, DiscountDatabaseSystem discDB, AccountDatabaseSystem acc) {
        this.inv = inv;
        this.discDB = discDB;
        this.acc = acc;

        this.printer = new Printer();
        this.messages = new Messages();
        lastMessage = new LastMessage();
    }

    /**
     * Starts a new sale and initializes the necessary components.
     */
    public void startSale() {
        sale = new Sale();
        receipt = new Receipt(sale);
        lastMessage.updateMessage(messages.createStartSaleMessage());
    }

    /**
     * Adds an item to the current sale based on its ID and quantity.
     *
     * @param itemID   The identifier of the item to add.
     * @param quantity The number of units to add.
     */
    public void addItem(int itemID, int quantity) {
        ItemDTO foundItem = inv.fetchItem(itemID);
        if (foundItem == null) {
            lastMessage.updateMessage(messages.createItemNotFoundMessage(itemID));
            return;
        }
        ItemInCart item = new ItemInCart(foundItem, quantity);
        sale.addItem(item);

        lastMessage.updateMessage(messages.createAddedItemMessage(item));
        lastMessage.updateMessage(messages.createRunningCostMessage(sale));
    }

    /**
     * Makes payment and calculates change for the current sale.
     *
     * @param payment The amount paid by the customer.
     */
    public void makePayment(BigDecimal payment) {
        sale.makePayment(payment);
    }

    /**
     * Ends the current sale and prints the receipt.
     */
    public void endSale() {
        receipt.generateReciept();
        printer.printReceipt(receipt.getReceipt());
        sale = null;
    }

    /**
     * Checks if a sale is currently in progress.
     *
     * @return <code>true</code> if a sale is active, otherwise <code>false</code>.
     */
    public boolean isSaleActive() {
        return sale != null;
    }

    /**
     * Gets the total price of the current sale.
     *
     * @return The total price as a {@link BigDecimal}.
     */
    public BigDecimal getTotalPrice() {
        return sale.getTotalPriceOfSale();
    }

    /**
     * Gets the payment made for the current sale.
     *
     * @return The payment amount as a {@link BigDecimal}.
     */
    public BigDecimal getPayment() {
        return sale.getPayment();
    }

    /**
     * Gets the change to be returned.
     *
     * @return The calculated change as a {@link BigDecimal}.
     */
    public BigDecimal getChange() {
        return sale.getChange();
    }

    /**
     * Gets the latest message generated during the current transaction.
     *
     * @return The message string to be displayed.
     */
    public String getMessage() {
        return lastMessage.getMessage();
    }

    /**
     * Gets the list of items currently added to the sale.
     * This method could be sligthly problematic if called by the view, and is only
     * used for unit testing. The lsit that is returned is also not changable.
     *
     * @return List of {@link ItemInCart} representing items in the current sale.
     */
    public List<ItemInCart> getItemsInCurrentSale() {
        return sale.getItems();
    }
}
