package com.nammi.util.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class MapJsonTransformHelper {
	
	public static final String jsonStr = "{\"whcd\":null,\"createTime\":null,\"errorMsg\":\"您没有权限使用此服务\",\"xp\":null,\"zz\":null,\"legalPersonName\":null,\"legalPersonId\":null,\"id\":null,\"resultGmsfhm\":null,\"zy\":null,\"requestNo\":null,\"infoDate\":null,\"clientName\":null,\"errorCode\":\"-53\",\"xb\":null,\"csrq\":null,\"resultXm\":null,\"orderId\":null}";
	
	/**
	 * json嵌套字符串转Map：jackson框架
	 * @param jsonStr
	 * @return
	 */
	/*public static Map json2Map(String jsonStr){
		ObjectMapper mapper = new ObjectMapper();
		Map<String,Object> productMap = mapper.readValue(jsonStr);
	}*/


	/**
	 * json嵌套字符串转Map
     * 注意：测试成功，使用fastJson
     * 缺点：解析了嵌套json，但是嵌套json的key无法作为结果Map的key
     * 示例：key=ke2|value={ke22=val22, ke21=val21}
	 * @param jsonStr
	 * @return
	 */
	public static Map json2MapRecursionByFastJson(String jsonStr){
		Map map = new HashMap();
		JSONObject json = JSON.parseObject(jsonStr);
		//获取json对象的key集合
		Set<Map.Entry<String, Object>> entries = json.entrySet();
		for (Iterator<Map.Entry<String, Object>> it = entries.iterator(); it.hasNext(); ) {
		    Map.Entry<String, Object> tmp = it.next();
		    String key = tmp.getKey();
            /**
             * 当value为json时，使用（String）强转，报错：
             * java.lang.ClassCastException: com.alibaba.fastjson.JSONObject cannot be cast to java.lang.String
             */
			//String val = (String)tmp.getValue();
			String val = tmp.getValue().toString();
			if (val.startsWith("{") && val.endsWith("}")) {
				map.put(key, json2MapRecursionByFastJson(val));
			} else {
				map.put(key, val);
			}
		}
		return map;
	}


    /**
     * json嵌套字符串转Map
     * 注意：测试成功，使用net.sf.json.JSONObject
     * 缺点：解析了嵌套json，但是嵌套json的key无法作为结果Map的key
     * 示例：key=ke2|value={ke22=val22, ke21=val21}
     * @param jsonStr
     * @return
     */
    public static Map json2MapRecursion(String jsonStr){
        Map map = new HashMap();
        net.sf.json.JSONObject json = net.sf.json.JSONObject.fromObject(jsonStr);
        //获取json对象的key集合
        Iterator keys = json.keys();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            String value = json.get(key).toString();
            if (value.startsWith("{") && value.endsWith("}")) {
                map.put(key, json2MapRecursion(value));
            } else {
                map.put(key, value);
            }
        }
        return map;
    }


    /**
     * json嵌套字符串，扁平化到Map
     * @param jsonStr
     * @return
     */
    public static Map flatJson2Map(String jsonStr){
        Map map = new HashMap();
        JSONObject json = JSON.parseObject(jsonStr);
        //获取json对象的key集合
        Set<Map.Entry<String, Object>> entries = json.entrySet();
        for (Iterator<Map.Entry<String, Object>> it = entries.iterator(); it.hasNext(); ) {
            Map.Entry<String, Object> tmp = it.next();
            String key = tmp.getKey();
            String val = tmp.getValue().toString();
            if (val.startsWith("{") && val.endsWith("}")) {
                map.putAll(flatJson2Map(val));
            } else {
                map.put(key, val);
            }
        }
        return map;
    }



    /**
     * json字符串转Map
     * 适用场景：一层key-value
     * 缺点：无法解析嵌套json
     * 示例：ke2--->{"ke22":"val22","ke21":"val21"}
     * @param jsonStr
     * @return
     */
	public static Map jsonStr2Map(String jsonStr) {
        return JSON.parseObject(jsonStr, Map.class);
	}
	

	//最常规的一种遍历方法，最常规就是最常用的，虽然不复杂，但很重要，这是我们最熟悉的，就不多说了！！
    public static void work(Map map) {
        Collection c = map.values();
        Iterator it = c.iterator();
        for (; it.hasNext();) {
            System.out.println(it.next());
        }
    }
    //利用keyset进行遍历，它的优点在于可以根据你所想要的key值得到你想要的 values，更具灵活性！！
    public static void workByKeySet(Map map) {
        Set<String> key = map.keySet();
        for (Iterator it = key.iterator(); it.hasNext();) {
            String s = (String) it.next();
            System.out.println("key="+s+"|value="+map.get(s));
        }
    }
	//比较复杂的一种遍历在这里，呵呵~~他很暴力哦，它的灵活性太强了，想得到什么就能得到什么~~
    public static void workByEntry(Map map) {
    	//返回此映射中包含的映射关系的 Set 视图
        Set<Map.Entry> set = map.entrySet();
        for (Iterator<Map.Entry> it = set.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }
    }

	public static void main(String[] args){
		String jsonStr2 = "{\"ke1\":\"val1\", \"ke2\":{\"ke21\":\"val21\",\"ke22\":\"val22\"} }";

        workByEntry(json2MapRecursion(jsonStr2));

        System.out.println("+++++++++++++++++++");
		workByKeySet(json2MapRecursionByFastJson(jsonStr2));

        System.out.println("+++++++++++++++++++");
        /**
         * 输出：
         * ke1--->val1
         * ke22--->val22
         * ke21--->val21
         */
		workByEntry(flatJson2Map(jsonStr2));

//		System.out.println("+++++++++++++++++++");
//		Map mapType = JSON.parseObject(jsonStr2,Map.class);
//		workByEntry(mapType);
	}
}
