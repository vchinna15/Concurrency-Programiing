Concurrency means multiple threads executing a task. It reduces processing time. 

Key terminologies:

Process

Thread

Thread Management (thread creation, start the thread, sleep the thread, join the thread etc)

Task (a calss that implements Runnable or Callable interface)

Thread Interrupt(t.intrrupt()): If any thread is in sleeping or waiting state (i.e. sleep() or wait() is invoked), calling the interrupt() method on the thread, breaks out the sleeping or waiting state throwing InterruptedException. If the thread is not in the sleeping or waiting state, calling the interrupt() method performs normal behaviour and doesn't interrupt the thread but sets the interrupt flag to true.



