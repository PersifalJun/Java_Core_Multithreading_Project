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
            this.counter++;
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        } finally {
            lock.unlock();
        }
    }
    @Override
    public int getVisitCount() {
        return this.counter;
    }
}
