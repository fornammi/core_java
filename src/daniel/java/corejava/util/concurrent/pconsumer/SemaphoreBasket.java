package daniel.java.corejava.util.concurrent.pconsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
/**
 * acquire()申请许可证，如果有，就可以获得；如果没有，就等待。就是减操作，如果小于0，就阻塞
 * release()归还许可证，保证循环使用。就是加操作，如果大于0，就不会被阻塞 
 * @author daniel.fang
 *
 */
public class SemaphoreBasket implements Basket {
	private List<Apple> basket = new ArrayList<Apple>(10);
	Semaphore isEmpty = new Semaphore(0);
	Semaphore mutex = new Semaphore(1);
	Semaphore isFull = new Semaphore(10);
	
	@Override
	public void add(Apple apple) throws InterruptedException{
		isFull.acquire();
		try{
			mutex.acquire();
			basket.add(apple);
		}finally{
			mutex.release();
			isEmpty.release();
		}
	}
	
	@Override
	public Apple obtain() throws InterruptedException{
		Apple apple;
		isEmpty.acquire();
		try{
			mutex.acquire();
			apple = basket.remove(0);
		}finally{
			mutex.release();
			isFull.release();
		}
		return apple;
	}
}
