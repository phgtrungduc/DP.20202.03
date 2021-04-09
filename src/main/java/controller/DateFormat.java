package controller;

import common.exception.InvalidCardException;

import java.util.Calendar;

public class DateFormat {
    private int month;
    private int year;

    public boolean isValidDate() {
        return month < 1 || month > 12 || year < Calendar.getInstance().get(Calendar.YEAR) % 100 || year > 100;
    }

    public DateFormat(String date) throws InvalidCardException {
        try {
            String[] strings = date.split("/");
            if (strings.length != 2) {
                throw new InvalidCardException();
            }
            setMonth(Integer.parseInt(strings[0]));
            setYear(Integer.parseInt(strings[1]));
        } catch (Exception ex) {
            throw new InvalidCardException();
        }
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
}
