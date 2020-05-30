package com.nammi.dataAnalysis;

//需要添加json-lib.jar
import java.io.IOException;
import java.util.Iterator;

//import net.sf.json.JSONObject;

//import org.apache.commons.io.FileUtils;

public class DataAnalysis {
	
	public static void main(String[] args){
		String str = "{\"riskInfoList\":\"{\\\"byrPhone\\\":\\\"13810520534\\\",\\\"prdQuantity\\\":\\\"1\\\",\\\"prdUnitPrice\\\":\\\"1.00\\\",\\\"prdName\\\":\\\"火烧石串烧工坊：现金抵用1次，无需预约\\\",\\\"prdDetail\\\":\\\"仅售1元，市场价25元的火烧石串烧工坊现金抵用1次，无需预约，节假日通用，美味当前，精彩不断！\\\"}\",\"byrIp\":null,\"payIp\":\"111.207.191.133\",\"cookieValue\":\"0\",\"deviceId\":\"1389239583935b6de9840-1fa5-4dee-b4b3-e8e16c6a2ad2\"}";
		parseJson(str);
		
		String xmlStr = "";
	}
	
	public static void parseXml(String filePath){
		//打印以下语句：C:\Program Files (x86)\Java\jdk1.6.0\jre\lib\endorsed
		//本地运行jaxb需要将jaxb-api-2.1.7.jar放在该路径下及解决main运行异常
		System.out.println(System.getProperty("java.endorsed.dirs"));
		/*RcsReferDataXMLParseImpl parse = new RcsReferDataXMLParseImpl();
		try {
			String str = FileUtils.readFileToString(new java.io.File("D:\\devTools\\myEcspace\\rm-rmca\\src\\main\\java\\com\\bill99\\rmca\\orm\\manager\\impl\\referData.xml"),"UTF-8");
			//String str = FileUtils.readFileToString(new java.io.File("D:\\devTools\\myEcspace\\rm-rmca\\src\\main\\java\\com\\bill99\\rmca\\orm\\manager\\impl\\referDataXML.xml"),"UTF-8");
			//String str = FileUtils.readFileToString(new java.io.File("D:\\devTools\\myEcspace\\rm-rmca\\src\\main\\resources\\referData.xml"),"UTF-8");
			RcsReferXMLDataDto dto = parse.referDataParse(str);
			
			//	
			System.out.println(dto.getRiskControlInfomation().getByrFirstName());
			System.out.println(dto.getRiskControlInfomation().getByrPhone());
			//产品信息
			System.out.println(dto.getCpsRefDataPrdDto().getpProductname());
			System.out.println(dto.getCpsRefDataTBDto().getTbPName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	
	//需要导入6个jar否则报错：
	//json-lib-2.4
	//ezmorph-1.0.6
	//commons-beanutils-1.8.3
	//commons-lang-2.6 (注：导入最新的 3.1 版本会继续报如下错误)
	//commons-collections-3.2.1
	//commons-logging-1.1.1
	public static void parseJson(String str){


		/*JSONObject jsonObj = JSONObject.fromObject(str);
		Iterator<String> keys = jsonObj.keys();
		while(keys.hasNext()){
			String key = keys.next();
			String val = String.valueOf(jsonObj.get(key)).trim();
			//出现情况：riskInfoList的value也是json形式的字符串
			if("riskInfoList".equals(key)){
				parseJson(val);
			}
			System.out.println("key= "+key+"|value="+val);
		}*/
	}
	
}
