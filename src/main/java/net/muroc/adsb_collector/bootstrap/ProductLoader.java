package net.muroc.adsb_collector.bootstrap;

import net.muroc.adsb_collector.domain.Flight;
import net.muroc.adsb_collector.domain.Flight_Point;
import net.muroc.adsb_collector.domain.Product;
import net.muroc.adsb_collector.repositories.Flight_Point_Repository;
import net.muroc.adsb_collector.repositories.Flight_Repository;
import net.muroc.adsb_collector.repositories.ProductRepository;
//import org.apache.log4j.Logger;
//import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class ProductLoader implements ApplicationListener<ContextRefreshedEvent> {

    private ProductRepository productRepository;

    private Flight_Point_Repository flight_point_repository;
    private Flight_Repository flight_repository;


    //private Logger log = Logger.getLogger(ProductLoader.class);

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Autowired
    public void setFlight_point_repository(Flight_Point_Repository flight_point_repository)
    {
        this.flight_point_repository = flight_point_repository;
    }

    @Autowired
    public void setFlight_repository(Flight_Repository flight_repository){
        this.flight_repository = flight_repository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Product shirt = new Product();
        shirt.setDescription("Spring Framework Guru Shirt");
        shirt.setPrice(new BigDecimal("18.95"));
        //shirt.setImageUrl("https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_shirt-rf412049699c14ba5b68bb1c09182bfa2_8nax2_512.jpg");
        shirt.setProductId("235268845711068308");
        productRepository.save(shirt);

        //log.info("Saved Shirt - id: " + shirt.getId());

        Product mug = new Product();
        mug.setDescription("Spring Framework Guru Mug");
        //mug.setImageUrl("https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_coffee_mug-r11e7694903c348e1a667dfd2f1474d95_x7j54_8byvr_512.jpg");
        mug.setProductId("168639393495335947");
        mug.setPrice(new BigDecimal("11.95"));
        productRepository.save(mug);

        //log.info("Saved Mug - id:" + mug.getId());

        String fl1_flightNumber = "AAY772";
        String fl1_Hex = "a35e5b";
        String fl1_Squawk = "abcd1234";
        double fl1_lat = 28.223225;
        double fl1_lon = -82.703032;

        //Flight_Point flight_point_1 = new Flight_Point();
        //flight_point_1.setFlight_number(fl1_flight);
        //flight_point_1.setHex(fl1_Hex);
        //flight_point_1.setSquawk(fl1_Squawk);
        //flight_point_1.setLat(fl1_lat);
        //flight_point_1.setLon(fl1_lon);

        Flight flight_line1 = new Flight();
        flight_line1.setFlightNumber(fl1_flightNumber);
        flight_line1.setHex(fl1_Hex);
        flight_line1.setSquawk(fl1_Squawk);
        flight_repository.save(flight_line1);

        List<Flight> flights = flight_repository.findAllByHexAndSquawkAndFlightNumber(fl1_Hex,fl1_Squawk,fl1_flightNumber);
        if(flights.size()>0)
        {
            //Flight flight_line1 = new Flight();
            //flight_line1.setFlight_number(fl1_flight);
            //flight_line1.setHex(fl1_Hex);
            //flight_line1.setSquawk(fl1_Squawk);
            //flight_line1.addPoint(flight_point_1);
            //flight_point_1.setFlight_line(flight_line1);

            //flight_point_repository.save(flight_point_1);
        }


        Flight_Point flight_point_1 = new Flight_Point();
        flight_point_1.setFlight_number(fl1_flightNumber);
        flight_point_1.setHex(fl1_Hex);
        flight_point_1.setSquawk(fl1_Squawk);
        flight_point_1.setLat(fl1_lat);
        flight_point_1.setLon(fl1_lon);
        //flight_line1.addPoint(flight_point_1);
        flight_point_1.setFlight_line_id(flight_line1.getFlight_id());
        flight_point_1.setFlight_line(flight_line1);
        flight_point_repository.save(flight_point_1);



    }
}
