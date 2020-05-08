package com.bizpattern.example.jconcurrent;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class SampleBlockingQueue {

	class Producer implements Runnable {
		private final BlockingQueue<Integer> queue;

		Producer(BlockingQueue<Integer> q) {
			queue = q;
		}

		public void run() {
			try {
				while (true) {
					Integer x = produce();
					System.out.println("Producer producing value = " + x);
					queue.put(x);
					System.out.println("Producer will sleep for 10 Seconds.");
					Thread.sleep(10000);
				}
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}

		Integer produce() {
			return new Random().nextInt();
		}
	}

	class Consumer implements Runnable {
		private final BlockingQueue<Integer> queue;
		private int id = 0;

		Consumer(int id, BlockingQueue<Integer> q) {
			queue = q;
			this.id = id;
		}

		public void run() {
			try {
				while (true) {
					consume(queue.take());
				}
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}

		void consume(Integer x) {
			System.out.println("Consumer id = " + id + ": Received Value = "+ x);
		}
	}

	class Setup {
		void main() {
			BlockingQueue<Integer> q = new LinkedBlockingQueue<Integer>();
			Producer p = new Producer(q);
			Consumer c1 = new Consumer(1, q);
			Consumer c2 = new Consumer(2, q);
			new Thread(p).start();
			new Thread(c1).start();
			new Thread(c2).start();
		}
	}

	public static void main(String[] args) {
		new SampleBlockingQueue().new Setup().main();
	}

}
