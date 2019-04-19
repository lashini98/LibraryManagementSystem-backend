package DTO;

public class DeleteItemsDTO {

    private int slotCount;

    private String itemType;

    public DeleteItemsDTO(int slotCount, String itemType) {
        this.slotCount = slotCount;
        this.itemType = itemType;
    }

    public int getSlotCount() {
        return slotCount;
    }

    public void setSlotCount(int slotCount) {
        this.slotCount = slotCount;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }
}
