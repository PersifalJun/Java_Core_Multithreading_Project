package multitgheading.model;

import multitgheading.util.SiteVisitCounter;

public class MultithreadingSiteVisitor {
    private final SiteVisitCounter counter;

    public MultithreadingSiteVisitor(SiteVisitCounter counter) {
        this.counter = counter;
    }

    public void visitMultithread(int numOfThreads){
        counter.incrementVisitCount();
    }

    public void waitUntilAllVisited(){

    }

    public int getTotalTimeOfHanding(){
        counter.getVisitCount();
    }
}
