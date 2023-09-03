package org.anteastra;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Event> events = new ArrayList<>();
        for (int i=0; i< 100000000; i++) {
            events.add(new GeneralEvent());
        }
        events.add(new SpecialEvent());
        Handler handler = new Handler();

        List<Long> time = new ArrayList<>();
        List<Long> time2 = new ArrayList<>();
        for (int i=0; i < 100; i ++) {
            time2.add(testEventProcessingWithCheck(events, handler));
            time.add(testEventProcessing(events, handler));
            System.out.println("Without check("+(i+1)+"): " + time.get(i) + "ms");
            System.out.println("With    check("+(i+1)+"): " + time2.get(i) + "ms");
        }
    }

    private static Long testEventProcessingWithCheck(List<Event> events, Handler handler) {
        long startTime = System.currentTimeMillis();

        for (int i=0; i < events.size(); i++) {
            handler.handleEvent(events.get(i));
        }

        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private static long testEventProcessing(List<Event> events, Handler handler) {
        long startTime = System.currentTimeMillis();

        for (int i=0; i < events.size(); i++) {
            handler.handleEventWithTypeCheck(events.get(i));
        }

        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}
