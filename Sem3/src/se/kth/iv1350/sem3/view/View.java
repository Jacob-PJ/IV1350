package src.se.kth.iv1350.sem3.view;

import java.math.BigDecimal;

import src.se.kth.iv1350.sem3.controller.Controller;
import src.se.kth.iv1350.sem3.view.Display;

public class View {

    private Controller contr;

    private Display display;

    // Constructor for the View class, which takes a Controller object as a
    // parameter to allow interaction with the system.
    public View(Controller contr) {
        this.contr = contr;
        this.display = new Display();
    }

    // This method simulates a sale by starting a sale, adding items to it, making a
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
