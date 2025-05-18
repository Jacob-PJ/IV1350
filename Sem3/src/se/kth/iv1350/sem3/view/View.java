package src.se.kth.iv1350.sem3.view;

import java.math.BigDecimal;

import src.se.kth.iv1350.sem3.controller.Controller;

public class View {

    private Controller contr;

    // Constructor for the View class, which takes a Controller object as a
    // parameter to allow interaction with the system.
    public View(Controller contr) {
        this.contr = contr;
    }

    // This method simulates a sale by starting a sale, adding items to it, making a
    public void exampleSale() {
        contr.startSale();
        contr.addItem(1, 2);
        contr.addItem(2, 1);
        contr.addItem(3, 1);
        contr.addItem(3, 1);

        contr.addItem(5, 1);

        contr.makePayment(BigDecimal.valueOf(100));
        contr.endSale();
    }

}
