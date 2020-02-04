package net.muroc.adsb_collector.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
public class Flight_Point implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer flight_point_id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name="flight_id")
    private Flight flight_line;

    private Integer point_id;
    private int flight_line_id;
    private String hex;
    private String squawk;
    private String flight_number;
    private double lat;
    private double lon;
    private double nucp;
    private double seen_pos;
    private long altitude;
    private int vert_rate;
    private int track;
    private int speed;
    private int messages;
    private Timestamp timeStamp;

    public void setFlight_line(Flight flight_line)
    {
        this.flight_line = flight_line;
    }

    public Flight getFlight_line()
    {
        return this.flight_line;
    }

    public int getFlight_line_id() {
        return flight_line_id;
    }

    public void setFlight_line_id(int flight_line_id) {
        this.flight_line_id = flight_line_id;
    }

    public Integer getId() {
        return point_id;
    }

    public void setId(Integer id) {
        this.point_id = id;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
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

    public String getFlight_number() {
        return flight_number;
    }

    public void setFlight_number(String flight_number) {
        this.flight_number = flight_number;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getNucp() {
        return nucp;
    }

    public void setNucp(double nucp) {
        this.nucp = nucp;
    }

    public double getSeen_pos() {
        return seen_pos;
    }

    public void setSeen_pos(double seen_pos) {
        this.seen_pos = seen_pos;
    }

    public long getAltitude() {
        return altitude;
    }

    public void setAltitude(long altitude) {
        this.altitude = altitude;
    }

    public int getVert_rate() {
        return vert_rate;
    }

    public void setVert_rate(int vert_rate) {
        this.vert_rate = vert_rate;
    }

    public int getTrack() {
        return track;
    }

    public void setTrack(int track) {
        this.track = track;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getMessages() {
        return messages;
    }

    public void setMessages(int messages) {
        this.messages = messages;
    }
}
