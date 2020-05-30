package com.nammi.util.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nammi.entity.CreditInfoPI;
import com.nammi.sql.jdbc.JdbcMysql;

public class ListJsonTransformHelper {
	
	public static final String jsonObjectStr = "{\"infos\":[{\"clientName\":\"\",\"createTime\":null,\"csrq\":\"19820224\",\"errorCode\":\"\",\"errorMsg\":\"\",\"id\":0,\"infoDate\":null,\"legalPersonId\":\"\",\"legalPersonName\":\"\",\"orderField\":\"\",\"orderId\":\"\",\"requestNo\":\"\",\"resultGmsfhm\":\"一致\",\"resultXm\":\"一致\",\"whcd\":\"大学本科（简称“大学”）\",\"xb\":\"女性\",\"xp\":\"\",\"zy\":\"干部\",\"zz\":\"北京市海淀区集体三里\"},{\"clientName\":\"\",\"createTime\":null,\"csrq\":\"\",\"errorCode\":\"\",\"errorMsg\":\"服务结果:库中无此号，请到户籍所在地进行核实\",\"id\":0,\"infoDate\":null,\"legalPersonId\":\"\",\"legalPersonName\":\"\",\"orderField\":\"\",\"orderId\":\"\",\"requestNo\":\"\",\"resultGmsfhm\":\"\",\"resultXm\":\"\",\"whcd\":\"\",\"xb\":\"\",\"xp\":\"\",\"zy\":\"\",\"zz\":\"\"},{\"clientName\":\"\",\"createTime\":null,\"csrq\":\"\",\"errorCode\":\"\",\"errorMsg\":\"\",\"id\":0,\"infoDate\":null,\"legalPersonId\":\"\",\"legalPersonName\":\"\",\"orderField\":\"\",\"orderId\":\"\",\"requestNo\":\"\",\"resultGmsfhm\":\"一致\",\"resultXm\":\"不一致\",\"whcd\":\"\",\"xb\":\"\",\"xp\":\"\",\"zy\":\"\",\"zz\":\"\"},{\"clientName\":\"\",\"createTime\":null,\"csrq\":\"\",\"errorCode\":\"\",\"errorMsg\":\"业务类型属性为空\",\"id\":0,\"infoDate\":null,\"legalPersonId\":\"\",\"legalPersonName\":\"\",\"orderField\":\"\",\"orderId\":\"\",\"requestNo\":\"\",\"resultGmsfhm\":\"\",\"resultXm\":\"\",\"whcd\":\"\",\"xb\":\"\",\"xp\":\"\",\"zy\":\"\",\"zz\":\"\"},{\"clientName\":\"\",\"createTime\":null,\"csrq\":\"\",\"errorCode\":\"\",\"errorMsg\":\"必录项缺失\",\"id\":0,\"infoDate\":null,\"legalPersonId\":\"\",\"legalPersonName\":\"\",\"orderField\":\"\",\"orderId\":\"\",\"requestNo\":\"\",\"resultGmsfhm\":\"\",\"resultXm\":\"\",\"whcd\":\"\",\"xb\":\"\",\"xp\":\"\",\"zy\":\"\",\"zz\":\"\"}]}";
	//JSONArray外面有[]
	public static final String jsonArrayStr = "[{\"clientName\":\"\",\"createTime\":null,\"csrq\":\"19820224\",\"errorCode\":\"\",\"errorMsg\":\"\",\"id\":0,\"infoDate\":null,\"legalPersonId\":\"\",\"legalPersonName\":\"\",\"orderField\":\"\",\"orderId\":\"\",\"requestNo\":\"\",\"resultGmsfhm\":\"一致\",\"resultXm\":\"一致\",\"whcd\":\"大学本科（简称“大学”）\",\"xb\":\"女性\",\"xp\":\"\",\"zy\":\"干部\",\"zz\":\"北京市海淀区集体三里\"},{\"clientName\":\"\",\"createTime\":null,\"csrq\":\"\",\"errorCode\":\"\",\"errorMsg\":\"服务结果:库中无此号，请到户籍所在地进行核实\",\"id\":0,\"infoDate\":null,\"legalPersonId\":\"\",\"legalPersonName\":\"\",\"orderField\":\"\",\"orderId\":\"\",\"requestNo\":\"\",\"resultGmsfhm\":\"\",\"resultXm\":\"\",\"whcd\":\"\",\"xb\":\"\",\"xp\":\"\",\"zy\":\"\",\"zz\":\"\"},{\"clientName\":\"\",\"createTime\":null,\"csrq\":\"\",\"errorCode\":\"\",\"errorMsg\":\"\",\"id\":0,\"infoDate\":null,\"legalPersonId\":\"\",\"legalPersonName\":\"\",\"orderField\":\"\",\"orderId\":\"\",\"requestNo\":\"\",\"resultGmsfhm\":\"一致\",\"resultXm\":\"不一致\",\"whcd\":\"\",\"xb\":\"\",\"xp\":\"\",\"zy\":\"\",\"zz\":\"\"},{\"clientName\":\"\",\"createTime\":null,\"csrq\":\"\",\"errorCode\":\"\",\"errorMsg\":\"业务类型属性为空\",\"id\":0,\"infoDate\":null,\"legalPersonId\":\"\",\"legalPersonName\":\"\",\"orderField\":\"\",\"orderId\":\"\",\"requestNo\":\"\",\"resultGmsfhm\":\"\",\"resultXm\":\"\",\"whcd\":\"\",\"xb\":\"\",\"xp\":\"\",\"zy\":\"\",\"zz\":\"\"},{\"clientName\":\"\",\"createTime\":null,\"csrq\":\"\",\"errorCode\":\"\",\"errorMsg\":\"必录项缺失\",\"id\":0,\"infoDate\":null,\"legalPersonId\":\"\",\"legalPersonName\":\"\",\"orderField\":\"\",\"orderId\":\"\",\"requestNo\":\"\",\"resultGmsfhm\":\"\",\"resultXm\":\"\",\"whcd\":\"\",\"xb\":\"\",\"xp\":\"\",\"zy\":\"\",\"zz\":\"\"}]";

	/**
	 * List存入json后的String格式
	 * {"key":[{"key1":"value1"}, {"key2":"value2"}, {"key3":"value3"}]}
	 */
	public static void listInJson() {
		List<CreditInfoPI> finalList = new ArrayList<CreditInfoPI>();
		CreditInfoPI CreditInfoPI = new CreditInfoPI();
		CreditInfoPI.setId(1L);
		CreditInfoPI.setOrderId("1");

		CreditInfoPI CreditInfoPI2 = new CreditInfoPI();
		CreditInfoPI2.setId(2L);
		CreditInfoPI CreditInfoPI3 = new CreditInfoPI();
		CreditInfoPI3.setId(3L);
		finalList.add(CreditInfoPI2);
		finalList.add(CreditInfoPI3);

		JSONObject returnJsonObj = new JSONObject();
		returnJsonObj.put("requestResult", CreditInfoPI);
		returnJsonObj.put("blackList", finalList);
		System.out.println(returnJsonObj.toString());
	}
	
	
	/**
	 * json转为list
	 * 适用场景：json中包含多组相同格式json串
	 * @param jsonStr
	 * @return List
	 */
	public static List<CreditInfoPI> json2List(String jsonStr){
		JSONObject jsonObj = JSON.parseObject(jsonObjectStr);
		JSONArray infoListArr = jsonObj.getJSONArray("infos");
		List<CreditInfoPI> list = (List)JSONArray.toCollection(infoListArr, CreditInfoPI.class);
		return list;
	}
	
	/**
	 * list转为JSONArray
	 * @param list
	 * @return jsonArray.toString()
	 */
	public static String list2JsonArray(List<CreditInfoPI> list){
		JSONArray jsonArray = new JSONArray();
		jsonArray = JSONArray.fromObject(list);
		return jsonArray.toString();
	}
	
	/**
	 * JSONArray转为list：list元素为java对象
	 * @param jsonArrayStr
	 * @return List
	 */
	public static List<CreditInfoPI> jsonArray2List(String jsonArrayStr){
		JSONArray jsonArray = JSONArray.fromObject(jsonArrayStr);
		List<CreditInfoPI> list = (List<CreditInfoPI>)JSONArray.toCollection(jsonArray, CreditInfoPI.class);
		return list;
	}
	
	
	/**
	 * JSONArray转为list：list元素为Map
	 * @param jsonArrayStr
	 * @return List<Map>
	 */
	public static List<Map<String,Object>> jsonArray2ListMap(String jsonArrayStr){
		JSONArray jsonArray = JSONArray.fromObject(jsonArrayStr);
		List list = (List)JSONArray.toCollection(jsonArray);
		List<Map<String,Object>> resultList = new ArrayList<Map<String,Object>>();
		if(list!=null && list.size()>0){
			for(int i=0; i<list.size(); i++){
				//1.将list元素转为json
				JSONObject tempJson = JSONObject.fromObject(list.get(i));
				try {
					//2.将json转为map
					Map<String,Object> tempMap = ListJsonTransformHelper.jsonToMap(tempJson.toString());
					resultList.add(tempMap);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return resultList;
	}
	public static Map<String, Object> jsonToMap(String jsonString) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		Map resultMap = (Map) objectMapper.readValue(jsonString, Map.class);
		return resultMap;
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("-----json2List-----");
		ListJsonTransformHelper.listInJson();
		
		System.out.println("-----json2List-----");
		List<CreditInfoPI> list1 = ListJsonTransformHelper.json2List(jsonObjectStr);
		for(int i=0; i<list1.size(); i++){
			System.out.println(list1.get(i));
		}
		System.out.println(list1.toString());
		
		System.out.println("-----jsonArray2List-----");
		List<CreditInfoPI> list2 = ListJsonTransformHelper.jsonArray2List(jsonArrayStr);
		for(int i=0; i<list2.size(); i++){
			System.out.println(list2.get(i));
		}
		System.out.println(list2.toString());
		
		System.out.println("-----jsonArray2ListMap-----");
		List<Map<String, Object>> list3 = ListJsonTransformHelper.jsonArray2ListMap(jsonArrayStr);
		for(int i=0; i<list3.size(); i++){
			System.out.println("-----map"+i+"-----");
			Map<String, Object> tempMap = list3.get(i);
			Set<String> keys = tempMap.keySet();
			for(Iterator it=keys.iterator(); it.hasNext();){
				String s = (String)it.next();
				System.out.println("key="+s+"|value="+tempMap.get(s));
			}
		}
		System.out.println(list2.toString());
	}
}
