package org.anteastra;

public class Handler {

    public void handleEvent(Event e) {
        long timeStamp = System.currentTimeMillis();
        e.setLut(timeStamp);
    }

    public void handleEventWithTypeCheck(Event e) {
        long timeStamp = System.currentTimeMillis();
        if (e instanceof SpecialEvent) {
            SpecialEvent event = (SpecialEvent) e;
            event.setVisitTime(timeStamp);
            return;
        }
        e.setLut(timeStamp);
    }
}
