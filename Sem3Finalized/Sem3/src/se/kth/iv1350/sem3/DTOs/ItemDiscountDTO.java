package se.kth.iv1350.sem3.DTOs;

public class ItemDiscountDTO {

    ItemDTO itemDTO;
    private int discountAmount;

    public ItemDiscountDTO(ItemDTO itemDTO, int discountAmount) {
        this.itemDTO = itemDTO;
        this.discountAmount = discountAmount;
    }

    public int getItemId() {
        return itemDTO.getItemIdentifier();
    }

    public int getDiscountAmount() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDiscountAmount'");
    }

}
