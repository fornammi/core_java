package com.nammi.creditpay.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang.StringUtils;

import test.creditpay.com.bill99.mgw.entity.TransInfo;

/**
 * 独立鉴权入口
 * @author daniel.fang
 *
 */
public class MGWTest {
	
	//请求参数
	//1、sandbox
	/*private static final String url_auth = "https://sandbox.99bill.com:9445/cnp/ind_auth";
	private static final String url_auth_verify= "https://sandbox.99bill.com:9445/cnp/ind_auth_verify";
	private static final String jks_path = "D:\\devTools\\myEcspace\\CoreJava\\src\\test\\creditpay\\authfile\\10411004511201290.jks";
	private static final String merchantId = "104110045112012";
	private static final String terminalId = "00002012";
	private static final String customerId = "33150001";
	//private static final String externalRefNumber = "";
	private static final String pan = "6214830110731162";
	private static final String cardHolderName = "DH";
	private static final String idType = "0";
	private static final String cardHolderId = "32058219870706111X";
	private static final String expiredDate = "0911";
	private static final String cvv2 = "111";
	private static final String phoneNO = "15021115806";//18012943323
*/	
	
	//2、pro
	private static final String url_auth = "https://mas.99bill.com/cnp/ind_auth";
	private static final String url_auth_verify= "https://mas.99bill.com/cnp/ind_auth_verify";
	private static final String jks_path = "D:\\devTools\\myEcspace\\CoreJava\\src\\test\\creditpay\\authfile\\81231005311149690.jks";
	private static final String merchantId = "812310053111496";
	private static final String terminalId = "01800843";
	private static final String customerId = "10024632804";
	//private static final String externalRefNumber = "";
	private static final String pan = "6214830213980146";
	private static final String cardHolderName = "方钱";
	private static final String idType = "0";
	private static final String cardHolderId = "421127198606021756";
	private static final String expiredDate = "0911";
	private static final String cvv2 = "111";
	private static final String phoneNO = "15021115806";//18012943323
	
	
	//transInfo
	private static final String recordeText_1_auth = "indAuthContent";
	private static final String recordeText_1_verify = "indAuthDynVerifyContent";
	private static final String recordeText_2 = "ErrorMsgContent";
	
	//veriry
	public static String validCode = "";
	
	public static void main(String[] args) {
		String externalRefNumber = System.currentTimeMillis()+"**"+phoneNO;
		System.out.println("externalRefNumber:"+externalRefNumber);
		//拼接请求报文xml
		String indAuthReqXml = genIndAuthReqXmlStr(merchantId, terminalId, customerId, externalRefNumber, pan, cardHolderName, idType, cardHolderId, expiredDate, cvv2, phoneNO);
		System.out.println("indAuthReqXml:"+indAuthReqXml);
		
		String authRespXml = "";
		HashMap authRespMap = null;
		HashMap verifyRespMap = null;
		try {
			//卡信息验证（需要发送动态码）
			System.out.println("-----auth begin-----");
			//authRespXml = Post.sendPost2(url_sandbox_auth, indAuthReqXml, transInfo, jks_path);
			//System.out.println("authRespXml:"+authRespXml);
			//设置transInfo
			TransInfo transInfo = new TransInfo();
			transInfo.setRecordeText_1("indAuthContent");
			transInfo.setRecordeText_2("ErrorMsgContent");
			authRespMap = Post.sendPost(url_auth, indAuthReqXml, transInfo, jks_path, merchantId);
			System.out.println("authRespMap:"+authRespMap);
			System.out.println("-----auth end-----");
			if(authRespMap!=null){
				String token = (String)authRespMap.get("token");
				String responseCode = (String)authRespMap.get("responseCode");
				String responseTextMessage = (String)authRespMap.get("responseTextMessage");
				if(StringUtils.isNotBlank(token) && "00".equals(responseCode) && "交易成功".equals(responseTextMessage)){
					//获取键盘输入的验证码
			        System.out.println("-----read input from keyboard begin-----");
					Scanner s = new Scanner(System.in);
					System.out.println("请输入验证码：");
					//只读一行
			        String validCode = s.nextLine().trim();
			        System.out.println("validCode:"+validCode);
			        System.out.println("-----read input from keyboard end-----");
			        
			        System.out.println("-----verify begin-----");
			        //XML的root需要重新设置
			        transInfo.setRecordeText_1("indAuthDynVerifyContent");
					String indAuthVerifyReqXml = genIndAuthVerifyReqXmlStr(merchantId, terminalId, customerId, externalRefNumber, pan, validCode, token, phoneNO);
					System.out.println("indAuthVerifyReqXml:"+indAuthVerifyReqXml);
					verifyRespMap = Post.sendPost(url_auth_verify, indAuthVerifyReqXml, transInfo, jks_path, merchantId);
					System.out.println("verifyRespMap:"+verifyRespMap);
					System.out.println("responseCode:"+responseCode+"||responseTextMessage:"+responseTextMessage);
					System.out.println("-----verify end-----");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 鉴权请求报文
	 * @param merchantId
	 * @param terminalId
	 * @param customerId
	 * @param externalRefNumber
	 * @param pan
	 * @param cardHolderName
	 * @param idType
	 * @param cardHolderId
	 * @param expiredDate
	 * @param cvv2
	 * @param phoneNO
	 * @return
	 */
	public static String genIndAuthReqXmlStr(String merchantId, String terminalId, String customerId,
			String externalRefNumber, String pan, String cardHolderName, String idType, String cardHolderId,
			String expiredDate, String cvv2, String phoneNO){
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
		sb.append("<MasMessage xmlns=\"http://www.99bill.com/mas_cnp_merchant_interface\">");
		sb.append("<version>1.0</version>");
		sb.append("<indAuthContent>");
		sb.append("<merchantId>" + merchantId + "</merchantId>");
		sb.append("<terminalId>" + terminalId + "</terminalId>");
		sb.append("<customerId>" + customerId + "</customerId>");
		sb.append("<externalRefNumber>" + externalRefNumber + "</externalRefNumber>");
		sb.append("<pan>" + pan + "</pan>");
		sb.append("<cardHolderName>" + cardHolderName + "</cardHolderName>");
		sb.append("<idType>" + idType + "</idType>");
		sb.append("<cardHolderId>" + cardHolderId + "</cardHolderId>");
		if(!"".equals(expiredDate) && !"".equals(cvv2)){
		//  sb.append("<expiredDate>" + expiredDate + "</expiredDate>");
		// sb.append("<cvv2>" + cvv2 + "</cvv2>");
		}
		sb.append("<phoneNO>" + phoneNO + "</phoneNO>");
		sb.append("</indAuthContent>");
		sb.append("</MasMessage>");
		return sb.toString();
	}
	
	/**
	 * 动态码验证请求报文
	 * @param merchantId
	 * @param terminalId
	 * @param customerId
	 * @param externalRefNumber
	 * @param pan
	 * @param validCode
	 * @param token
	 * @param phoneNO
	 * @return
	 */
	public static String genIndAuthVerifyReqXmlStr(String merchantId, String terminalId, String customerId,
			String externalRefNumber, String pan, String validCode, String token, String phoneNO){
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
		sb.append("<MasMessage xmlns=\"http://www.99bill.com/mas_cnp_merchant_interface\">");
		sb.append("<version>1.0</version>");
		sb.append("<indAuthDynVerifyContent>");
		sb.append("<merchantId>" + merchantId + "</merchantId>");
		sb.append("<customerId>" + customerId + "</customerId>");
		sb.append("<externalRefNumber>" + externalRefNumber + "</externalRefNumber>");
		sb.append("<pan>" + pan + "</pan>");
		sb.append("<validCode>" + validCode + "</validCode>");
		sb.append("<token>" + token + "</token>");
		sb.append("<phoneNO>" + phoneNO + "</phoneNO>");
		sb.append("</indAuthDynVerifyContent>");
		sb.append("</MasMessage>");
		return sb.toString();
	}
	
}