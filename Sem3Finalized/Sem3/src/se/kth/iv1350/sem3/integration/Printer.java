package se.kth.iv1350.sem3.integration;

import se.kth.iv1350.sem3.model.Receipt;

public class Printer {
     public Printer() {
     }

     /**
      * Printing the receipt in console output
      * 
      * @param receipt the receipt of the sale
      */
     public void Print(Receipt receipt) {
          receipt.makeReceipt();
     }
}
