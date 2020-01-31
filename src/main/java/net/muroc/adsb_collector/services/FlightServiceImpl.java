package net.muroc.adsb_collector.services;

import net.muroc.adsb_collector.domain.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.muroc.adsb_collector.repositories.Flight_Repository;

@Service
public class FlightServiceImpl implements FlightService {

    private Flight_Repository flight_repository;

    @Autowired
    public void setFlight_repository(Flight_Repository flight_repository)
    {
        this.flight_repository = flight_repository;
    }

    @Override
    public Iterable<Flight> listAllFlights() {
        return flight_repository.findAll();
    }

    @Override
    public Flight getFlightById(Integer id) {
        return flight_repository.findById(id).orElse(null);
    }

    @Override
    public Flight saveFlight(Flight flight) {
        return flight_repository.save(flight);
    }

    @Override
    public void deleteFlight(Integer id) {
        flight_repository.deleteById(id);
    }
}
