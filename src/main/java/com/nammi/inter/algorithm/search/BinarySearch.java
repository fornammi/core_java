package com.nammi.inter.algorithm.search;

/**
 * 二分查找法
 */
public class BinarySearch {

	/**
	 * 二分查找-递归
	 * @param a	待查找元素
	 * @param arr 递增排序的数组
	 * @param beginIndex
	 * @param endIndex
	 * @return	-1表示未找到
	 */
	public static int recursionBinarySearch(int a, int[] arr, int beginIndex, int endIndex){
		if(arr==null || arr.length<=0 || beginIndex<0 || endIndex<0 || beginIndex>endIndex){
			return -1;
		}
		int midIndex = (beginIndex + endIndex) / 2;
		if(a < arr[midIndex]) {
			return recursionBinarySearch(a, arr, beginIndex, midIndex - 1);
		}

		if( a > arr[midIndex]) {
			return recursionBinarySearch(a, arr, midIndex + 1, endIndex);
		}

		return midIndex;
	}
	
	public static void main(String[] args) {
		int[] arr = {9, 11, 13, 17, 20, 25, 29, 34, 36, 37, 40, 51, 62, 79, 87, 91};
		int a = 1;
		int beginIndex = 0;
		int endIndex = arr.length - 1;
		int index = recursionBinarySearch(a, arr, beginIndex, endIndex);
		System.out.println(a + " at " + "arr[" + index + "]");
	}
}
