package daniel.java.corejava.util.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
	public static void main(String[] args) {
		//创建等待队列
		BlockingQueue<Runnable> bQueue = new ArrayBlockingQueue<Runnable>(20);
		//创建线程池，池中保存的线程数为3，允许的最大线程数为5
		ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 5, 50, TimeUnit.MILLISECONDS, bQueue);
		//创建七个任务
		Runnable r1 = new MyThread();
		Runnable r2 = new MyThread();
		Runnable r3 = new MyThread();
		Runnable r4 = new MyThread();
		Runnable r5 = new MyThread();
		Runnable r6 = new MyThread();
		Runnable r7 = new MyThread();
		//每个任务会在一个线程上执行
		pool.execute(r1);
		pool.execute(r2);
		pool.execute(r3);
		pool.execute(r4);
		pool.execute(r5);
		pool.execute(r6);
		pool.execute(r7);
		//关闭线程池
		pool.shutdown();
	}
}

class MyThread implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" 正在执行。。。");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
