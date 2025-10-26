package multithreading.synchronizers;

import multithreading.counter.SiteVisitCounter;

public class UnsynchronizedCounter implements SiteVisitCounter {

    private int counter = 0;

    @Override
    public void incrementVisitCount() {
        try {
            this.counter++;
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public int getVisitCount() {
        return this.counter;
    }
}
