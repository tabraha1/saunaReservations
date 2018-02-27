package com.temabraha.reservations.controllers;

import com.temabraha.reservations.service.ReservationService;
import com.temabraha.reservations.service.business.SaunaReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ReservationService reservationService;

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String index(@RequestParam(value="date", required = false) String dateString, Model
            model) {

        List<SaunaReservation> saunaReservationList = this.reservationService.getSaunaReservationsByDate(dateString);
        model.addAttribute("saunas", saunaReservationList);
        return "home/index";
    }
}
