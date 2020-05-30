package com.nammi.concurrent.pconsumer;

public class Consumer implements Runnable{
	private Basket basket;
	private String name;
	public Consumer(Basket basket, String name) {
		this.basket = basket;
		this.name = name;
	}
	
	@Override
	public void run() {
		while(true){
			try{
				System.out.println("-----"+name+":consume["+basket.obtain()+"]-----");
			}catch(Exception e){
				e.printStackTrace();
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		
	}
}
