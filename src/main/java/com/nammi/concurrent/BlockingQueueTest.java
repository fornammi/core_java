package com.nammi.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {
	
	public static void doBlockingQueue() throws InterruptedException {
		BlockingQueue<String> bQueue = new ArrayBlockingQueue<String>(20);
		for(int i=1; i<=30; i++){
			bQueue.put(""+i);
			System.out.println("向阻塞队列中添加了元素:" + i);
			if(i>19){
				//获取并移除此队列的头部
				System.out.println("【获取并移除此队列的头部:" + bQueue.take()+"】");
			}
		}
		System.out.println("-----程序到此运行结束，即将退出-----");
	}

	public static void main(String[] args) {
		try {
			BlockingQueueTest.doBlockingQueue();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
