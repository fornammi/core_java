package daniel.java.net;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;

public class HttpClientUtils {
	
	private static Log log = LogFactory.getLog(HttpClientUtils.class);
	
	private static final String URL_DEV = "http://192.168.47.171/billstore/public/index.php/order/riskControl";
	private static final String client_secret = "quanyipingtai";
	private static final String process_status = "normal";
	
    /**
     * http服务：传递json对象
     * 适用场景：对方不是java环境，比如php，需要参数为json对象
     * @param url
     * @param json
     * @throws Exception
     */
	public static String httpPostWithJson(String url, JSONObject json) throws Exception{
		String result = "";
		CloseableHttpResponse httpResponse = null;
        try {
        	CloseableHttpClient httpClient = HttpClients.createDefault();
        	HttpPost httpPost = new HttpPost(url);
        	
        	Integer timeout = Integer.valueOf(60000);
        	RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(timeout.intValue())
        	.setConnectTimeout(timeout.intValue()).setSocketTimeout(timeout.intValue()).build();
        	
        	httpPost.setConfig(requestConfig);
        	httpPost.setEntity(new StringEntity(json.toString(), ContentType.APPLICATION_JSON));
			// 客户端执行post请求 返回响应实体
			httpResponse = httpClient.execute(httpPost);
			int respStatus = httpResponse.getStatusLine().getStatusCode();
			if (respStatus == 200) {
				HttpEntity httpEntity = httpResponse.getEntity();
				// 取出应答字符串
				//result = IOUtils.toString(httpResponse.getEntity().getContent(), "UTF-8");
				//解决乱码问题
				StringBuffer sb = new StringBuffer();
				InputStream is = httpEntity.getContent();
				byte[] bytes = new byte[2048];
				int size = 0;
				while ((size=is.read(bytes)) > 0){
					//通过使用指定的字符集解码指定的 byte 子数组，构造一个新的 String。
					String str = new String(bytes, 0, size, "UTF-8");
					sb.append(str);
				}
				is.close();
				result = sb.toString();
			}else{
				result = url+":respStatus="+respStatus;
			}
		}catch(Exception e) {
			result = e.getMessage().toString();
		}finally{
			if(httpResponse!=null){
				try{
					EntityUtils.consume(httpResponse.getEntity());
					httpResponse.close();
				}catch(Exception e){
					log.error("error："+e.getMessage(), e);
				}
			}
		}
		System.out.println("HttpPost result is: "+result);
		return result;
	}
	
	
	/**
	 * post请求：参数为Object
	 * 适用场景：通用
	 * requestObj可以为map，jsonStr等等
	 * @param url
	 * @param requestObj
	 * @return
	 * @throws Exception
	 */
	public static String doHttpPost(String url, Object requestObj) throws Exception{
		String requestString = "[]";
		String result = "";
		CloseableHttpResponse response = null;
		try {
			if(requestObj!=null){
				requestString = convert2Json(requestObj);
			}
			// 创建默认的客户端实例
			CloseableHttpClient httpClient = HttpClients.createDefault();
			// 创建HttpPost对象
			HttpPost httpPost = new HttpPost(url);
			Integer timeout = Integer.valueOf(60000);
			RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(timeout.intValue())
			.setConnectTimeout(timeout.intValue()).setSocketTimeout(timeout.intValue()).build();
			httpPost.setConfig(requestConfig);
			httpPost.setEntity(new StringEntity(requestString, ContentType.APPLICATION_JSON));
			// 客户端执行post请求 返回响应实体
			response = httpClient.execute(httpPost);
			int respStatus = response.getStatusLine().getStatusCode();
			if (respStatus == 200) {
				result = IOUtils.toString(response.getEntity().getContent(), "UTF-8");
			}else{
				result = url+":respStatus="+respStatus;
			}
		} catch (Exception e) {
			result = e.getMessage().toString();
		} finally{
			if(response!=null){
				try{
					EntityUtils.consume(response.getEntity());
					response.close();
				}catch(Exception e){
					log.error("error："+e.getMessage(), e);
				}
			}
		}
		System.out.println("HttpPost result is: "+result);
		return result;
	}
	
	
	public static String convert2Json(Object object) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		objectMapper.writeValue(byteArrayOutputStream, object);
		return byteArrayOutputStream.toString("UTF-8");
	}

	public static Map<String, Object> jsonToMap(String jsonString)
			throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		Map resultMap = (Map) objectMapper.readValue(jsonString, Map.class);
		return resultMap;
	}
	
	
	public static void main(String[] args) {
		//>>>1.通知商城
		/*Map<String, String> conMap = new HashMap<String, String>();
		String out_trade_no = "201608301303323351000020957";
		String sign = MD5Utils.string2MD5(out_trade_no+""+process_status+""+client_secret);
		conMap.put("out_trade_no", out_trade_no);
		conMap.put("process_status", process_status);
		conMap.put("sign", sign);
		JSONObject jsonObj = JSONObject.fromObject(conMap);
		try {
			System.out.println("jsonStr: "+jsonObj.toString());
			HttpClientUtils.httpPostWithJson(URL_DEV, jsonObj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//>>>2.测试:本地http服务
		String localUrl = "http://127.0.0.1:8080/rm-cams/outerReqRiskCode";
		Map<String, String> conMap2 = new HashMap<String, String>();
		conMap2.put("objName", "memberCode");
		conMap2.put("objValue", "10011511559");//conMap不能用10011511559l
		conMap2.put("riskCode", "AC");
		conMap2.put("reasonCode", "UACD");
		conMap2.put("appName", "localTest");
		conMap2.put("orgCode", "rm");
		conMap2.put("userCode", "nammi");
		conMap2.put("userCode", "nammi");
		JSONObject jsonObj2 = JSONObject.fromObject(conMap);
		try {
			String result = HttpClientUtils.httpPostWithJson(localUrl, jsonObj2);
			System.out.println("RiskCode result is: "+result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//3.测试：网金止登录
		String netUrl = "http://96.7.0.22:80/v1/account/status/freeze";
		Map<String, String> conMap3 = new HashMap<String, String>();
		conMap3.put("pwid", "");*/
		
		//4.CFCA:ods查询接口
		String odsUrl_dev="http://192.168.15.157:8081/ods-ws/ws/common/odsQuery";
		Map<String, Object> odsMap = new HashMap<String, Object>();
		odsMap.put("interfaceName", "GetPersonnelTradeDetailInterface");
		odsMap.put("currentPage", 1L);
		odsMap.put("pageSize", 100L);
		Map<String, Object> odsMap1 = new HashMap<String, Object>();
		odsMap1.put("memberCode", 10012764991L);
		odsMap1.put("startTime", "2015-10-28 00:00:00");
		odsMap1.put("expireTime", "2016-11-28 00:00:00");
		odsMap.put("params", odsMap1);
		JSONObject odsJsonObj = JSONObject.fromObject(odsMap);
		System.out.println("RequestData is："+odsJsonObj.toString());
		try {
			String odsResult = HttpClientUtils.doHttpPost(odsUrl_dev, odsJsonObj);
			System.out.println("odsResult："+odsResult);
			//解析result
			List<Map<String,Object>> returnList = new HttpClientUtils().handleJson(odsResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 解析
	 * @param jsonStr
	 */
	public static List<Map<String,Object>> handleJson(String jsonStr) throws Exception{
		JSONObject jsonObject = JSONObject.fromObject(jsonStr);
		Map<String, Object> responseMap = HttpClientUtils.jsonToMap(jsonStr);
		System.out.println("result exists："+responseMap.containsKey("result"));
		List<Map<String,Object>> returnList = new ArrayList<Map<String,Object>>();
		if(responseMap!=null && responseMap.size()>0 && responseMap.containsKey("result")){
			JSONObject result = jsonObject.getJSONObject("result");
			if(!(result==null || result.isNullObject())){
				JSONArray resultMap = result.getJSONArray("resultMap");
				if(!(resultMap==null || resultMap.isEmpty())){
					List resultList = (List)JSONArray.toCollection(resultMap);
					if(resultList!=null && resultList.size()>0){
						for(int i=0; i<resultList.size(); i++){
							System.out.println(">>>>>"+i+"<<<<<");
							JSONObject tempJson = JSONObject.fromObject(resultList.get(i));
							Map<String, Object> tempMap = HttpClientUtils.jsonToMap(tempJson.toString());
							Set<String> keys = tempMap.keySet();
							for(Iterator it = keys.iterator();it.hasNext();){
								String s = (String)it.next();
								System.out.println("key="+s+"|value="+tempMap.get(s));
							}
						}
						
					}
				}
			}
		}
		return returnList;
	}
	
}
