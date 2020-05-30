package com.nammi.util.xml;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import daniel.java.util.xml.model.CreditInfoPI;

/**
 * @author daniel.fang
 *
 */
public class XmlSAXNCIISHelper extends DefaultHandler {
	
	private List<CreditInfoPI> infoList = null;
	private CreditInfoPI creditInfo = null;
	//作用是记录解析时的上一个节点名称  
	private String preTag = null;
	
	
	/**
	 * 接收文档开始的通知
	 */
    @Override
	public void startDocument() throws SAXException {
    	infoList = new ArrayList<CreditInfoPI>();
	}
    
    /**
     * 接收元素开始的通知
     */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		if("row".equalsIgnoreCase(qName)){
			 creditInfo = new CreditInfoPI();
			 //creditInfo.setId(Integer.parseInt(attributes.getValue(0)));
		}
		preTag = qName;//将正在解析的节点名称赋给preTag
	}

	/**
	 * 接收元素结束的通知
	 */
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if(creditInfo!=null && "row".equalsIgnoreCase(qName)){
			infoList.add(creditInfo);
			creditInfo = null;
		}
		preTag = null;
		/**
		 * 当一个元素解析结束时置为空,这里很重要。
		 * 分析：当<name>结束后，会调用endElement方法并执行preTag = null;语句， 
		 * 如果没有该语句，处理完</name>后，到了<price>前，继续执行characters(char[] ch,
		 * int start, int length)这个方法时，preTag的值还是creditInfo，就会执行 if(preTag!=null)
		 * 判断里的语句，这样就会把空值赋值给creditInfo，这不是我们想要的。
		 */
		  
	}
	
	/**
     * 接收元素中字符数据的通知
     */
    @Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if(preTag != null){
			String content = new String(ch, start, length);
			if("errorcode".equalsIgnoreCase(preTag)){	//异常结果返回值
				creditInfo.setErrorCode(content);
			}else if("errormsg".equalsIgnoreCase(preTag)){		//异常结果：错误描述字段
				creditInfo.setErrorMsg(content);
			}else if("errormesage".equalsIgnoreCase(preTag)){	//正常结果：错误描述字段
				creditInfo.setErrorMsg(content);
			}/*else if("gmsfhm".equalsIgnoreCase(preTag)){
				creditInfo.Gmsfhm(content);
			}*/else if("result_gmsfhm".equalsIgnoreCase(preTag)){
				creditInfo.setResultGmsfhm(content);
			}/*else if("xm".equalsIgnoreCase(preTag)){
				creditInfo.setXm(content);
			}*/else if("result_xm".equalsIgnoreCase(preTag)){
				creditInfo.setResultXm(content);
			}else if("xb".equalsIgnoreCase(preTag)){
				creditInfo.setXb(content);
			}else if("csrq".equalsIgnoreCase(preTag)){
				creditInfo.setCsrq(content);
			}else if("whcd".equalsIgnoreCase(preTag)){
				creditInfo.setWhcd(content);
			}else if("zy".equalsIgnoreCase(preTag)){
				creditInfo.setZy(content);
			}else if("zz".equalsIgnoreCase(preTag)){
				creditInfo.setZz(content);
			}else if("xp".equalsIgnoreCase(preTag)){
				//需要使用云存储
				creditInfo.setXp(content);
			}else if("ssssxq".equalsIgnoreCase(preTag)){//2016.2.16新增"所属省市县区"
				creditInfo.setSsssxq(content);
			}else if("dn".equalsIgnoreCase(preTag)){//2016.2.16新增"失信被执行人"节点
				creditInfo.setRtdn(content);
			}else if("des".equalsIgnoreCase(preTag)){//2016.2.16新增"失信被执行人"节点
				creditInfo.setRtdes(content);
			}
		}
	}
	
	
	public List<CreditInfoPI> parseCreditInfoXml(InputStream xmlStream) throws Exception{
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		XmlSAXNCIISHelper handler = new XmlSAXNCIISHelper();
		parser.parse(xmlStream, handler);
		return handler.getInfoList();
	}
	
	public List<CreditInfoPI> getInfoList(){
		return infoList;
	}

	/**
	 * 测试main方法
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		XmlSAXNCIISHelper sax = new XmlSAXNCIISHelper();
		/**
		 * XML文件解析：分别解析公安接口返回的正常和异常结果
		 */
		//InputStream input = new FileInputStream(new File("D:\\devTools\\myEcspace\\CoreJava\\src\\daniel\\java\\util\\xml\\info_error.xml"));
		//InputStream inputXML = new FileInputStream(new File("D:\\devTools\\myEcspace\\CoreJava\\src\\daniel\\java\\util\\xml\\info_success.xml"));
		//InputStream inputXML = new FileInputStream(new File("D:\\devTools\\myEcspace\\CoreJava\\src\\daniel\\java\\util\\xml\\info_success_temp.xml"));
		InputStream inputXML = new FileInputStream(new File("D:\\devTools\\myEcspace\\CoreJava\\src\\daniel\\java\\util\\xml\\testxml\\info_success_V2.2-7825.xml"));
		List<CreditInfoPI> infoList = sax.parseCreditInfoXml(inputXML);
		System.out.println("----------nammi:xml file to java bean----------");
		for(CreditInfoPI creditInfo : infoList){
			System.out.println(creditInfo.toString());
		}
		//List转换为JSONObject
		System.out.println("----------nammi:infoList2JSONObject----------");
		JSONObject jsonObj = new JSONObject(); 
		jsonObj.put("infos", infoList);
		System.out.println(jsonObj.toString());
		
		//List转换为JSONArray
		System.out.println("----------nammi:infoList2JSONArray----------");
		JSONArray jsonArray = JSONArray.fromObject(infoList); 
		System.out.println(jsonArray.toString());
		
		/**
		 * test:XML形式字符串解析
		 */
		System.out.println("----------nammi:infoList2----------");
		String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> <RESPONSE errorcode=\"-53\" code=\"0\" countrows=\"1\"> <ROWS> <ROW> <ErrorCode>-53</ErrorCode><ErrorMsg>您没有权限使用此服务</ErrorMsg></ROW></ROWS></RESPONSE>";
		InputStream inputStr = new ByteArrayInputStream(xmlStr.getBytes());
		List<CreditInfoPI> infoList2 = sax.parseCreditInfoXml(inputStr);
		for(CreditInfoPI creditInfo : infoList2){
			System.out.println(creditInfo.toString());
		}
		
    }
}
