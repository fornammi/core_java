package daniel.java.corejava.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ArrayHelper {
	/**
	 * 找出连续递增1的最长子串：
	 * 长度相同的多个子串，都要输出
	 * @param intArr
	 */
	public static void findLengthestAscSequ(int[] intArr){
		if(intArr==null || intArr.length<=0){
			System.out.println("intArr is blank");
			return;
		}
		int len = intArr.length;
		//Map<结束索引,子串长度>
		Map<Integer, Integer> resultMap = new HashMap<Integer, Integer>();
		//记录子串
		List tempList = new ArrayList();
		//子串最大长度
		int maxSize = 0;
		for(int i=0; i<len-1; i++){
			//System.out.println("i="+i);
			if(intArr[i+1]-intArr[i]==1){
				//第一次添加元素，需要额外add当前元素
				if(tempList.size()<=0){
					tempList.add(intArr[i]);
				}
				//满足递增条件，add后一位
				tempList.add(intArr[i+1]);
				//倒数第二位，特别处理，结束循环
				if(i==len-2){
					int tmpSize = tempList.size();
					//此时，最后一位-倒数第二位=1，记录(结束索引,子串长度)
					resultMap.put(i+1,tmpSize);
					if(tmpSize>maxSize){
						maxSize = tmpSize;
					}
					break;
				}
			}else{//后一位相比当前，没有递增
				if(tempList.size()>0){
					int tmpSize = tempList.size();
					//记录(结束索引,子串长度)
					resultMap.put(i,tmpSize);
					//清空list,准备记录下一个子串
					tempList = new ArrayList();
					if(tmpSize>maxSize){
						maxSize = tmpSize;
					}
				}
			}
		}
		
		System.out.println("最长的连续递增的数列为：");
		Set<Map.Entry<Integer, Integer>> entrySet = resultMap.entrySet();
		for(Iterator<Map.Entry<Integer, Integer>> it = entrySet.iterator(); it.hasNext();){
			Map.Entry<Integer, Integer> entry = it.next();
			if(entry.getValue() == maxSize){
				int end = entry.getKey();
				int start = end - maxSize + 1;
				//输出起始索引~结束索引之间的元素
				for(int i=start; i<=end; i++){
					if(i==start){
						System.out.print(intArr[i]);
						continue;
					}
					System.out.print(","+intArr[i]);
				}
				System.out.println();
			}
		}
	}
	
	public static void main(String[] args) {
		int[] intArr = {1,2,3,4,5,89,2,73,4,5,6,7,8,10,12,15,6,7,8,9,10,23,54,10,11,12,13,14};
		findLengthestAscSequ(intArr);
	}
}
