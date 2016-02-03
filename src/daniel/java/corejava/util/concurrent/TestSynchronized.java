package daniel.java.corejava.util.concurrent;

public class TestSynchronized {
	private Object lock;
	public TestSynchronized(){
		lock = this;
	}
	
	public void write(){
		synchronized(lock){
			long startTime = System.currentTimeMillis();
			System.out.println("开始往这个buff写入数据…");
			for(;;){// 模拟要处理很长时间 
				if(System.currentTimeMillis() - startTime > Integer.MAX_VALUE){
					break;
				}
			}
			System.out.println("终于写完了");
		}
	}
	
	public void read(){
		synchronized(lock){
			System.out.println("从这个buff读数据");
		}
	}
	
	public static void main(String[] args) {
		TestSynchronized buff = new TestSynchronized();
		final Writer2 writer = new Writer2(buff);
		final Reader2 reader = new Reader2(buff);
		writer.start();
		reader.start();
		new Thread(new Runnable(){
			@Override
			public void run() {
				long start = System.currentTimeMillis();  
                for (;;) {  
                    //等5秒钟去中断读      
                    if (System.currentTimeMillis() - start > 5000) {  
                        System.out.println("[new Thread调用reader]不等了，尝试中断");  
                        reader.interrupt();  //尝试中断读线程  
                        break;  
                    }  
                }
			}
		}).start();
		// 我们期待“读”这个线程能退出等待锁，可是事与愿违，一旦读这个线程发现自己得不到锁，  
        // 就一直开始等待了.但是就算它等死，也得不到锁，因为写线程要21亿秒才能完成 T_T.即使
		// 我们中断它，  它都不来响应下，看来真的要等死了。
	}
	
}

class Writer2 extends Thread{
	private TestSynchronized buff;
	public Writer2(TestSynchronized buff) {
		this.buff = buff;
	}
	@Override
	public void run() {
		buff.write();
	}
}

class Reader2 extends Thread{
	private TestSynchronized buff;
	public Reader2(TestSynchronized buff){
		this.buff = buff;
	}
	@Override
	public void run() {
		buff.read();//这里估计会一直阻塞 
		System.out.println("[reader]读结束");
	}
}
