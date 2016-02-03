package daniel.fang.algorithm.sort;

public class SelectSort {
	public void selectSort(int[] a) {
		int position = 0;
		for (int i = 0; i < a.length; i++) { //待排序序列的第一元素，索引逐渐增大
			int j = i + 1;
			position = i;
			int temp = a[i];
			for (; j < a.length; j++) {
				if (a[j] < temp) {
					temp = a[j]; //temp始终保存待排序序列中的最小值
					position = j; //position始终保存待排序序列中的最小值的索引
				}
			}
			//最小值和第一元素交换位置
			a[position] = a[i]; //第一元素值放到最小值处
			a[i] = temp; //最小值放到第一元素位置
		}
		for (int i = 0; i < a.length; i++){
			System.out.print(a[i]+" ");
		}
	}
	
	public static void main(String[] args) {
		int a[] = { 1, 54, 6, 3, 78, 34, 12, 45 };
		new SelectSort().selectSort(a);
	}
}
