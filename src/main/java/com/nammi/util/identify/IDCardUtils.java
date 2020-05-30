package com.nammi.util.identify;

import java.util.HashMap;
import java.util.Map;

public class IDCardUtils {
	
	public static final int CH_ID_MIN_LEN = 15;
	public static final int CH_ID_MAX_LEN = 18;
	
	public static final String[] provinceCode = {"11", "12", "13", "14", "15", 
		"21", "22", "23", "31", "32", "33", "34", "35", "36", "37", "41", 
		"42", "43", "44", "45", "46", "50", "51", "52", "53", "54", "61", 
		"62", "63", "64", "65", "71", "81", "82", "91",  
		};
	
	
	public static Map<String, String> provinceMap = new HashMap<String, String>();
	static{
		provinceMap.put("11", "北京");  
        provinceMap.put("12", "天津");  
        provinceMap.put("13", "河北");  
        provinceMap.put("14", "山西");  
        provinceMap.put("15", "内蒙古");  
        provinceMap.put("21", "辽宁");  
        provinceMap.put("22", "吉林");  
        provinceMap.put("23", "黑龙江");  
        provinceMap.put("31", "上海");  
        provinceMap.put("32", "江苏");  
        provinceMap.put("33", "浙江");  
        provinceMap.put("34", "安徽");  
        provinceMap.put("35", "福建");  
        provinceMap.put("36", "江西");  
        provinceMap.put("37", "山东");  
        provinceMap.put("41", "河南");  
        provinceMap.put("42", "湖北");  
        provinceMap.put("43", "湖南");  
        provinceMap.put("44", "广东");  
        provinceMap.put("45", "广西");  
        provinceMap.put("46", "海南");  
        provinceMap.put("50", "重庆");  
        provinceMap.put("51", "四川");  
        provinceMap.put("52", "贵州");  
        provinceMap.put("53", "云南");  
        provinceMap.put("54", "西藏");  
        provinceMap.put("61", "陕西");  
        provinceMap.put("62", "甘肃");  
        provinceMap.put("63", "青海");  
        provinceMap.put("64", "宁夏");  
        provinceMap.put("65", "新疆");  
        provinceMap.put("71", "台湾");  
        provinceMap.put("81", "香港");  
        provinceMap.put("82", "澳门");  
        provinceMap.put("91", "国外");
	}
	
	
	public static String showIDProvince(String cardNo){
		int len = cardNo.length();
		String provinceName = "";
		String sProNum = "";
		if(len==CH_ID_MIN_LEN || len==CH_ID_MAX_LEN){
			sProNum = cardNo.substring(0, 2);
		}
		provinceName = provinceMap.get(sProNum);
		System.out.println(cardNo+"始发号省份是："+provinceName);
		return provinceName;
	}
	
	public static void main(String[] args) {
		showIDProvince("421127123456123456");
	}
}
