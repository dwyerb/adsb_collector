package net.muroc.adsb_collector.repositories;

import org.springframework.data.repository.CrudRepository;
import net.muroc.adsb_collector.domain.Flight;

import java.util.List;

public interface Flight_Repository extends CrudRepository<Flight, Integer>{

    List<Flight> findAllByFlightAndHexAndSquawk(String flight_val, String hex_val, String squawk_val);
}
