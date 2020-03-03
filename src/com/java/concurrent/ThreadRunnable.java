package com.java.concurrent;

import java.time.Duration;
import java.time.Instant;

////multithreading - 

class Task implements Runnable {
	volatile int count;

	@Override
	public synchronized void run() {
		System.out.println(Thread.currentThread().getName() + "Start Value=  " + count);
		for (int i = 0; i < 10000; i++) {
			count++;
		}
		System.out.println(Thread.currentThread().getName() + "End Value=  " + count);
	}
}

public class ThreadRunnable {

	public static void main(String[] args) throws InterruptedException {
		Instant start = Instant.now();
		Thread[] threads = new Thread[3];
		Task task = new Task();
		for (int i = 0; i < 3; i++) {
			threads[i] = new Thread(task);
		}

		for (int i = 0; i < 3; i++) {
			threads[i].start();
		}
		for (int i = 0; i < 3; i++) {
			threads[i].join();
		}

		Instant finish = Instant.now();
		System.out.println("TIme elapsed for thread =" + Duration.between(start, finish).toMillis());// 3 milliseconds

		Instant start1 = Instant.now();
		int count = 0;
		for (int j = 0; j < 3; j++) {
			System.out.println(Thread.currentThread().getName() + "Start Value=  " + count);
			for (int i = 0; i < 100000; i++) {
				count++;
			}
			System.out.println(Thread.currentThread().getName() + "End Value=  " + count);
		}
		Instant finish1 = Instant.now();

		System.out.println("TIme elapsed for Loop =" + Duration.between(start1, finish1).toMillis());//5 milliseconds
	}

}
