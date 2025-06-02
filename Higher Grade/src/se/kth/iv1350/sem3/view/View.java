package src.se.kth.iv1350.sem3.view;

import java.math.BigDecimal;

import src.se.kth.iv1350.sem3.controller.Controller;
import src.se.kth.iv1350.sem3.integration.DatabaseFailureException;
import src.se.kth.iv1350.sem3.integration.ItemNotFoundException;

import src.se.kth.iv1350.sem3.util.ErrorLogger;

/**
 * Class that represents the user interface of the application.
 * It simulates user actions and interacts with the controller to perform sales.
 */
public class View {

    private Controller contr;

    private TotalRevenueView totalRevenueView;

    private ErrorLogger errorLogger;

    private ErrorMessages errorMessage;

    Display display;

    /**
     * Creates a new instance of <code>View</code>.
     * Connects the view to the controller and initializes the display.
     *
     * @param contr The {@link Controller} to use for handling actions.
     */
    public View(Controller contr) {
        this.contr = contr;
        display = Display.getInstance();
        errorLogger = new ErrorLogger();
        totalRevenueView = new TotalRevenueView();
        errorMessage = new ErrorMessages();
    }

    /**
     * Simulates a complete sale process.
     * Runs through two example sales and displays messages for each step.
     */
    public void exampleSale() {

        // sale 1
        contr.startSale();
        contr.addRevenueObserver(totalRevenueView);
        display.showMessage(contr.getMessage());
        tryAddItem(1, 2);
        tryAddItem(2, 1);
        tryAddItem(3, 1);
        tryAddItem(3, 1);

        tryAddItem(-1, 1);

        tryAddItem(5, 1);

        contr.registerCustomerForDiscount();
        display.showMessage(contr.getMessage());
        contr.makePayment(BigDecimal.valueOf(100));
        contr.endSale();

        // sale 2
        contr.startSale();
        contr.addRevenueObserver(totalRevenueView);
        display.showMessage(contr.getMessage());

        tryAddItem(1, 2);
        tryAddItem(2, 1);
        tryAddItem(3, 1);
        tryAddItem(3, 1);

        tryAddItem(-1, 1);

        tryAddItem(5, 1);

        contr.registerCustomerForDiscount();
        display.showMessage(contr.getMessage());
        contr.makePayment(BigDecimal.valueOf(100));
        contr.endSale();
    }

    /**
     * Attempts to add an item to the sale.
     * If the item is found, it adds it and displays a success message.
     * If the item is not found or if there is a database failure, it logs the error
     * and displays an error message.
     *
     * @param itemID   The ID of the item to add.
     * @param quantity The quantity of the item to add.
     * @throws DatabaseFailureException If there is a failure accessing the
     *                                  database.
     * @throws ItemNotFoundException    If the item is not found in the database.
     */
    private void tryAddItem(int itemID, int quantity) {
        try {
            contr.addItem(itemID, quantity);
            display.showMessage(contr.getMessage());
        } catch (DatabaseFailureException dfe) {
            errorLogger.log(errorMessage.createDatabaseFailureMessage());
            display.showMessage(dfe.getDevMessage());
        } catch (ItemNotFoundException infe) {
            errorLogger.log(infe.getDevMessage());
            display.showMessage(errorMessage.createItemNotFoundMessage(itemID));
        }
    }

}
