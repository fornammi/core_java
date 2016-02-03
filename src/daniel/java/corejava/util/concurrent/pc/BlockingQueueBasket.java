package daniel.java.corejava.util.concurrent.pc;

import java.util.concurrent.ArrayBlockingQueue;

public class BlockingQueueBasket implements Basket {
	ArrayBlockingQueue basket = new ArrayBlockingQueue(3);
	
	@Override
	public void add(Apple apple) throws InterruptedException{
		if(basket.size()>=3){
			System.out.println("add block,please waiting...");
		}
		basket.put(apple);
	}
	
	@Override
	public Apple obtain() throws InterruptedException{
		if(basket.size() == 0){
			System.out.println("get block,there is no food...");
		}
		return (Apple)basket.take();
	}
}
