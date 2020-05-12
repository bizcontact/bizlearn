package com.bizpattern.example.jconcurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Simple future sample. How you register the future and a function (callback) defined inside it.
 * How to use this function as parameter and execute the callback in thread safe manner.
 * Thread will be managed by Thread pool and pool will take care of all the locks.
 * 
 * @author Cookie
 *
 */
public class SampleFuture {

	public static void main(String[] args) {

		ExecutorService executor = new ThreadPoolExecutor(3, 5, 1L, TimeUnit.DAYS, new LinkedBlockingQueue<Runnable>());

//Create a future and add it to Thread execution, thread execution will take care of executing this future
//we attach a callable and that will be notified when result is available		
		Future<String> future = executor.submit(new Callable<String>() {
			public String call() {
				return "Result from future";
			}
		});

		System.out.println("Future is registered. Wait starting for 5 seconds");
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Wait is over. when we call get future will run its callable.");

		try {
			System.out.println("After 5 seconds wait, future result: " + future.get());
			System.out.println("Call future get again, future result: : " + future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException ex) {
			ex.printStackTrace();
			return;
		}
	}
}
