package daniel.java.corejava.util.concurrent.pconsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockBasket implements Basket {
	List<Apple> basket = new ArrayList<Apple>(10);
	Lock lock = new ReentrantLock();
	
	Condition isFull = lock.newCondition();
	Condition isEmpty = lock.newCondition();
	
	@Override
	public void add(Apple apple) throws InterruptedException {
		lock.lock();
		try{
			if(basket.size()>=10){
				isFull.await();
			}
			basket.add(apple);
			isEmpty.signalAll();
		}finally{
			lock.unlock();
		}
	}
	
	@Override
	public Apple obtain() throws InterruptedException{
		lock.lock();
		Apple apple;
		try{
			if(basket.size()<=0){
				isEmpty.await();
			}
			apple = basket.remove(0);
			isFull.signalAll();
		}finally{
			lock.unlock();
		}
		return apple;
	}
}
