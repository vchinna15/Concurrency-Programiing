package com.java.concurrent;
//Race Condition example
class Shared{
	private  int count;
	public  void increment() {
	count++;	
	}
	
	public int getValue() {
		return count;
	}
}

class TaskThread implements Runnable{
	Shared shared;
	
	TaskThread(Shared shared){
		this.shared=shared;
		
	}
	@Override
	public void run() {		
		   for ( int i=0; i<1000000; i++ ) {
	            shared.increment();
	        }
		
	}
	
}
public class ThreadSharedData {

	public static void main(String[] args) throws InterruptedException {
		Shared s =  new Shared();
			TaskThread tt = new TaskThread(s);
			Thread t = new Thread(tt);
			t.start();
			t.interrupt();
			Thread t2 = new Thread(tt);
			t2.start();
			
			t.join();
			t2.join();
		System.out.println(s.getValue()); //1986816 or any random number; 
		//if you synchronize the method, you will always get 200000

	}

}
