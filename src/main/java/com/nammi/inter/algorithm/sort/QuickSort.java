package com.nammi.inter.algorithm.sort;

import java.util.Arrays;

public class QuickSort {
	private int sortCount = 0;	//排序趟数
	public int getMiddle(Integer[] list, int low, int high) {
		sortCount++;
		int tmp = list[low]; // 数组的第一个元素作为中轴
		while (low < high) {
			//最大索引处记录比中轴大，则下标移动到（最大索引-1），继续比较
			while (low < high && list[high] > tmp) {
				high--;
			}
			list[low] = list[high]; // 比中轴小的记录移到低端
			//最小索引处记录比中轴小，则下标移动到（最小索引+1），继续比较
			while (low < high && list[low] < tmp) {
				low++;
			}
			list[high] = list[low]; // 比中轴大的记录移到高端
		}
		list[low] = tmp; // 中轴记录到尾
		System.out.println("第"+sortCount+"趟排序结果:" + Arrays.toString(list));
		return low; // 返回中轴的位置
	}

	public void _quickSort(Integer[] list, int low, int high) {
		if (low < high) {
			int middle = getMiddle(list, low, high); // 将list数组一分为二
			_quickSort(list, low, middle - 1); // 对低字表进行递归排序
			_quickSort(list, middle + 1, high); // 对高字表进行递归排序
		}
	}

	public void quick(Integer[] str) {
		if (str.length > 0) { // 查看数组是否为空
			_quickSort(str, 0, str.length - 1);
		}
	}

	public static void main(String[] args) {
		Integer[] list = { 34, 3, 53, 2, 23, 7, 14, 10 };
		QuickSort qs = new QuickSort();
		qs.quick(list);
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
		System.out.println();
	}
}