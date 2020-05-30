package com.nammi.concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class TestReentrantLock {
	private ReentrantLock lock = new ReentrantLock();
	
	public void write(){
		lock.lock();
		try{
			long startTime = System.currentTimeMillis();
			System.out.println("开始往这个buff写入数据…");
			for(;;){// 模拟要处理很长时间
				if(System.currentTimeMillis() - startTime > Integer.MAX_VALUE){
					break;
				}
			}
			System.out.println("终于写完了");
		}finally{
			lock.unlock();
		}
	}
	
	public void read() throws InterruptedException{
		lock.lockInterruptibly();// 注意这里，可以响应中断
		try{
			System.out.println("从这个buff读数据");
		}finally{
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		TestReentrantLock buff = new TestReentrantLock();
		final Writer writer = new Writer(buff);
		final Reader reader = new Reader(buff);
		writer.start();
		reader.start();
		new Thread(new Runnable(){
			@Override
			public void run() {
				long startTime = System.currentTimeMillis();
				for(;;){
					if(System.currentTimeMillis() - startTime > 5000){
						System.out.println("[new Thread调用reader]不等了，尝试中断");
						reader.interrupt();//此处中断读操作
						break;
					}
				}
			}
		}).start();
	}
}

class Writer extends Thread{
	private TestReentrantLock buff;
	public Writer(TestReentrantLock buff) {
		this.buff = buff;
	}
	@Override
	public void run() {
		buff.write();
	}
}


class Reader extends Thread{
	private TestReentrantLock buff;
	public Reader(TestReentrantLock buff) {
		this.buff = buff;
	}
	@Override
	public void run() {
		try{
			buff.read();//可以收到中断的异常，从而有效退出
		}catch(InterruptedException e){
			System.out.println("[reader]我不读了");
		}
		System.out.println("[reader]读结束");
	}
}
