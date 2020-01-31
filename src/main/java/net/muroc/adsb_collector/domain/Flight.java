package net.muroc.adsb_collector.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Flight implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer flight_id;

    private String hex;
    private String squawk;
    private String flight;

    @OneToMany(mappedBy = "flight_line_id", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Flight_Point> flight_pointList;

    public void addPoint(Flight_Point point)
    {
        this.flight_pointList.add(point);
    }

    public Integer getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(Integer flight_id) {
        this.flight_id = flight_id;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }

    public String getSquawk() {
        return squawk;
    }

    public void setSquawk(String squawk) {
        this.squawk = squawk;
    }

    public String getFlight() {
        return flight;
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }
}
