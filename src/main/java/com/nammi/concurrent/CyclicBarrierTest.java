package com.nammi.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
	public static void main(String[] args) {
		//创建CyclicBarrier对象，  
        //并设置执行完一组5个线程的并发任务后，再执行MainTask任务
		CyclicBarrier cb = new CyclicBarrier(5, new FinalTask());
		new SubTask("A", cb).start();
		new SubTask("B", cb).start();
		new SubTask("C", cb).start();
		new SubTask("D", cb).start();
		new SubTask("E", cb).start();
	}
}

class FinalTask implements Runnable{
	@Override
	public void run() {
		System.out.println("......终于要执行最后的任务了......");
	}
}

class SubTask extends Thread{
	private String name;
	private CyclicBarrier cb;
	public SubTask(String name, CyclicBarrier cb) {
		this.name = name;
		this.cb = cb;
	}
	@Override
	public void run() {
		System.out.println("[并发任务" + name + "]  开始执行");
		for(int i=0; i<999999; i++);//模拟耗时的任务
		System.out.println("[并发任务" + name + "]  执行完毕，通知障碍器");
		try{
			//每执行完一项任务就通知障碍器
			cb.await();
		}catch(InterruptedException e){
			e.printStackTrace();
		}catch(BrokenBarrierException e1){
			e1.printStackTrace();
		}
	}
	
}
