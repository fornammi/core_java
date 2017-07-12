package daniel.java.corejava.util.concurrent.pconsumer;

public class Producer implements Runnable {
	private Basket basket;
	private String name;
	public Producer(Basket basket, String name) {
		this.basket = basket;
		this.name = name;
	}

	@Override
	public void run() {
		while(true){
			try{
				Apple apple = new Apple("apple"+Math.random()*100);
				basket.add(apple);
				System.out.println(name +":produce["+ apple.toString()+"]");
			}catch(Exception e){
				e.printStackTrace();
			}
			
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e1){
				e1.printStackTrace();
			}
		}
	}
}
