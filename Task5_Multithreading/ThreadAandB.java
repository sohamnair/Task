public class ThreadAandB implements Runnable {
    private int threadAandBCounterVal = 0;

    public void run() {
        this.incrementCounter();
    }

    public synchronized void incrementCounter() {
        this.threadAandBCounterVal++;
    }

    public int getThreadAandBCounterVal() {
        return this.threadAandBCounterVal;
    }
}
