public class ThreadF implements Runnable {
    private int threadFCounterVal = 0;

    public ThreadF(int previousThreadValue) throws InterruptedException {
        if(previousThreadValue != 6) throw new InterruptedException("Value different than expected");
        this.threadFCounterVal = previousThreadValue;
    }

    public void run() {
        this.incrementCounter();
    }

    public synchronized void incrementCounter() {
        this.threadFCounterVal+=4;
    }

    public int getThreadFCounterVal() {
        return this.threadFCounterVal;
    }
}