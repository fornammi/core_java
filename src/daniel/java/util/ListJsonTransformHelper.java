package daniel.java.util;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import daniel.java.util.xml.CreditInfoPI;

public class ListJsonTransformHelper {
	
	public static final String jsonObjectStr = "{\"infos\":[{\"clientName\":\"\",\"createTime\":null,\"csrq\":\"19820224\",\"errorCode\":\"\",\"errorMsg\":\"\",\"id\":0,\"infoDate\":null,\"legalPersonId\":\"\",\"legalPersonName\":\"\",\"orderField\":\"\",\"orderId\":\"\",\"requestNo\":\"\",\"resultGmsfhm\":\"一致\",\"resultXm\":\"一致\",\"whcd\":\"大学本科（简称“大学”）\",\"xb\":\"女性\",\"xp\":\"\",\"zy\":\"干部\",\"zz\":\"北京市海淀区集体三里\"},{\"clientName\":\"\",\"createTime\":null,\"csrq\":\"\",\"errorCode\":\"\",\"errorMsg\":\"服务结果:库中无此号，请到户籍所在地进行核实\",\"id\":0,\"infoDate\":null,\"legalPersonId\":\"\",\"legalPersonName\":\"\",\"orderField\":\"\",\"orderId\":\"\",\"requestNo\":\"\",\"resultGmsfhm\":\"\",\"resultXm\":\"\",\"whcd\":\"\",\"xb\":\"\",\"xp\":\"\",\"zy\":\"\",\"zz\":\"\"},{\"clientName\":\"\",\"createTime\":null,\"csrq\":\"\",\"errorCode\":\"\",\"errorMsg\":\"\",\"id\":0,\"infoDate\":null,\"legalPersonId\":\"\",\"legalPersonName\":\"\",\"orderField\":\"\",\"orderId\":\"\",\"requestNo\":\"\",\"resultGmsfhm\":\"一致\",\"resultXm\":\"不一致\",\"whcd\":\"\",\"xb\":\"\",\"xp\":\"\",\"zy\":\"\",\"zz\":\"\"},{\"clientName\":\"\",\"createTime\":null,\"csrq\":\"\",\"errorCode\":\"\",\"errorMsg\":\"业务类型属性为空\",\"id\":0,\"infoDate\":null,\"legalPersonId\":\"\",\"legalPersonName\":\"\",\"orderField\":\"\",\"orderId\":\"\",\"requestNo\":\"\",\"resultGmsfhm\":\"\",\"resultXm\":\"\",\"whcd\":\"\",\"xb\":\"\",\"xp\":\"\",\"zy\":\"\",\"zz\":\"\"},{\"clientName\":\"\",\"createTime\":null,\"csrq\":\"\",\"errorCode\":\"\",\"errorMsg\":\"必录项缺失\",\"id\":0,\"infoDate\":null,\"legalPersonId\":\"\",\"legalPersonName\":\"\",\"orderField\":\"\",\"orderId\":\"\",\"requestNo\":\"\",\"resultGmsfhm\":\"\",\"resultXm\":\"\",\"whcd\":\"\",\"xb\":\"\",\"xp\":\"\",\"zy\":\"\",\"zz\":\"\"}]}";
	public static final String jsonArrayStr = "[{\"clientName\":\"\",\"createTime\":null,\"csrq\":\"19820224\",\"errorCode\":\"\",\"errorMsg\":\"\",\"id\":0,\"infoDate\":null,\"legalPersonId\":\"\",\"legalPersonName\":\"\",\"orderField\":\"\",\"orderId\":\"\",\"requestNo\":\"\",\"resultGmsfhm\":\"一致\",\"resultXm\":\"一致\",\"whcd\":\"大学本科（简称“大学”）\",\"xb\":\"女性\",\"xp\":\"\",\"zy\":\"干部\",\"zz\":\"北京市海淀区集体三里\"},{\"clientName\":\"\",\"createTime\":null,\"csrq\":\"\",\"errorCode\":\"\",\"errorMsg\":\"服务结果:库中无此号，请到户籍所在地进行核实\",\"id\":0,\"infoDate\":null,\"legalPersonId\":\"\",\"legalPersonName\":\"\",\"orderField\":\"\",\"orderId\":\"\",\"requestNo\":\"\",\"resultGmsfhm\":\"\",\"resultXm\":\"\",\"whcd\":\"\",\"xb\":\"\",\"xp\":\"\",\"zy\":\"\",\"zz\":\"\"},{\"clientName\":\"\",\"createTime\":null,\"csrq\":\"\",\"errorCode\":\"\",\"errorMsg\":\"\",\"id\":0,\"infoDate\":null,\"legalPersonId\":\"\",\"legalPersonName\":\"\",\"orderField\":\"\",\"orderId\":\"\",\"requestNo\":\"\",\"resultGmsfhm\":\"一致\",\"resultXm\":\"不一致\",\"whcd\":\"\",\"xb\":\"\",\"xp\":\"\",\"zy\":\"\",\"zz\":\"\"},{\"clientName\":\"\",\"createTime\":null,\"csrq\":\"\",\"errorCode\":\"\",\"errorMsg\":\"业务类型属性为空\",\"id\":0,\"infoDate\":null,\"legalPersonId\":\"\",\"legalPersonName\":\"\",\"orderField\":\"\",\"orderId\":\"\",\"requestNo\":\"\",\"resultGmsfhm\":\"\",\"resultXm\":\"\",\"whcd\":\"\",\"xb\":\"\",\"xp\":\"\",\"zy\":\"\",\"zz\":\"\"},{\"clientName\":\"\",\"createTime\":null,\"csrq\":\"\",\"errorCode\":\"\",\"errorMsg\":\"必录项缺失\",\"id\":0,\"infoDate\":null,\"legalPersonId\":\"\",\"legalPersonName\":\"\",\"orderField\":\"\",\"orderId\":\"\",\"requestNo\":\"\",\"resultGmsfhm\":\"\",\"resultXm\":\"\",\"whcd\":\"\",\"xb\":\"\",\"xp\":\"\",\"zy\":\"\",\"zz\":\"\"}]";

	public static List<CreditInfoPI> json2List(String jsonStr){
		JSONObject jsonObj = JSONObject.fromObject(jsonObjectStr);
		JSONArray infoListArr = jsonObj.getJSONArray("infos");
		List<CreditInfoPI> list = (List)JSONArray.toCollection(infoListArr, CreditInfoPI.class);
		return list;
	}
	
	public static List<CreditInfoPI> jsonArray2List(String jsonStr){
		JSONArray jsonArray = JSONArray.fromObject(jsonStr);
		List<CreditInfoPI> list = (List)JSONArray.toCollection(jsonArray, CreditInfoPI.class);
		return list;
	}
	
	public static void main(String[] args) {
		System.out.println("-----json2List-----");
		List<CreditInfoPI> list1 = ListJsonTransformHelper.json2List(jsonObjectStr);
		for(int i=0; i<list1.size(); i++){
			System.out.println(list1.get(i));
		}
		System.out.println(list1.toString());
		
		
		System.out.println("-----jsonArray2List-----");
		List<CreditInfoPI> list2 = ListJsonTransformHelper.json2List(jsonObjectStr);
		for(int i=0; i<list2.size(); i++){
			System.out.println(list2.get(i));
		}
		System.out.println(list2.toString());
	}
}
