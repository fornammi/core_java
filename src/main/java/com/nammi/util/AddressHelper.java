package com.nammi.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class AddressHelper {
	
	public static Map<String,String> municipalityMap = new HashMap<String,String>();
	public static Map<String,String> provinceMap = new HashMap<String,String>();
	static{
		municipalityMap.put("11", "北京");
		municipalityMap.put("12", "天津");
		municipalityMap.put("31", "上海");
		municipalityMap.put("50", "重庆");
		
        provinceMap.put("13", "河北");  
        provinceMap.put("14", "山西");  
        provinceMap.put("15", "内蒙古");  
        provinceMap.put("21", "辽宁");  
        provinceMap.put("22", "吉林");  
        provinceMap.put("23", "黑龙江");  
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
	}
	
	/**
	 * 设定:oracle库中一个汉字占用3个字节，一个英文字符占用1个字节
	 * @param str
	 */
	public static void countByteOfStringInOracle(String str){
		if(str!=null && str.length()>0){
			int len = 0;
			for(int i=0; i<str.length(); i++){
				char c = str.charAt(i);
				int clen = 0;
				if(c>=0 && c<127){
					clen = 1;
				}else{
					clen = 3;
				}
				len += clen;
			}
			System.out.println("[字符串所占用的数据库的字节长度]为"+len);
		}
	}
	
	/**
	 * 解析地址
	 * @param addrStr
	 */
	public static void resolveAddr(String addrStr){
		String provinceStr="";
		String cityStr="";
		String districtStr="";
		String countyStr="";
		if(addrStr!=null){
			Set<String> set = municipalityMap.keySet();
			boolean isMunicipality = false;
			for(Iterator it = set.iterator();it.hasNext();){
				String key = (String)it.next();
				String val = municipalityMap.get(key);
				if(addrStr.contains(val)){
					isMunicipality = true;
					provinceStr = val;
					cityStr = val+"市";
					break;//找到匹配的，循环可以终止
				}
			}
			
			//1、直辖市
			if(isMunicipality){
				String val = provinceStr;
				if(addrStr.contains("市")){
					String tempDisStr = addrStr.split("市")[1];
					if(tempDisStr.contains("区")&&tempDisStr.contains("县")){
						String[] d = tempDisStr.split("区");
						districtStr = d[0]+"区";
						countyStr = d[1].split("县")[0];
					}else if(tempDisStr.contains("区")&&!tempDisStr.contains("县")){
						String[] d = tempDisStr.split("区");
						districtStr = d[0]+"区";
					}else if(!tempDisStr.contains("区")&&tempDisStr.contains("县")){
						String[] d = tempDisStr.split("县");
						districtStr = d[0]+"县";
					}else{
						System.out.println("地址中不包括区、县");
					}
				}else{
					int valIndex = addrStr.lastIndexOf(val);
					String tempDisStr = addrStr.substring(valIndex+val.length());
					if(tempDisStr.contains("区")&&tempDisStr.contains("县")){
						String[] d = tempDisStr.split("区");
						districtStr = d[0]+"区";
						countyStr = d[1].split("县")[0];
					}else if(tempDisStr.contains("区")&&!tempDisStr.contains("县")){
						String[] d = tempDisStr.split("区");
						districtStr = d[0]+"区";
					}else if(!tempDisStr.contains("区")&&tempDisStr.contains("县")){
						String[] d = tempDisStr.split("县");
						districtStr = d[0]+"县";
					}else{
						System.out.println("地址中不包括区、县");
					}
				}
			}else{	//非直辖市
				Collection c = provinceMap.keySet();
				if(addrStr.contains("省")){
					provinceStr = addrStr.split("省")[0]+"省";
					if(addrStr.contains("市")){
						String tempDisStr = addrStr.split("市")[1];
						if(tempDisStr.contains("区")&&tempDisStr.contains("县")){
							String[] d = tempDisStr.split("区");
							districtStr = d[0]+"区";
							countyStr = d[1].split("县")[0];
						}else if(tempDisStr.contains("区")&&!tempDisStr.contains("县")){
							String[] d = tempDisStr.split("区");
							districtStr = d[0]+"区";
						}else if(!tempDisStr.contains("区")&&tempDisStr.contains("县")){
							String[] d = tempDisStr.split("县");
							districtStr = d[0]+"县";
						}else{
							System.out.println("地址中不包括区、县");
						}
					}else{
						String tempDisStr = addrStr.split("省")[1];
						if(tempDisStr.contains("区")&&tempDisStr.contains("县")){
							String[] d = tempDisStr.split("区");
							districtStr = d[0]+"区";
							countyStr = d[1].split("县")[0];
						}else if(tempDisStr.contains("区")&&!tempDisStr.contains("县")){
							String[] d = tempDisStr.split("区");
							districtStr = d[0]+"区";
						}else if(!tempDisStr.contains("区")&&tempDisStr.contains("县")){
							String[] d = tempDisStr.split("县");
							districtStr = d[0]+"县";
						}else{
							System.out.println("地址中不包括区、县");
						}
					}
				}else{	//没有"省"
					if(addrStr.contains("市")){
						String tempDisStr = addrStr.split("市")[1];
						if(tempDisStr.contains("区")&&tempDisStr.contains("县")){
							String[] d = tempDisStr.split("区");
							districtStr = d[0]+"区";
							countyStr = d[1].split("县")[0];
						}else if(tempDisStr.contains("区")&&!tempDisStr.contains("县")){
							String[] d = tempDisStr.split("区");
							districtStr = d[0]+"区";
						}else if(!tempDisStr.contains("区")&&tempDisStr.contains("县")){
							String[] d = tempDisStr.split("县");
							districtStr = d[0]+"县";
						}else{
							System.out.println("地址中不包括区、县");
						}
					}else{
						String tempDisStr = addrStr;
						if(tempDisStr.contains("区")&&tempDisStr.contains("县")){
							String[] d = tempDisStr.split("区");
							districtStr = d[0]+"区";
							countyStr = d[1].split("县")[0];
						}else if(tempDisStr.contains("区")&&!tempDisStr.contains("县")){
							String[] d = tempDisStr.split("区");
							districtStr = d[0]+"区";
						}else if(!tempDisStr.contains("区")&&tempDisStr.contains("县")){
							String[] d = tempDisStr.split("县");
							districtStr = d[0]+"县";
						}else{
							System.out.println("地址中不包括区、县");
						}
					}
				}
			}
		}
		
		System.out.println("省："+provinceStr);
		System.out.println("市："+cityStr);
		System.out.println("区："+districtStr);
		System.out.println("县："+countyStr);
	}
	
	public static void main(String[] args) {
		String testStr = "快钱kuaiqian支zhi付fuqingsuan清算";//预期18+21=39
		countByteOfStringInOracle(testStr);
	}
}
