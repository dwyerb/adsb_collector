package net.muroc.adsb_collector.data_collector;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;



public class Scheduled_Collector {

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public void collectAircraft() {
        final Runnable collector = new Runnable()
        {
            @Override
            public void run() {
                System.out.println("RUNNING");
            }
        };

        final ScheduledFuture<?> COLLECTORHANDLE = scheduler.scheduleAtFixedRate(this::collectAircraft, 10, 10, TimeUnit.SECONDS);


        //@Scheduled(fixedRate = 10000)
        //public static void collectData(){ System.out.println("FIXED Test"); }
    }

    public void stopCollection()
    {
        scheduler.shutdown();
    }


}
