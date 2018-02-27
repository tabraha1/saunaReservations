package com.temabraha.reservations.data.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="GUEST")
public class Guest {

    @Id
    @GeneratedValue
    @Column(name = "GUEST_ID")
    private long id;

    @Size(max = 64)
    @Column(name = "FIRST_NAME")
    private String firstName;

    @Size(max = 64)
    @Column(name = "LAST_NAME")
    private String lastName;

    @Size(max = 64)
    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;

    @Size(max = 24)
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}