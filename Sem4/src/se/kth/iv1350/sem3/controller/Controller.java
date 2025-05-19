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
import src.se.kth.iv1350.sem3.model.lastMessage;
import src.se.kth.iv1350.sem3.model.Receipt;
import src.se.kth.iv1350.sem3.model.Sale;
import src.se.kth.iv1350.sem3.util.ErrorLogger;
import src.se.kth.iv1350.sem3.util.TotalRevenueFileOutput;
import src.se.kth.iv1350.sem3.view.TotalRevenueView;
import src.se.kth.iv1350.sem3.integration.DatabaseFailureException;
import src.se.kth.iv1350.sem3.integration.ItemNotFoundException;

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

    // constructor which initliazes the integration layer
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

    // starts a new sale and initializes the sale object, and prints a message to
    // the printer
    public void startSale() {
        lastMessage.clearMessage();
        sale = new Sale();
        sale.addRevenueObserver(totalRevenueFileOutput);
        sale.addRevenueObserver(totalRevenueView);

        receipt = new Receipt(sale);
        lastMessage.updateMessage(messages.createStartSaleMessage());
    }

    // adds an item to the sale and prints a message to the printer
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

    public String getMessage() {
        return lastMessage.getMessage();
    }
}
