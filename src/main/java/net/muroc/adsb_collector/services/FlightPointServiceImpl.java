package net.muroc.adsb_collector.services;

import net.muroc.adsb_collector.domain.Flight_Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.muroc.adsb_collector.repositories.Flight_Point_Repository;

@Service
public class FlightPointServiceImpl implements FlightPointService {

    private Flight_Point_Repository flight_point_repository;

    @Autowired
    public void setFlight_point_repository(Flight_Point_Repository flight_point_repository)
    {
        this.flight_point_repository = flight_point_repository;
    }

    @Override
    public Iterable<Flight_Point> listAllPoints() {
        return flight_point_repository.findAll();
    }

    @Override
    public Flight_Point getPointById(Integer id) {
        return flight_point_repository.findById(id).orElse(null);
    }

    @Override
    public Flight_Point savePoint(Flight_Point flight_point) {
        return flight_point_repository.save(flight_point);
    }

    @Override
    public void deletePoint(Integer id) {
        flight_point_repository.deleteById(id);
    }
}
