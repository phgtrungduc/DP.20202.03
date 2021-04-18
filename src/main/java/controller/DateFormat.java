package controller;

import java.util.Calendar;

public class DateFormat {
    private int month;
    private int year;

    public DateFormat(int month, int year) {
        this.month = month;
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public boolean isInvalidDate(){
        boolean isInvalidMonth = this.month < 1 || this.month > 12;
        boolean isInvalidYear = this.year < Calendar.getInstance().get(Calendar.YEAR) % 100 || this.year > 100;
        return isInvalidMonth || isInvalidYear;
    }

    public String getExpirationDate(){
        return String.valueOf(this.month + this.year);
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
}
