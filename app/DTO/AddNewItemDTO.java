package DTO;

import models.Book;
import models.DVD;

public class AddNewItemDTO {

    private Book book;

    private DVD dvd;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public DVD getDvd() {
        return dvd;
    }

    public void setDvd(DVD dvd) {
        this.dvd = dvd;
    }
}
