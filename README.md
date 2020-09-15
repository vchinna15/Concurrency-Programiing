Multithreading means a task is executed by multiple threads. It reduces processing time. 

Parellelism means independent tasks are executed by multiple threads. Example: process tax for each users parallely. Ensure taht the CPU has multiple core(one thread per core) so that you can have no.of threads equal or more than No.of Cores in the CPU. We can use Executor Framework to create threadpool and submit the tasks to them.

public static void main(){

  new Thread(() -> processTax(user1)).start(); //Thread 1
  
  new Thread(() -> processTax(user2)).start(); //Thrad2
  
  doSomeHeavyCalculations(); //Main thread }
  
  
 Concurrency means multiple threads are accessing a shared resource/object. 


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

Reentrant Lock: Similar to Intrinsic Lock

External Locks: these are provided by java.util.concurrent.locks package. (Lock(I), ReentrantLock(C), ReentrantReadwriteLock(C))

Special purpose Synchronizers: THis is provided by java.util.concurrent package to implement special purpose synchronization which can't be acheieved by default synchronization(intrinsic lock) provided by java.
  - Semaphore
  -CountDownLatch
  -CyclicBarrier
  -Phaser
  -Exchanger

Atomic Access: It's like DB Transaction. It's a single unit of execution. Still there may be synchronization required for atomic operation as memory consitency issue might happen. Some of the classes in the java.util.concurrent package provide atomic methods that do not rely on synchronization.

Best practices of multithreading:
1. Avoid locking or Reduce scope of Synchronization
2. Prefer Synchronizers(Semapbire, COuntdownLatch, exchanger, CyclicBarrier) over wait and notify
3. Prefer Concurrent Collection over Synchronized Collectio





