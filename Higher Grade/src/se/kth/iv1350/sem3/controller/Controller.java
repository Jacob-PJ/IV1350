package src.se.kth.iv1350.sem3.controller;

import java.math.BigDecimal;
import java.util.List;

import src.se.kth.iv1350.sem3.DTOs.ItemDTO;
import src.se.kth.iv1350.sem3.integration.AccountDatabaseSystem;
import src.se.kth.iv1350.sem3.integration.DiscountDatabaseSystem;
import src.se.kth.iv1350.sem3.integration.InventoryDatabaseSystem;
import src.se.kth.iv1350.sem3.integration.Printer;
import src.se.kth.iv1350.sem3.model.*;
import src.se.kth.iv1350.sem3.model.DiscountMethods.*;
import src.se.kth.iv1350.sem3.util.TotalRevenueFileOutput;
import src.se.kth.iv1350.sem3.view.TotalRevenueView;
import src.se.kth.iv1350.sem3.integration.DatabaseFailureException;
import src.se.kth.iv1350.sem3.integration.ItemNotFoundException;

/**
 * The controller coordinates actions between the view and model layers.
 * It handles the logic of a sale by communicating with model components and
 * passing necessary data between them.
 */
public class Controller {

    private InventoryDatabaseSystem inv;
    private DiscountDatabaseSystem discDB;
    private AccountDatabaseSystem acc;
    private final Printer printer;
    private final Messages messages;
    private LastMessage lastMessage;

    private Sale sale;
    private Receipt receipt;

    private TotalRevenueFileOutput totalRevenueFileOutput;

    /**
     * Creates a new instance and initializes the controller.
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
        this.lastMessage = new LastMessage();

        this.totalRevenueFileOutput = new TotalRevenueFileOutput();
    }

    /**
     * Starts a new sale and notifies observers.
     */
    public void startSale() {
        lastMessage.clearMessage();
        sale = new Sale();

        addRevenueObserver(totalRevenueFileOutput);

        receipt = new Receipt(sale);
        lastMessage.updateMessage(messages.createStartSaleMessage());
    }

    /**
     * Adds a certain amount of an item to the current sale.
     *
     * @param itemID   The identifier of the item to add.
     * @param quantity The number of units to add.
     * @throws ItemNotFoundException    If the specified item ID does not exist in
     *                                  the inventory.
     * @throws DatabaseFailureException If the inventory database cannot be
     *                                  accessed.
     */
    public void addItem(int itemID, int quantity) throws ItemNotFoundException, DatabaseFailureException {
        lastMessage.clearMessage();

        ItemDTO foundItem = inv.fetchItem(itemID);

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
        receipt.generateReceipt();
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
     * Registers the customer for discount. Applies three different discount
     * strategies.
     */
    public void registerCustomerForDiscount() {
        DiscountStrategy strategy = new CustomerBasedDiscount(discDB);
        BigDecimal currentDiscount;
        sale.setDiscountStrategy(strategy);
        currentDiscount = sale.addDiscount();
        lastMessage.updateMessage(messages.createShowCurrentDiscountMessage(currentDiscount));

        strategy = new ItemBasedDiscount(discDB);
        sale.setDiscountStrategy(strategy);
        currentDiscount = sale.addDiscount();
        lastMessage.updateMessage(messages.createShowCurrentDiscountMessage(currentDiscount));

        strategy = new TotalBasedDiscount(discDB);
        sale.setDiscountStrategy(strategy);
        currentDiscount = sale.addDiscount();
        lastMessage.updateMessage(messages.createShowCurrentDiscountMessage(currentDiscount));

        lastMessage.updateMessage(messages.createShowTotalDiscountMessage(sale.showCurrentTotalDiscount()));
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
     * Adds a revenue observer to the current sale.
     *
     * @param observer The {@link RevenueObserver} to be added.
     */
    public void addRevenueObserver(RevenueObserver observer) {
        sale.addRevenueObserver(observer);
    }
}
