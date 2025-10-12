package multithreading.synchronizers;

import multithreading.counter.SiteVisitCounter;

public class VolatileCounter implements SiteVisitCounter {

    private volatile int counter = 0;

    @Override
    public void incrementVisitCount() {
        try {
            Thread.sleep(100);
            this.counter++;
        } catch (InterruptedException ex) {
            ex.getMessage();
        }
    }

    @Override
    public int getVisitCount() {
        System.out.println(this.counter);
        return this.counter;
    }
}
