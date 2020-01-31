package net.muroc.adsb_collector.services;

import org.springframework.stereotype.Service;
import net.muroc.adsb_collector.data_collector.Scheduled_Collector;


@Service
public class CollectorServiceImpl
{
    Scheduled_Collector scheduled_collector = new Scheduled_Collector();

    public void startCollecting()
    {
        scheduled_collector.collectAircraft();
    }
    public void stopCollecting()
    {
        scheduled_collector.stopCollection();
    }
}
