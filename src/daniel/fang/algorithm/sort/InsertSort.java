package daniel.fang.algorithm.sort;

public class InsertSort {
	public void insertSort(int[] a) {
		int temp = 0;
		for (int i = 1; i < a.length; i++) {
			int j = i - 1;
			temp = a[i];
			/**
			 * (1)第一轮比较:j=i-1时,如果a[j]<temp,那么for循环结束
			 * 原理：
			 * 因为0~j是已经排好序的,如果a[j]<temp,那么j前面的肯定都小于temp,
			 * 那么②处代码就是将temp赋值给a[i],因a[i]本就等于temp，所以不造成影响
			 * (2)如果a[j]>temp,则执行循环体,然后j--;在不满足j >= 0 && temp < a[j],即
			 * j=-1或者temp>=a[j]时,跳出for循环，此时j会处在 最后一个比temp大的值a[j]的左边一位
			 */
			for (; j >= 0 && temp < a[j]; j--) {
				a[j + 1] = a[j]; // ①：将大于temp的值逐个后移一位
			}
			/**
			 * 原理：如果for循环执行多次，则j会处在 最后一个比temp大的值a[j] 的左边一位，也即现在的j是原来j前移一位（j--）
			 * 由于原来的a[j]已经赋值给原来的a[j+1](后移一位),那么tmp赋值给现在的a[j+1],也就是填补原来的a[j]的空位
			 * 这样，所有大于temp的值逐个后移一个单位，最前面的位置就由temp来填补，就实现了排序
			 */
			//②：
			a[j + 1] = temp;
		}
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
	}
	
	public static void main(String[] args) {
		int[] a = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62,
				99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51 };
		new InsertSort().insertSort(a);
	}
}