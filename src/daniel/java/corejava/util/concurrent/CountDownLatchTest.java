package daniel.java.corejava.util.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * // 模拟了100米赛跑，10名选手已经准备就绪，只等裁判一声令下。当所有人都到达终点时，比赛结束。
 * @author daniel.fang
 *
 */
public class CountDownLatchTest {
	public static void main(String[] args) throws InterruptedException{
		// 开始的倒数锁 
		final CountDownLatch begin = new CountDownLatch(1);
		// 结束的倒数锁
		final CountDownLatch end = new CountDownLatch(10);
		// 十名选手
		final ExecutorService exec = Executors.newFixedThreadPool(10);
		for(int i=0; i<10; i++){
			final int num = i + 1;
			Runnable run = new Runnable(){
				@Override
				public void run() {
					try{
						// 如果当前计数为零，则此方法立即返回。
						// 等待
						begin.await();
						Thread.sleep((long)Math.random()*10000);
						System.out.println("No."+num+" arrived");
					}catch(InterruptedException e){
						
					}finally{
						// 每个选手到达终点时，end就减一
						end.countDown();
					}
				}
			};
			exec.execute(run);
		}
		System.out.println("Game Start");
		// begin减一，开始游戏；递减到0，启动所有线程
		begin.countDown();
		// 等待end变为0，即所有选手到达终点，才启动当前线程(即main)
		// 如果当前计数为零，则await方法立即返回，返回等待线程
		end.await();
		System.out.println("Game Over");
		exec.shutdown();
	}
}
