package com.java.concurrent;
class Task2 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName()+" "+"Thread Innterrupted. Nothing to do.e return");
			return;
		}
	}
	
}

class Task3 implements Runnable{

	@Override
	public void run() {
		for(int i=1;i<=5;i++)  {
			System.out.println(Thread.currentThread().getName()+" "+i); 
			if (Thread.interrupted()) {
				throw new RuntimeException();
			}
			System.out.println(Thread.currentThread().getName()+" "+i);   
			}  
	}
}	


public class ThreadInteruption {

	public static void main(String[] args) {
		Thread t = new Thread(new Task2());
		t.start();
		t.interrupt();
		Thread t2 = new Thread(new Task3());
		t2.start();
		t2.interrupt();
	}

}
