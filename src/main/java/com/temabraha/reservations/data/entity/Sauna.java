package com.temabraha.reservations.data.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="SAUNA")
public class Sauna {

    @Id
    @Column(name = "SAUNA_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(max = 16)
    @Column(name = "NAME")
    private String name;

    @NotNull
    @Size(max = 2)
    @Column(name = "SAUNA_NUMBER")
    private String number;

    @NotNull
    @Size(max = 10)
    @Column(name = "STEAM_INFO")
    private String steamInfo;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSteamInfo() {
        return steamInfo;
    }

    public void setSteamInfo(String steamInfo) {
        this.steamInfo = steamInfo;
    }
}