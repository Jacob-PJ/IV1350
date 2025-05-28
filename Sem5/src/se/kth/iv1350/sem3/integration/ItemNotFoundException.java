package src.se.kth.iv1350.sem3.integration;

import src.se.kth.iv1350.sem3.DTOs.ItemDTO;

public class ItemNotFoundException extends Exception {
    private ItemDTO itemThatCannotBeFound;

    public ItemNotFoundException() {
        super("The Item that was searched for was not found");
    }

    public ItemNotFoundException(String errormsg) {
        super(errormsg);
    }

}