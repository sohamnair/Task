class Main {
    public static void main(String[] args) {
        try {
            ThreadAandB threadABObj = new ThreadAandB();
            Thread threadA = new Thread(threadABObj);
            Thread threadB = new Thread(threadABObj);
            threadA.start();
            threadB.start();

            // waits for completion of thread A and B
            threadA.join();
            threadB.join();

            int val = threadABObj.getThreadAandBCounterVal();
            System.out.println("Thread A and B increment task completed, counter value expected to be 2 and the actual value is "+val);
            ThreadCandD threadCDObj = new ThreadCandD(val);
            Thread threadC = new Thread(threadCDObj);
            Thread threadD = new Thread(threadCDObj);
            threadC.start();
            threadD.start();

            // waits for completion of thread C and D
            threadC.join();
            threadD.join();

            val = threadCDObj.getThreadCandDCounterVal();
            System.out.println("Thread C and D increment task completed, counter value expected to be 6 and the actual value is "+val);
            ThreadF threadFObj = new ThreadF(val);
            Thread threadF = new Thread(threadFObj);
            threadF.start();

            // waits for completion of thread F
            threadF.join();

            val = threadFObj.getThreadFCounterVal();
            System.out.println("Thread F increment task completed, counter value expected to be 10 and the actual value is "+val);
        }
        catch(Exception e) {
            System.err.println("Error: "+e.getMessage());
        }
    }
}