package models;

import javax.persistence.*;


@MappedSuperclass
public abstract class LibraryItem {

    @Id
    private String w1698510_isbn;

    private String w1698510_title;

    private String w1698510_sector;

    private String w1698510_publication_Date;


    public String getW1698510_isbn() {
        return w1698510_isbn;
    }

    public void setW1698510_isbn(String w1698510_isbn) {
        this.w1698510_isbn = w1698510_isbn;
    }

    public String getW1698510_title() {
        return w1698510_title;
    }

    public void setW1698510_title(String w1698510_title) {
        this.w1698510_title = w1698510_title;
    }

    public String getW1698510_sector() {
        return w1698510_sector;
    }

    public void setW1698510_sector(String w1698510_sector) {
        this.w1698510_sector = w1698510_sector;
    }

    public String getW1698510_publication_Date() {
        return w1698510_publication_Date;
    }

    public void setW1698510_publication_Date(String w1698510_publication_Date) {
        this.w1698510_publication_Date = w1698510_publication_Date;
    }
}
