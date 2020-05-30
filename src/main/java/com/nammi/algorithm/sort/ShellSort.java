package com.nammi.algorithm.sort;

public class ShellSort {
	public void shellSort(int[] a) {
		double d1 = a.length;
		int temp = 0;
		while (true) {
			d1 = Math.ceil(d1 / 2);
			int d = (int) d1;
			for (int x = 0; x < d; x++) {
				//内部使用插入排序(将1换成d)
				for (int i = x + d; i < a.length; i += d) {
					int j = i - d;
					temp = a[i];
					for (; j >= 0 && temp < a[j]; j -= d) {
						a[j + d] = a[j];
					}
					a[j + d] = temp;
				}
			}
			if (d == 1)
				break;
		}
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i]+" ");
	}
	
	public static void main(String[] args) {
		int[] a = { 1, 54, 6, 3, 78, 34, 12, 45, 56, 100 };
		
		new ShellSort().shellSort(a);
	}
}