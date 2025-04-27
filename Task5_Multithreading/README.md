A simple java program that executes SIX threads.

-> First thread A and B are executed in parallel.
-> Then, thread C and D wait for the completion of thread A and B then use the result of that process to continue the execution.
-> At last thread F furthur processes the result from thread C and D by waiting for them to complete execution.

Assumptions:

If there is an exception thrown then we have a retry mechanism in place which is callable from the catch method. In this way we can try to execution the workflow again.