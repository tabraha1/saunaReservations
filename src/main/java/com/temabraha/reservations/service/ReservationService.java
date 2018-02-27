package com.temabraha.reservations.service;

import com.temabraha.reservations.data.entity.Guest;
import com.temabraha.reservations.data.entity.Reservation;
import com.temabraha.reservations.data.entity.Sauna;
import com.temabraha.reservations.data.repository.GuestRepository;
import com.temabraha.reservations.data.repository.ReservationRepository;
import com.temabraha.reservations.data.repository.SaunaRepository;
import com.temabraha.reservations.service.business.SaunaReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ReservationService {

    private SaunaRepository saunaRepository;
    private GuestRepository guestRepository;
    private ReservationRepository reservationRepository;

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    public ReservationService(SaunaRepository saunaRepository,
                              GuestRepository guestRepository,
                              ReservationRepository reservationRepository) {
        this.saunaRepository = saunaRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
    }

    public List<SaunaReservation> getSaunaReservationsByDate(String dateString) {

        Date date = this.createDateFromDateString(dateString);

        Iterable<Sauna> saunas = this.saunaRepository.findAll();
        Map<Long, SaunaReservation> saunaReservationMap = new HashMap<>();

        for(Sauna sauna : saunas) {
            SaunaReservation saunaReservation = new SaunaReservation();
            saunaReservation.setSaunaId(sauna.getId());
            saunaReservation.setSaunaName(sauna.getName());
            saunaReservation.setSaunaNumber(sauna.getNumber());
            saunaReservationMap.put(sauna.getId(), saunaReservation);
        }

        Iterable<Reservation> reservations = this.reservationRepository.findByDate(new java.sql.Date(date.getTime()));
        if(reservations != null) {
            for(Reservation reservation : reservations) {
                Sauna sauna = this.saunaRepository.findOne(reservation.getSaunaId());
                Guest guest = this.guestRepository.findOne(reservation.getGuestId());
                if(guest != null) {
                    SaunaReservation saunaReservation = saunaReservationMap.get(reservation.getId());
                    saunaReservation.setDate(date);
                    saunaReservation.setSaunaName(sauna.getName());
                    saunaReservation.setSaunaNumber(sauna.getNumber());
                    saunaReservation.setSaunaId((sauna.getId()));
                    saunaReservation.setGuestId(guest.getId());
                }
            }
        }
        List<SaunaReservation> saunaReservations = new ArrayList<>();
        for(Long saunaId : saunaReservationMap.keySet()) {
            saunaReservations.add(saunaReservationMap.get(saunaId));
        }
        return saunaReservations;
    }

    private Date createDateFromDateString(String dateString) {
        Date date = null;
        if(dateString != null) {
            try {
                date = DATE_FORMAT.parse(dateString);
            } catch(ParseException pe) {
                date = new Date();
            }
        } else {
            date = new Date();
        }
        return date;
    }


    public SaunaReservation createReservation(Guest guest, Sauna sauna, String dateString) {

        Date date = this.createDateFromDateString(dateString);

        SaunaReservation saunaReservation = new SaunaReservation();
        saunaReservation.setSaunaId(sauna.getId());
        saunaReservation.setGuestId(guest.getId());
        saunaReservation.setFirstName(guest.getFirstName());
        saunaReservation.setLastName(guest.getLastName());
        saunaReservation.setSaunaNumber(sauna.getNumber());
        saunaReservation.setSaunaName(sauna.getName());
        saunaReservation.setDate(date);


        return saunaReservation;

    }


}
