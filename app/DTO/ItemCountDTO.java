package DTO;

public class ItemCountDTO {

    private int bookCount;

    private int dvdCount;

    public ItemCountDTO(int bookCount, int dvdCount) {
        this.bookCount = bookCount;
        this.dvdCount = dvdCount;
    }

    public int getBookCount() {
        return bookCount;
    }

    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }

    public int getDvdCount() {
        return dvdCount;
    }

    public void setDvdCount(int dvdCount) {
        this.dvdCount = dvdCount;
    }




}
