package com.temabraha.reservations.data.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name="RESERVATION")
public class Reservation {

    @Id
    @GeneratedValue
    @Column(name="RESERVATION_ID")
    private long id;

    @NotNull
    @Column(name="SAUNA_ID")
    private long saunaId;

    @NotNull
    @Column(name="GUEST_ID")
    private long guestId;

    @Column(name="RES_DATE")
    private Date date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
