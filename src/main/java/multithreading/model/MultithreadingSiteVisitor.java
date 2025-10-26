package multithreading.model;

import multithreading.counter.SiteVisitCounter;

import java.util.concurrent.CountDownLatch;

public class MultithreadingSiteVisitor {
    private final SiteVisitCounter counter;
    private CountDownLatch latch;
    private double start;
    private double end;

    public MultithreadingSiteVisitor(SiteVisitCounter counter) {
        this.counter = counter;
    }

    public void visitMultithread(int numOfThreads){
        latch = new CountDownLatch(numOfThreads);
        start = System.nanoTime();
        for (int i = 0; i <numOfThreads; i++) {
            new Thread(() -> {
                try {
                    counter.incrementVisitCount();
                } finally {
                    latch.countDown();
                }
            }).start();
        }
    }


    public void waitUntilAllVisited(){
        try {
            latch.await();
            end = System.nanoTime();
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            System.out.println(ex.getMessage());
        }

    }

    public double getTotalTimeOfHandling() {
        double endPoint = (end != 0) ? end : System.nanoTime();
        return (endPoint - start) / 1_000_000_000;
    }
}
