package com.nammi.corejava.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class ListHelper {
	
	/**
	 * 删除List中的偶数
	 * @param intList
	 */
	public static void deleteEvenInList(List intList){
		for(int i=0; i<intList.size();){
			int d = (Integer)(intList.get(i));
			if(d%2 == 0){
				intList.remove(i);
			}else{
				i++;
			}
		}
		for(int i=0; i<intList.size(); i++){
			System.out.println("List["+i+"]:"+intList.get(i));
		}
	}
	
	/**
	 * 删除List中的元素：使用iterator
	 * @param intList
	 */
	public static void deleteEvenByIt(List intList){
		Iterator it = intList.iterator();
		while(it.hasNext()){
			int data = (Integer)it.next();
			if(data%2 == 0){
				it.remove();
			}
		}
		for(int i=0; i<intList.size(); i++){
			System.out.println("List["+i+"]:"+intList.get(i));
		}
	}
	
	
	/**
	 * List拆分成固定容量的subList
	 * @param intList
	 */
	public static void splitList2(List intList, int split){
		int listSize = intList.size();
		int count =  (listSize%split==0) ? (listSize/split) : (listSize/split+1);
		for(int i=0; i<count; i++){
			List subList = new ArrayList();
			if((listSize%split!=0) && (i==(count-1))){
				subList = intList.subList(split*i, listSize);
			}else{
				subList = intList.subList(split*i, split*(i+1));
			}
			System.out.print("第"+(i+1)+"组: ");
			for(int j=0; j<subList.size(); j++){
				if(j==0){
					System.out.print(subList.get(j));
					continue;
				}
				System.out.print(", "+subList.get(j));
			}
			System.out.println();
		}
	}

	public static void genSubList(List list, int perSize) {

		int times = list.size() / perSize;

		int cycleIndex = 0;

		while (cycleIndex <= times) {
			List listTemp = null;

			if (list.size() >= perSize) {
				listTemp = list.subList(0, perSize);
			} else {
				listTemp = list.subList(0, list.size());
			}
			System.out.println("listTemp.size="+listTemp.size());
			list.removeAll(listTemp);

			System.out.println("list.size="+list.size());

			cycleIndex++;
		}
	}
	
	/**
	 * 统计List中值相等元素的个数
	 * @param intList
	 */
	public static Map getAllEqualElementCount(List intList){
		Map resultMap = new HashMap();
		if(intList==null || intList.size()<0){
			return null;
		}
		int size = intList.size();
		int ref = (Integer)intList.get(0);
		resultMap.put(ref, 1);
		for(int i=1; i<size; i++){
			int cur = (Integer)intList.get(i);
			if(cur==ref){
				int count = (Integer)resultMap.get(cur);
				resultMap.put(cur, ++count);
			}else{
				Object obj = resultMap.get(cur);
				if(obj!=null){
					int count = (Integer)obj;
					resultMap.put(cur, ++count);
				}else{
					resultMap.put(cur, 1);
				}
				ref = cur;
			}
		}
		return resultMap;
	}
	
	/**
	 * 集合运算
	 */
	public static void listOpe(){
		List list1 = new ArrayList();
		list1.add("1111");
		list1.add("2222");
		list1.add("3333");

		List list2 = new ArrayList();
		list2.add("3333");
		list2.add("4444");
		list2.add("5555");

		// 并集
		//list1.addAll(list2);
		// 交集
		list1.retainAll(list2);
		// 差集
		//list1.removeAll(list2);
		// 无重复并集
		//list2.removeAll(list1);
		//list1.addAll(list2);

		Iterator<String> it = list1.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	public static void main(String[] args) {
		List intList = new ArrayList();

		for(int i=0; i<9; i++){
			intList.add(i);
		}

		genSubList(intList, 10);

		int times = 39 / 11;
		System.out.println(times);

		/*deleteEvenInList(intList);
		deleteEvenByIt(intList);
		System.out.println(intList.size()+"个元素，每10个一组");
		splitList(intList, 10);*/
		
		//统计List中值相等元素的个数
		/*for(int i=0; i<10; i++){
			int tmp = new Random().nextInt(5);
			System.out.println(tmp);
			intList.add(tmp);
		}
		Map resultMap = getAllEqualElementCount(intList);
		Set<Map.Entry> set = resultMap.entrySet();
		Iterator<Map.Entry> it = set.iterator();
		while(it.hasNext()){
			Map.Entry entry = (Map.Entry)it.next();
			System.out.println(entry.getKey()+"="+entry.getValue());
		}*/
		
		/*Map<Long,Long> cntMap = new HashMap<Long,Long>();
		cntMap.put(1L,1L);
		Collection<Long> c = cntMap.values();
		Long[] temp = new Long[]{};
		Long[] cntArray = c.toArray(temp);
		List<Long> cntList = Arrays.asList(cntArray);
		Collections.sort(cntList);
		System.out.println(cntList.get(0));*/
		
		//listOpe();
	}
}
