package multithreading.synchronizers;

import multithreading.counter.SiteVisitCounter;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockCounter implements SiteVisitCounter {
    private final ReentrantLock lock = new ReentrantLock();
    private int counter = 0;

    @Override
    public void incrementVisitCount() {
        lock.lock();
        try {
            Thread.sleep(100);
            this.counter++;
        } catch (InterruptedException ex) {
            ex.getMessage();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int getVisitCount() {
        System.out.println(this.counter);
        return this.counter;
    }
}
