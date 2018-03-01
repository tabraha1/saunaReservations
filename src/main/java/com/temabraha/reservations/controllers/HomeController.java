package com.temabraha.reservations.controllers;

import com.temabraha.reservations.data.entity.Guest;
import com.temabraha.reservations.data.entity.Reservation;
import com.temabraha.reservations.data.entity.Sauna;
import com.temabraha.reservations.data.repository.GuestRepository;
import com.temabraha.reservations.data.repository.ReservationRepository;
import com.temabraha.reservations.data.repository.SaunaRepository;
import com.temabraha.reservations.service.ReservationService;
import com.temabraha.reservations.service.business.SaunaReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private SaunaRepository saunaRepository;

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String index(@RequestParam(value="date", required = false) String dateString, Model
            model) {

        List<SaunaReservation> saunaReservationList = this.reservationService.getSaunaReservationsByDate(dateString);
        model.addAttribute("saunas", saunaReservationList);
        model.addAttribute("date", dateString);
        return "home/index";
    }

    @RequestMapping(value = "home/{dateString}/{saunaId}", method = RequestMethod.GET)
    public String viewSauna(Model model, @PathVariable Long saunaId,
                            @PathVariable String dateString
                            ) {

        Date date = this.reservationService.createDateFromDateString(dateString);

        Sauna sauna = saunaRepository.findOne(saunaId);
        model.addAttribute("title", sauna.getName());
        model.addAttribute("sauna", sauna.getSteamInfo());
        model.addAttribute("number", sauna.getNumber());
        model.addAttribute("date", date);

        return "home/test";
    }

    @RequestMapping(value="home/{dateString}/{saunaId}/guest")
    public String createReservation(Model model) {

        model.addAttribute("guest", new Guest());
        return "forms/guestForm";
    }

    @RequestMapping(value="home/{dateString}/{saunaId}/guest", method = RequestMethod.POST)
    public String displayGuest(Model model, @ModelAttribute Guest guest) {

        guestRepository.save(guest);

        return "redirect:guest/" + guest.getId();

    }

    @RequestMapping(value="home/{dateString}/{saunaId}/guest/{guestId}", method = RequestMethod.GET)
    public String displayReservation(@PathVariable Long saunaId, @PathVariable Long guestId, Model model,
                                     @RequestParam(value="date", required = false) String newDate){

        Sauna sauna = saunaRepository.findOne(saunaId);
        Guest guest = guestRepository.findOne(guestId);

//        Date date = this.reservationService.createDateFromDateString(newDate);

        Reservation reservation = this.reservationService.createReservation(guest, sauna, newDate);

//        Reservation reservation = this.reservationService.createReservation(guest, sauna, dateString);

//        model.addAttribute(new Reservation());
        model.addAttribute("name", guest.getLastName());
        model.addAttribute("sauna", sauna.getName());
        model.addAttribute("saunaId", saunaId);
        model.addAttribute("guestId", guestId);
        model.addAttribute("date", newDate);

        return "home/reservation";
    }

}
