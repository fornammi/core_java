package daniel.java.corejava.base.initOrder;

public class TestTwiceInitialOrder {
	public TestTwiceInitialOrder(int index){
		System.out.println("constructor "+index);
	}
	
	static{
		System.out.println("static block");
	}
	
	{
		System.out.println("block");
	}
	
	public static void main(String[] args) {
		new TestTwiceInitialOrder(1);
		new TestTwiceInitialOrder(2);
	}
}
