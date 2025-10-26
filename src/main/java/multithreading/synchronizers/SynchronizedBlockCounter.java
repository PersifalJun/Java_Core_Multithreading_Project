package multithreading.synchronizers;

import multithreading.counter.SiteVisitCounter;

public class SynchronizedBlockCounter implements SiteVisitCounter {
    private final Object monitor = new Object();
    private Integer counter = 0;

    @Override
    public void incrementVisitCount() {
        synchronized (monitor) {
            try {
                this.counter++;
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }

        }
    }

    @Override
    public int getVisitCount() {
        return this.counter;
    }
}
