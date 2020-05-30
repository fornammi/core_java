package com.nammi.corejava.collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapHelper {
	public static void main(String[] args) {
		/**
		 * 数据：Map中的value为Long类型
		 * 测试方法：获取value后进行修改，但是不再put进Map
		 * 测试结果：Map中的value没有变化
		 */
		Map<String, Long> map = new HashMap<String, Long>();
		String key = "nammi";
		Long val = map.get(key);
		if(val==null){
			val = new Long(1);
			map.put(key, val);
		}
		System.out.println("修改前："+map.get(key));
		val = new Long(2);
		System.out.println("修改后："+map.get(key));
		System.out.println("");
		
		/**
		 * 数据：Map的value为集合类型
		 * 测试方法：获取value后进行修改，但是不再put进Map
		 * 测试结果：Map中的value发生变化
		 */
		Map<String, Set<Long>> setMap = new HashMap<String, Set<Long>>();
		String setKey = "nammi";
		Set<Long> oldSet = setMap.get(setKey);
		if(oldSet==null){
			oldSet = new HashSet<Long>();
			setMap.put(setKey, oldSet);
		}
		for(Long data : oldSet){
			System.out.println("集合修改前:"+data);
		}
		oldSet.add(new Long(2));
		oldSet.add(new Long(3));
		Set<Long> newSet = setMap.get(key);
		for(Long data : newSet){
			System.out.println("集合修改后:"+data);
		}
	}
}
