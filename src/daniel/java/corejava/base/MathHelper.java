package daniel.java.corejava.base;

public class MathHelper {
	
	/**
	 * random.nextInt(n)随机返回[0,n)集合中的整数，注意不包括n
	 * 
	 * +1后，随机返回[1,n+1)集合中的整数
	 * @param n
	 * @return
	 */
	public static int getRandomInt(int n){
		java.util.Random random = new java.util.Random();
		int result = random.nextInt(n);
		return result+1;
	}
	
	
	public static void main(String[] args) {
		
		//测试位移运算符
		/*long a = 200L;
		long b = a>>>3;
		System.out.println(b);*/
		
		System.out.println(MathHelper.getRandomInt(10));
	}
	
}
