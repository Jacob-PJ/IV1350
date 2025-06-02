package src.se.kth.iv1350.sem3.view;

import java.math.BigDecimal;

import src.se.kth.iv1350.sem3.controller.Controller;

/**
 * Class that represents the user interface of the application.
 * It simulates user actions and interacts with the controller to perform sales.
 */
public class View {

    private Controller contr;
    private Display display;

    /**
     * Creates a new instance of <code>View</code>.
     * Connects the view to the controller and initializes the display.
     *
     * @param contr The <code>Controller</code> to use for handling actions.
     */
    public View(Controller contr) {
        this.contr = contr;
        this.display = new Display();
    }

    /**
     * Simulates a complete sale process.
     * Starts a new sale, adds several items, processes payment, and ends the sale.
     * Displays system messages after each step.
     */
    public void exampleSale() {
        contr.startSale();
        display.showMessage(contr.getMessage());

        contr.addItem(1, 2);
        display.showMessage(contr.getMessage());

        contr.addItem(2, 1);
        display.showMessage(contr.getMessage());

        contr.addItem(3, 1);
        display.showMessage(contr.getMessage());

        contr.addItem(3, 1);
        display.showMessage(contr.getMessage());

        contr.addItem(5, 1);
        display.showMessage(contr.getMessage());

        contr.makePayment(BigDecimal.valueOf(100));
        contr.endSale();
    }
}
