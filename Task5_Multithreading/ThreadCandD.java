public class ThreadCandD implements Runnable {
    private int threadCandDCounterVal = 0;

    public ThreadCandD(int previousThreadValue) throws InterruptedException {
        if(previousThreadValue != 2) throw new InterruptedException("Value different than expected"); 
        this.threadCandDCounterVal = previousThreadValue;
    }

    public void run() {
        this.incrementCounter();
    }

    public synchronized void incrementCounter() {
        this.threadCandDCounterVal+=2;
    }

    public int getThreadCandDCounterVal() {
        return this.threadCandDCounterVal;
    }
}