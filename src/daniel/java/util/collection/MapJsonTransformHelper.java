package daniel.java.util.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONObject;

public class MapJsonTransformHelper {
	
	public static final String jsonStr = "{\"whcd\":null,\"createTime\":null,\"errorMsg\":\"您没有权限使用此服务\",\"xp\":null,\"zz\":null,\"legalPersonName\":null,\"legalPersonId\":null,\"id\":null,\"resultGmsfhm\":null,\"zy\":null,\"requestNo\":null,\"infoDate\":null,\"clientName\":null,\"errorCode\":\"-53\",\"xb\":null,\"csrq\":null,\"resultXm\":null,\"orderId\":null}";
	
	/**
	 * jackson框架解析json
	 * @param jsonStr
	 * @return
	 */
	/*public static Map json2Map(String jsonStr){
		ObjectMapper mapper = new ObjectMapper();
		Map<String,Object> productMap = mapper.readValue(jsonStr);
	}*/
	
	/**
	 * 递归方法处理json
	 */
	public static Map json2MapRecursion(String jsonStr){
		Map map = new HashMap();
		JSONObject json = JSONObject.fromObject(jsonStr);
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
	
	public static void main(String[] args){
		Map json2Map = MapJsonTransformHelper.json2MapRecursion(jsonStr);
		workByKeySet(json2Map);
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
}
