package daniel.fang.algorithm.search;

public class BinarySearch {

	public static int recursionBinarySearch(int a, int[] arr, int beginIndex, int endIndex){
		if(arr==null || arr.length<=0
				|| beginIndex<0 || endIndex<0
				|| beginIndex>endIndex){
			return -1;
		}
		int midIndex = (beginIndex + endIndex) / 2;
		if(a<arr[midIndex]){
			return recursionBinarySearch(a, arr, beginIndex, midIndex-1);
		}else if(a>arr[midIndex]){
			return recursionBinarySearch(a, arr, midIndex+1, endIndex);
		}else{
			return midIndex;
		}
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
