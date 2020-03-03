package com.java.concurrent;
// Also called Guarded Blocks. This is used to create producer-consumer application
class Print {
	boolean isAPrinted=false;
	public synchronized void printA() {
		while (!isAPrinted) {
			
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println(Thread.currentThread().getName()+"  "+"A");
		isAPrinted=false;
		notify();			
	}
	
	public synchronized void printB() {
		while (isAPrinted) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println(Thread.currentThread().getName()+"  "+"B");
		isAPrinted=true;
		notify();
		
	}
}


public class WaitNotify {
	

	public static void main(String[] args) throws InterruptedException {
		Print print = new Print(); //shared object
		Runnable task1 = ()->{ for (int i=0;i<10;i++) print.printA();};
		Runnable task2 = ()->{ for (int i=0;i<10;i++) print.printB();};
		Thread t1 =  new Thread(task1); //Producer Thread
		Thread t2 =  new Thread(task2); //Consumer thread
		t1.start();
		t2.start();
		t1.join();
		t2.join();
	}

}
