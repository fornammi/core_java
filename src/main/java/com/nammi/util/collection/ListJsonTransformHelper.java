package com.nammi.util.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nammi.entity.CreditInfoPI;

public class ListJsonTransformHelper {

	//json 外层是{}
	public static final String jsonObjectStr = "{\"infos\":[{\"clientName\":\"\",\"createTime\":null,\"csrq\":\"19820224\",\"errorCode\":\"\",\"errorMsg\":\"\",\"id\":0,\"infoDate\":null,\"legalPersonId\":\"\",\"legalPersonName\":\"\",\"orderField\":\"\",\"orderId\":\"\",\"requestNo\":\"\",\"resultGmsfhm\":\"一致\",\"resultXm\":\"一致\",\"whcd\":\"大学本科（简称“大学”）\",\"xb\":\"女性\",\"xp\":\"\",\"zy\":\"干部\",\"zz\":\"北京市海淀区集体三里\"},{\"clientName\":\"\",\"createTime\":null,\"csrq\":\"\",\"errorCode\":\"\",\"errorMsg\":\"服务结果:库中无此号，请到户籍所在地进行核实\",\"id\":0,\"infoDate\":null,\"legalPersonId\":\"\",\"legalPersonName\":\"\",\"orderField\":\"\",\"orderId\":\"\",\"requestNo\":\"\",\"resultGmsfhm\":\"\",\"resultXm\":\"\",\"whcd\":\"\",\"xb\":\"\",\"xp\":\"\",\"zy\":\"\",\"zz\":\"\"},{\"clientName\":\"\",\"createTime\":null,\"csrq\":\"\",\"errorCode\":\"\",\"errorMsg\":\"\",\"id\":0,\"infoDate\":null,\"legalPersonId\":\"\",\"legalPersonName\":\"\",\"orderField\":\"\",\"orderId\":\"\",\"requestNo\":\"\",\"resultGmsfhm\":\"一致\",\"resultXm\":\"不一致\",\"whcd\":\"\",\"xb\":\"\",\"xp\":\"\",\"zy\":\"\",\"zz\":\"\"},{\"clientName\":\"\",\"createTime\":null,\"csrq\":\"\",\"errorCode\":\"\",\"errorMsg\":\"业务类型属性为空\",\"id\":0,\"infoDate\":null,\"legalPersonId\":\"\",\"legalPersonName\":\"\",\"orderField\":\"\",\"orderId\":\"\",\"requestNo\":\"\",\"resultGmsfhm\":\"\",\"resultXm\":\"\",\"whcd\":\"\",\"xb\":\"\",\"xp\":\"\",\"zy\":\"\",\"zz\":\"\"},{\"clientName\":\"\",\"createTime\":null,\"csrq\":\"\",\"errorCode\":\"\",\"errorMsg\":\"必录项缺失\",\"id\":0,\"infoDate\":null,\"legalPersonId\":\"\",\"legalPersonName\":\"\",\"orderField\":\"\",\"orderId\":\"\",\"requestNo\":\"\",\"resultGmsfhm\":\"\",\"resultXm\":\"\",\"whcd\":\"\",\"xb\":\"\",\"xp\":\"\",\"zy\":\"\",\"zz\":\"\"}]}";
	//JSONArray 在json的{}外面还有[]
	public static final String jsonArrayStr = "[{\"clientName\":\"\",\"createTime\":null,\"csrq\":\"19820224\",\"errorCode\":\"\",\"errorMsg\":\"\",\"id\":0,\"infoDate\":null,\"legalPersonId\":\"\",\"legalPersonName\":\"\",\"orderField\":\"\",\"orderId\":\"\",\"requestNo\":\"\",\"resultGmsfhm\":\"一致\",\"resultXm\":\"一致\",\"whcd\":\"大学本科（简称“大学”）\",\"xb\":\"女性\",\"xp\":\"\",\"zy\":\"干部\",\"zz\":\"北京市海淀区集体三里\"},{\"clientName\":\"\",\"createTime\":null,\"csrq\":\"\",\"errorCode\":\"\",\"errorMsg\":\"服务结果:库中无此号，请到户籍所在地进行核实\",\"id\":0,\"infoDate\":null,\"legalPersonId\":\"\",\"legalPersonName\":\"\",\"orderField\":\"\",\"orderId\":\"\",\"requestNo\":\"\",\"resultGmsfhm\":\"\",\"resultXm\":\"\",\"whcd\":\"\",\"xb\":\"\",\"xp\":\"\",\"zy\":\"\",\"zz\":\"\"},{\"clientName\":\"\",\"createTime\":null,\"csrq\":\"\",\"errorCode\":\"\",\"errorMsg\":\"\",\"id\":0,\"infoDate\":null,\"legalPersonId\":\"\",\"legalPersonName\":\"\",\"orderField\":\"\",\"orderId\":\"\",\"requestNo\":\"\",\"resultGmsfhm\":\"一致\",\"resultXm\":\"不一致\",\"whcd\":\"\",\"xb\":\"\",\"xp\":\"\",\"zy\":\"\",\"zz\":\"\"},{\"clientName\":\"\",\"createTime\":null,\"csrq\":\"\",\"errorCode\":\"\",\"errorMsg\":\"业务类型属性为空\",\"id\":0,\"infoDate\":null,\"legalPersonId\":\"\",\"legalPersonName\":\"\",\"orderField\":\"\",\"orderId\":\"\",\"requestNo\":\"\",\"resultGmsfhm\":\"\",\"resultXm\":\"\",\"whcd\":\"\",\"xb\":\"\",\"xp\":\"\",\"zy\":\"\",\"zz\":\"\"},{\"clientName\":\"\",\"createTime\":null,\"csrq\":\"\",\"errorCode\":\"\",\"errorMsg\":\"必录项缺失\",\"id\":0,\"infoDate\":null,\"legalPersonId\":\"\",\"legalPersonName\":\"\",\"orderField\":\"\",\"orderId\":\"\",\"requestNo\":\"\",\"resultGmsfhm\":\"\",\"resultXm\":\"\",\"whcd\":\"\",\"xb\":\"\",\"xp\":\"\",\"zy\":\"\",\"zz\":\"\"}]";

	/**
	 * List转json字符串
	 * @param list
	 * @return
	 */
	public static String list2JsonStr(List list) {
		return JSON.toJSONString(list);
	}


	/**
	 * list转为JSONArray
	 * @param list
	 * @return
	 */
	public static JSONArray list2JsonArray(List list){
		return new JSONArray(list);
	}


	/**
	 * JSONArray转List
	 * @param jsonArray
	 * @param t
	 * @param <T>
	 * @return
	 */
	public static <T> List<T> jsonArray2List(JSONArray jsonArray, Class<T> t) {
		return (List<T>) JSONObject.parseArray(jsonArray.toJSONString(), t.getClass());
	}

	/**
	 * JSONArray字符串转为list
	 * @param jsonArrayStr
	 * @param t
	 * @param <T>
	 * @return
	 */
	public static <T> List<T> jsonArrayStr2List(String jsonArrayStr, Class<T> t){
		return (List<T>) JSONObject.parseArray(jsonArrayStr, t.getClass());
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("-----json2List-----");
		JSONObject jsonObject = JSONObject.parseObject(jsonObjectStr);
		JSONArray jsonArray = jsonObject.getJSONArray("infos");
		List<CreditInfoPI> list1 = jsonArray2List(jsonArray, CreditInfoPI.class);
		for(int i=0; i<list1.size(); i++){
			System.out.println(list1.get(i));
		}
		System.out.println(list1.toString());
		
		System.out.println("-----jsonArray2List-----");
		List<CreditInfoPI> list2 = ListJsonTransformHelper.jsonArrayStr2List(jsonArrayStr, CreditInfoPI.class);
		for(int i=0; i<list2.size(); i++){
			System.out.println(list2.get(i));
		}
		System.out.println(list2.toString());
		
	}
}
