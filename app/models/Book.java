package models;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "w1698510_Book")
public class Book extends LibraryItem {

    private int w1698510_total_Pages;

    private String w1698510_bookAuthor;

    private String w1698510_bookPublisher;


    public String getW1698510_bookPublisher() {
        return w1698510_bookPublisher;
    }

    public void setW1698510_bookPublisher(String w1698510_bookPublisher) {
        this.w1698510_bookPublisher = w1698510_bookPublisher;
    }

    public int getW1698510_total_Pages() {
        return w1698510_total_Pages;
    }

    public void setW1698510_total_Pages(int w1698510_total_Pages) {
        this.w1698510_total_Pages = w1698510_total_Pages;
    }

    public String getW1698510_bookAuthor() {
        return w1698510_bookAuthor;
    }

    public void setW1698510_bookAuthor(String w1698510_bookAuthor) {
        this.w1698510_bookAuthor = w1698510_bookAuthor;
    }
}
