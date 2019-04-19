package models;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Reader {

    private String w1698510_userId;

    private String w1698510_userName;

    private String w1698510_contactNo;

    private String w1698510_userEmail;

    public Reader(String w1698510_userId, String w1698510_userName, String w1698510_contactNo, String w1698510_userEmail) {
        this.w1698510_userId = w1698510_userId;
        this.w1698510_userName = w1698510_userName;
        this.w1698510_contactNo = w1698510_contactNo;
        this.w1698510_userEmail = w1698510_userEmail;
    }

    public String getW1698510_userEmail() {
        return w1698510_userEmail;
    }

    public void setW1698510_userEmail(String w1698510_userEmail) {
        this.w1698510_userEmail = w1698510_userEmail;
    }

    public String getW1698510_userId() {
        return w1698510_userId;
    }

    public void setW1698510_userId(String w1698510_userId) {
        this.w1698510_userId = w1698510_userId;
    }

    public String getW1698510_userName() {
        return w1698510_userName;
    }

    public void setW1698510_userName(String w1698510_userName) {
        this.w1698510_userName = w1698510_userName;
    }

    public String getW1698510_contactNo() {
        return w1698510_contactNo;
    }

    public void setW1698510_contactNo(String w1698510_contactNo) {
        this.w1698510_contactNo = w1698510_contactNo;
    }
}
