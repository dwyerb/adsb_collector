package net.muroc.adsb_collector.services;

import net.muroc.adsb_collector.domain.Flight_Point;

public interface FlightPointService {
    Iterable<Flight_Point> listAllPoints();

    Flight_Point getPointById(Integer id);

    Flight_Point savePoint(Flight_Point flight_point);

    void deletePoint(Integer id);
}






