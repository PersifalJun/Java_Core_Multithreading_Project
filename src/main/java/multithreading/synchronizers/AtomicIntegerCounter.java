package multithreading.synchronizers;

import multithreading.counter.SiteVisitCounter;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerCounter implements SiteVisitCounter {
    private AtomicInteger counter = new AtomicInteger(0);

    @Override
    public void incrementVisitCount() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            ex.getMessage();
        }
        this.counter.incrementAndGet();
    }

    @Override
    public int getVisitCount() {
        ;
        System.out.println(this.counter.get());
        return this.counter.get();
    }
}
