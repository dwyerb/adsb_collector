package net.muroc.adsb_collector.repositories;

import org.springframework.data.repository.CrudRepository;
import net.muroc.adsb_collector.domain.Flight;

import java.util.List;

public interface Flight_Repository extends CrudRepository<Flight, Integer>
{
    //List<Flight> findAllByFlight_numberAndHexAndSquawk(String flight_number, String hex, String squawk);
    List<Flight> findAllByHexAndSquawkAndFlightNumber(String hex, String squawk,String flightNumber);
}
