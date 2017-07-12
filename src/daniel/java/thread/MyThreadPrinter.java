package daniel.java.thread;

public class MyThreadPrinter implements Runnable {
	private String name;
	private Object pre;
	private Object self;
	
	public MyThreadPrinter(String name, Object pre, Object self) {
		this.name = name;
		this.pre = pre;
		this.self = self;
	}

	
	@Override
	public void run() {
		int count = 10;
		while(count > 0){
			synchronized(pre){//获取前置对象pre的锁
				synchronized(self){//锁住当前对象，则需要当前对象的线程必须等待
					System.out.print(name);
					count--;
					/**
					 * 唤醒等待self这个对象的线程，
					 * 比如当前是A线程运行，self=A对象，正好是B线程所需要的pre
					 * 则唤醒B线程
					 */
					self.notify();
				}
				try {
					pre.wait();//释放pre
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 三线程ABC，循环打印ABC
	 * 
	 */
	public static void main(String[] args) throws Exception {
		Object a = new Object();
		Object b = new Object();
		Object c = new Object();
		
		MyThreadPrinter pa = new MyThreadPrinter("A", c, a);
		MyThreadPrinter pb = new MyThreadPrinter("B", a, b);
		MyThreadPrinter pc = new MyThreadPrinter("C", b, c);
		
		new Thread(pa).start();
		Thread.sleep(1000);
		new Thread(pb).start();
		Thread.sleep(1000);
		new Thread(pc).start();
		Thread.sleep(1000);
	}
	
	
}
