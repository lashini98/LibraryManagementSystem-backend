package DTO;

import models.util.DateTime;

public class BorrowNewItemDTO {

    private String isbn;

    private DateTime borrow_date;

    private DateTime return_date;

    private String userId;

    private String username;

    private String contactNo;

    private String userEmail;

    private boolean itemType;


    public boolean isItemType() {
        return itemType;
    }

    public void setItemType(boolean itemType) {
        this.itemType = itemType;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public DateTime getBorrow_date() {
        return borrow_date;
    }

    public void setBorrow_date(DateTime borrow_date) {
        this.borrow_date = borrow_date;
    }

    public DateTime getReturn_date() {
        return return_date;
    }

    public void setReturn_date(DateTime return_date) {
        this.return_date = return_date;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
