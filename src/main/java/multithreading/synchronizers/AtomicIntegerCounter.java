package multithreading.synchronizers;

import multithreading.counter.SiteVisitCounter;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerCounter implements SiteVisitCounter {
    private AtomicInteger counter = new AtomicInteger(0);

    @Override
    public void incrementVisitCount() {
        try {
            this.counter.incrementAndGet();
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public int getVisitCount() {
        return this.counter.get();
    }
}
