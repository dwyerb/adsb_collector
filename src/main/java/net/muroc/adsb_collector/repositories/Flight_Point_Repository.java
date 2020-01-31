package net.muroc.adsb_collector.repositories;

import org.springframework.data.repository.CrudRepository;
import net.muroc.adsb_collector.domain.Flight_Point;

public interface Flight_Point_Repository extends CrudRepository<Flight_Point, Integer> {
}
