package daniel.java.corejava.base;

import java.util.ArrayList;
import java.util.List;

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
	
	/**
	 * 总个数固定、总和固定的随机数序列
	 * @param n	总和
	 * @param size	求和正整数的个数
	 * @param group 组数
	 * @return
	 */
	public static void getRandomIntSameSum(int n, int size, int group){
		int sum = 0;
		int count = 0;
		for(int i=0; i<Integer.MAX_VALUE; i++){
			List<Integer> intList = new ArrayList<Integer>();
			for(int j=0; j<size-1; j++){
				int temp = getRandomInt(n/2);
				sum += temp;
				if(j<(size-2) && sum>n){//未达到size是，sum已经超过n
					intList.clear();
					sum=0;
					continue;
				}
				intList.add(temp);
				//生成size-1个，总和小于n
				if(j==(size-2)&&sum<n&&intList.size()==(size-1)){
					count++;
					System.out.println("====="+count+"=====");
					for(int k=0; k<intList.size(); k++){
						if(k!=0){
							System.out.print(", ");
						}
						System.out.print(intList.get(k));
					}
					System.out.print(", "+(n-sum));
					System.out.println("");
				}
			}
			if(count==group){//组数
				break;
			}
		}
	}
	
	
	public static void main(String[] args) {
		//测试位移运算符
		/*long a = 200L;
		long b = a>>>3;
		System.out.println(b);*/
		
		//System.out.println(MathHelper.getRandomInt(10));
		getRandomIntSameSum(5000, 10, 200);
		
	}
	
}
