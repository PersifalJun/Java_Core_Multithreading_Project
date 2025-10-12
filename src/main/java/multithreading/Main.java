package multithreading;

import multithreading.counter.SiteVisitCounter;
import multithreading.model.MultithreadingSiteVisitor;
import multithreading.synchronizers.*;

public class Main {
    private static final int NUM_OF_THREADS = 100;
    public static void main(String[] args) {
        SiteVisitCounter unsynchronizedCounter = new UnsynchronizedCounter();
        SiteVisitCounter volatileCounter = new VolatileCounter();
        SiteVisitCounter synchronizedBlockCounter = new SynchronizedBlockCounter();
        SiteVisitCounter atomicIntegerCounter = new AtomicIntegerCounter();
        SiteVisitCounter reentrantLockVisitCounter = new ReentrantLockCounter();

        System.out.println("UnsynchronizedCounter:");
        MultithreadingSiteVisitor visitor1 = new MultithreadingSiteVisitor(unsynchronizedCounter);
        visitor1.visitMultithread(NUM_OF_THREADS);
        visitor1.waitUntilAllVisited();
        visitor1.getTotalTimeOfHanding();
        unsynchronizedCounter.getVisitCount();
        System.out.println("-".repeat(50));

        System.out.println("VolatileCounter:");
        MultithreadingSiteVisitor visitor2 = new MultithreadingSiteVisitor(volatileCounter);
        visitor2.visitMultithread(NUM_OF_THREADS);
        visitor2.waitUntilAllVisited();
        visitor2.getTotalTimeOfHanding();
        volatileCounter.getVisitCount();
        System.out.println("-".repeat(50));

        System.out.println("SynchronizedBlockCounter:");
        MultithreadingSiteVisitor visitor3 = new MultithreadingSiteVisitor(synchronizedBlockCounter);
        visitor3.visitMultithread(NUM_OF_THREADS);
        visitor3.waitUntilAllVisited();
        visitor3.getTotalTimeOfHanding();
        synchronizedBlockCounter.getVisitCount();
        System.out.println("-".repeat(50));

        System.out.println("AtomicIntegerCounter:");
        MultithreadingSiteVisitor visitor4 = new MultithreadingSiteVisitor(atomicIntegerCounter);
        visitor4.visitMultithread(NUM_OF_THREADS);
        visitor4.waitUntilAllVisited();
        visitor4.getTotalTimeOfHanding();
        atomicIntegerCounter.getVisitCount();
        System.out.println("-".repeat(50));

        System.out.println("ReentrantLockCounter:");
        MultithreadingSiteVisitor visitor5 = new MultithreadingSiteVisitor(reentrantLockVisitCounter);
        visitor5.visitMultithread(NUM_OF_THREADS);
        visitor5.waitUntilAllVisited();
        visitor5.getTotalTimeOfHanding();
        reentrantLockVisitCounter.getVisitCount();
        System.out.println("-".repeat(50));


    }
}
