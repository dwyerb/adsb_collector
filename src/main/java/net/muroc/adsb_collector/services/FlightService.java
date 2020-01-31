package net.muroc.adsb_collector.services;


import net.muroc.adsb_collector.domain.Flight;

public interface FlightService {

    Iterable<Flight> listAllFlights();

    Flight getFlightById(Integer id);

    Flight saveFlight(Flight flight);

    void deleteFlight(Integer id);
}