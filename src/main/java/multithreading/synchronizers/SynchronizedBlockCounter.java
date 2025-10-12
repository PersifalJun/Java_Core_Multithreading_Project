package multithreading.synchronizers;

import multithreading.counter.SiteVisitCounter;

public class SynchronizedBlockCounter implements SiteVisitCounter {
    private Object monitor = new Object();
    private Integer counter = 0;

    @Override
    public void incrementVisitCount() {
        synchronized (monitor) {
            try {
                Thread.sleep(100);
                this.counter++;
            } catch (InterruptedException ex) {
                ex.getMessage();
            }

        }
    }

    @Override
    public int getVisitCount() {
        System.out.println(this.counter);
        return this.counter;
    }
}
