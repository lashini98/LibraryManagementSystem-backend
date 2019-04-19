package models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "w1698510_itemsBorrowed")
public class ItemsBorrowed extends Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long w1698510_borrowId;

    @NotNull
    private String w1698510_borrow_Date;

    @NotNull
    private String w1698510_return_Date;

    @NotNull
    private String w1698510_isbn;

    @NotNull
    private boolean w1698510_itemType;

    @NotNull
    private boolean w1698510_isReturned;

    private String w1698510_itemAmount;

    public ItemsBorrowed(String uid, String name, String phoneNumber, String email, String w1698510_borrow_Date, String w1698510_return_Date, String w1698510_isbn, boolean w1698510_itemType, boolean w1698510_isReturned, String w1698510_itemAmount) {
        super(uid, name, phoneNumber, email);
        this.w1698510_borrow_Date = w1698510_borrow_Date;
        this.w1698510_return_Date = w1698510_return_Date;
        this.w1698510_isbn = w1698510_isbn;
        this.w1698510_itemType = w1698510_itemType;
        this.w1698510_isReturned = w1698510_isReturned;
        this.w1698510_itemAmount = w1698510_itemAmount;
    }

    public String getW1698510_itemAmount() {
        return w1698510_itemAmount;
    }

    public void setW1698510_itemAmount(String w1698510_itemAmount) {
        this.w1698510_itemAmount = w1698510_itemAmount;
    }

    public boolean isW1698510_isReturned() {
        return w1698510_isReturned;
    }

    public void setW1698510_isReturned(boolean w1698510_isReturned) {
        this.w1698510_isReturned = w1698510_isReturned;
    }

    public boolean isW1698510_itemType() {
        return w1698510_itemType;
    }

    public void setW1698510_itemType(boolean w1698510_itemType) {
        this.w1698510_itemType = w1698510_itemType;
    }

    public String getW1698510_isbn() {
        return w1698510_isbn;
    }

    public void setW1698510_isbn(String w1698510_isbn) {
        this.w1698510_isbn = w1698510_isbn;
    }

    public long getW1698510_borrowId() {
        return w1698510_borrowId;
    }

    public void setW1698510_borrowId(long w1698510_borrowId) {
        this.w1698510_borrowId = w1698510_borrowId;
    }

    public String getW1698510_borrow_Date() {
        return w1698510_borrow_Date;
    }

    public void setW1698510_borrow_Date(String w1698510_borrow_Date) {
        this.w1698510_borrow_Date = w1698510_borrow_Date;
    }

    public String getW1698510_return_Date() {
        return w1698510_return_Date;
    }

    public void setW1698510_return_Date(String w1698510_return_Date) {
        this.w1698510_return_Date = w1698510_return_Date;
    }
}
