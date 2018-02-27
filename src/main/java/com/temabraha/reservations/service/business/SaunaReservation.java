package com.temabraha.reservations.service.business;

import java.util.Date;

public class SaunaReservation {

    private long saunaId;
    private long guestId;
    private String saunaName;
    private String saunaNumber;
    private String firstName;
    private String lastName;
    private Date date;

    public long getSaunaId() {
        return saunaId;
    }

    public void setSaunaId(long saunaId) {
        this.saunaId = saunaId;
    }

    public long getGuestId() {
        return guestId;
    }

    public void setGuestId(long guestId) {
        this.guestId = guestId;
    }

    public String getSaunaName() {
        return saunaName;
    }

    public void setSaunaName(String saunaName) {
        this.saunaName = saunaName;
    }

    public String getSaunaNumber() {
        return saunaNumber;
    }

    public void setSaunaNumber(String saunaNumber) {
        this.saunaNumber = saunaNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
