package models.util;

public class DateTime {

    private int day;

    private int month;

    private int year;

    private int hrs;

    private int mins;

    public DateTime(int day, int month, int year, int hrs, int mins) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.hrs = hrs;
        this.mins = mins;
    }

    public DateTime(){

    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getHrs() {
        return hrs;
    }

    public void setHrs(int hrs) {
        this.hrs = hrs;
    }

    public int getMins() {
        return mins;
    }

    public void setMins(int mins) {
        this.mins = mins;
    }
}
