package net.muroc.adsb_collector.controllers;


import net.muroc.adsb_collector.domain.Flight;
import net.muroc.adsb_collector.services.FlightService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FlightController {

    private FlightService flightService;

    @Autowired
    public void setFlightService(FlightService flightService) {
        this.flightService = flightService;
    }

    @RequestMapping(value = "/flights", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("flights", flightService.listAllFlights());
        return "flights";
    }

    @RequestMapping("flight/show/{id}")
    public String showFlight(@PathVariable Integer id, Model model){
        model.addAttribute("flight", flightService.getFlightById(id));
        return "flightshow";
    }

    @RequestMapping("flight/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("flight", flightService.getFlightById(id));
        return "flightform";
    }

    @RequestMapping("flight/new")
    public String newFlight(Model model){
        model.addAttribute("flight", new Flight());
        return "flightform";
    }

    @RequestMapping(value = "flight", method = RequestMethod.POST)
    public String saveFlight(Flight flight){
        flightService.saveFlight(flight);
        return "redirect:/flight/show/" + flight.getFlight_id();
    }

    @RequestMapping("flight/delete/{id}")
    public String delete(@PathVariable Integer id){
        flightService.deleteFlight(id);
        return "redirect:/flights";
    }

    /*@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }
    */

}
