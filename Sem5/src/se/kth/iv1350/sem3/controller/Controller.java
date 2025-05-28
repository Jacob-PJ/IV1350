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
import src.se.kth.iv1350.sem3.util.ErrorLogger;
import src.se.kth.iv1350.sem3.util.TotalRevenueFileOutput;
import src.se.kth.iv1350.sem3.view.TotalRevenueView;
import src.se.kth.iv1350.sem3.integration.DatabaseFailureException;
import src.se.kth.iv1350.sem3.integration.ItemNotFoundException;

/**
 * The controller coordinates actions between the view and model layers
 */
public class Controller {

    private InventoryDatabaseSystem inv;
    private DiscountDatabaseSystem discDB;
    private AccountDatabaseSystem acc;
    private final Printer printer;
    private final Messages messages;
    private lastMessage lastMessage;
    private ErrorLogger logger;

    private Sale sale;
    private Receipt receipt;

    private TotalRevenueFileOutput totalRevenueFileOutput;
    private TotalRevenueView totalRevenueView;

    /**
     * Creates a new instance of and initilzies the Controller
     *
     * @param inv    inventory database
     * @param discDB discount database
     * @param acc    accounting system
     */
    public Controller(InventoryDatabaseSystem inv, DiscountDatabaseSystem discDB, AccountDatabaseSystem acc) {
        this.inv = inv;
        this.discDB = discDB;
        this.acc = acc;

        this.printer = new Printer();
        this.messages = new Messages();
        this.lastMessage = new lastMessage();
        this.logger = new ErrorLogger();

        this.totalRevenueFileOutput = new TotalRevenueFileOutput();
        this.totalRevenueView = new TotalRevenueView();
    }

    /**
     * Starts a new sale and notifies observers.
     */
    public void startSale() {
        lastMessage.clearMessage();
        sale = new Sale();
        sale.addRevenueObserver(totalRevenueFileOutput);
        sale.addRevenueObserver(totalRevenueView);

        receipt = new Receipt(sale);
        lastMessage.updateMessage(messages.createStartSaleMessage());
    }

    /**
     * Adds a certain amount of an item to the current sale
     *
     * @param itemID   identifier of the item
     * @param quantity quantity to add
     */
    public void addItem(int itemID, int quantity) {
        lastMessage.clearMessage();
        try {
            ItemDTO foundItem = inv.fetchItem(itemID);
            if (foundItem == null) {
                lastMessage.updateMessage(messages.createItemNotFoundMessage(itemID));
                return;
            }
            ItemInCart item = new ItemInCart(foundItem, quantity);
            sale.addItem(item);

            lastMessage.updateMessage(messages.createAddedItemMessage(item));
            lastMessage.updateMessage(messages.createRunningCostMessage(sale));

        } catch (DatabaseFailureException dfe) {
            logger.log(dfe.getMessage());
            lastMessage.updateMessage(messages.createDatabaseFailureMessage("Inventory"));
        } catch (ItemNotFoundException infe) {
            logger.log(infe.getMessage());
            lastMessage.updateMessage(messages.createItemNotFoundMessage(itemID));
        }
    }

    /**
     * Makes payment and calculates change for the current sale
     *
     * @param payment amount paid by the customer
     */
    public void makePayment(BigDecimal payment) {
        sale.makePayment(payment);
    }

    /**
     * Ends the current sale and prints the receipt
     */
    public void endSale() {
        receipt.generateReciept();
        printer.printReceipt(receipt.getReceipt());
        sale = null;
    }

    /**
     * Gets the list of items in the current sale
     *
     * @return List of ItemInCart objects
     */
    public List<ItemInCart> getItemsInCurrentSale() {
        return sale.getItems();
    }

    /**
     * Checks if a sale is currently in progress
     *
     * @return true if a sale is active, otherwise false
     */
    public boolean isSaleActive() {
        return sale != null;
    }

    /**
     * Gets the total price of the current sale
     *
     * @return The total price
     */
    public BigDecimal getTotalPrice() {
        return sale.getTotalPriceOfSale();
    }

    /**
     * Registers the customerfor discount, we use the 3 methods
     */
    public void registerCustomerForDiscount() {

        DiscountStrategy strategy = new CustomerBasedDiscount(discDB);
        sale.setDiscountStrategy(strategy);
        sale.addDiscount();

        strategy = new ItemBasedDiscount(discDB);
        sale.setDiscountStrategy(strategy);
        sale.addDiscount();

        strategy = new TotalBasedDiscount(discDB);
        sale.setDiscountStrategy(strategy);
        sale.addDiscount();
    }

    /**
     * Gets the payment made for the current sale
     *
     * @return amount paid
     */
    public BigDecimal getPayment() {
        return sale.getPayment();
    }

    /**
     * Gets the change to be returned
     *
     * @return calculated change
     */
    public BigDecimal getChange() {
        return sale.getChange();
    }

    /**
     * Gets the latest message generated
     *
     * @return message string to be displayed
     */
    public String getMessage() {
        return lastMessage.getMessage();
    }
}
