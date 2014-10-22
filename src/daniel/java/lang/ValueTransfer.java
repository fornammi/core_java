package daniel.java.lang;

public class ValueTransfer {
	public static void swapString(String s1, String s2){
		String tmp = s1;
		s1 = s2;
		s2 = tmp;
		System.out.println("swapString：s1 is "+s1+" || s2 is "+s2);
	}
	
	public static void swapInteger(Integer i1, Integer i2){
		Integer tmp = i1;
		i1 = i2;
		i2 = tmp;
		System.out.println("swapInteger：i1 is "+i1+" || i2 is "+i2);
	}
	
	public static void main(String[] args) {
		String s1 = "1";
		String s2 = "2";
		System.out.println("main：swap前s1 is "+s1+" || s2 is "+s2);
		swapString(s1, s2);
		System.out.println("main：swap后s1 is "+s1+" || s2 is "+s2);
		System.out.println("====================================");
		Integer i1 = new Integer(1);
		Integer i2 = new Integer(2);
		System.out.println("main：swap前i1 is "+i1+" || i2 is "+i2);
		swapInteger(i1, i2);
		System.out.println("main：swap后i1 is "+i1+" || i2 is "+i2);
		System.out.println("====================================");
	}
}
