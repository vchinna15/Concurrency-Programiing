package com.java.concurrent;

import java.util.concurrent.Semaphore;

//semaphore can be used for two purpose: 1. Inter Thread COmmunication(signalling), 
//2. synchronize access to shared resource(like intrinsic locks or external locks given in java.util.concurrent package

public class SemaphoreTest {
	//similar to Object.wait() and Object.notify() implementaion
	public static void main(String[] args) {
		Semaphore sem = new Semaphore(1);
		Runnable sender = ()-> {while (true) {
			System.out.println(Thread.currentThread().getName() + " " + "sent");
			try {
				sem.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}};
			
			Runnable receiver = () -> {while (true) {				
				sem.release();
				System.out.println(Thread.currentThread().getName() + " " + "received");
			}};
			
		Thread t1 = new Thread (sender);
		Thread t2 = new Thread (receiver);
		t1.start();
		t2.start();

	}

}
