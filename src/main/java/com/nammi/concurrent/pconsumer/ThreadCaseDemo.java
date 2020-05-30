package com.nammi.concurrent.pconsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadCaseDemo {
	public static void main(String[] args) {
		/**
		 * 生产消费者模型
		 */
		//方式一：ArrayBlockingQueue
		//BlockingQueueBasket basket = new BlockingQueueBasket();
		//方式二：ReentrantLock
		ReentrantLockBasket basket = new ReentrantLockBasket();
		//方式三：Semaphore
		//SemaphoreBasket basket = new SemaphoreBasket();
		
		Consumer c = new Consumer(basket, "c");
		Producer p1 = new Producer(basket, "p1");
		Producer p2 = new Producer(basket, "p2");
		
		ExecutorService service = Executors.newCachedThreadPool();
		service.execute(c);
		service.execute(p1);
		service.execute(p2);
	}
}
