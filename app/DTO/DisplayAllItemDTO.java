package DTO;

public class DisplayAllItemDTO {

    private String isbn;

    private String itemTitle;

    private String itemType;

    public DisplayAllItemDTO(String isbn, String itemTitle, String itemType) {
        this.isbn = isbn;
        this.itemTitle = itemTitle;
        this.itemType = itemType;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }
}
