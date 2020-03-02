Concurrency means multiple threads executing a task. It reduces processing time. 

Key terminologies:

Process

Thread

Thread Management (thread creation, start the thread, sleep the thread, join the thread etc)

Task (a calss that implements Runnable or Callable interface)

Thread Interrupt(t.intrrupt()): If any thread is in sleeping or waiting state (i.e. sleep() or wait() is invoked), calling the interrupt() method on the thread, breaks out the sleeping or waiting state throwing InterruptedException. If the thread is not in the sleeping or waiting state, calling the interrupt() method performs normal behaviour and doesn't interrupt the thread but sets the interrupt flag to true.
Joins (t.join()): It causes the current thread to pause execution until t's thread terminates.

Inter Thread Communication: Threads communicate each other through commonn shared class object. it creates two issues: 1. Thread Inerference, 2. Memory consisitency issues

Thread Interference:

Memory Consistency Issue:

Happens-Before Relationship:

Synchronized Methods:

Synchronized Statements:

Intrinsic Lock or Monitor Lock:

Wait Set:

Notification:

Reentrant Synchronization:

Atomic Access: It's like DB Transaction. It's a single unit of execution. Still there may be synchronization required for atomic operation as memory consitency issue might happen. Some of the classes in the java.util.concurrent package provide atomic methods that do not rely on synchronization.




