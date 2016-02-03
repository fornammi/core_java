package test.creditpay.action;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Scanner;

import com.bill99.ifs.fsp.model.auth.MerchantAuthInfo;
import com.bill99.ifs.fsp.service.auth.IndAuthService;
import com.caucho.hessian.client.HessianProxyFactory;

public class TestIndAuthHessian {
	private static final String merchantId = "104110045112012";
	private static final String terminalId = "00002012";
	private static final String customerId = "33150001";
	private static final String externalRefNumber = "1447835990898**18012943323";
	//private static final String pan = "6214830110731162";
	private static final String pan = "6228480030579646610";
	private static final String cardHolderName = "DH";
	private static final String idType = "0";
	//private static final String cardHolderId = "32058219870706111X";
	private static final String cardHolderId = "421127198606021756";
	private static final String expiredDate = "0911";
	private static final String cvv2 = "111";
	private static final String phoneNO = "15021115806";//18012943323
	private static final String responseCode = "00";
	private static final String responseTextMessage = "交易成功";
	
	public static void main(String[] args) {
		//dubbo-hessian服务url
		String url = "http://192.168.15.250:8082/ifs-fsp-core/hessian?interface=com.bill99.ifs.fsp.service.auth.IndAuthService";
		HessianProxyFactory factory = new HessianProxyFactory();
		//解决：接口中出现方法重载，在调用时服务器端会抛出异常
		factory.setOverloadEnabled(true);
		//factory.setUser("oracle");
		//factory.setPassword("oracle");
		HashMap authRespMap = null;
		HashMap verifyRespMap = null;
		try {
			IndAuthService indAuthService = (IndAuthService)factory.create(IndAuthService.class, url);
			MerchantAuthInfo info = new MerchantAuthInfo();
			info.setMerchantId(merchantId);
			info.setTerminalId(terminalId);
			info.setCustomerId(customerId);
			info.setExternalRefNumber(externalRefNumber);
			info.setPan(pan);
			info.setCardHolderName(cardHolderName);
			info.setIdType(idType);
			info.setCardHolderId(cardHolderId);
			info.setExpiredDate(expiredDate);
			info.setCvv2(cvv2);
			info.setPhoneNO(phoneNO);
			authRespMap = indAuthService.indAuth(info);
			
			//获取键盘输入的验证码:模拟手机接收验证码并输入的过程
	        System.out.println("-----read input from keyboard begin-----");
			Scanner s = new Scanner(System.in);
			System.out.println("请输入验证码：");
			//只读一行
	        String validCode = s.nextLine().trim();
	        System.out.println("validCode:"+validCode);
	        System.out.println("-----read input from keyboard end-----");
	        info.setToken((String)authRespMap.get("token"));
	        info.setValidCode(validCode);
	        info.setResponseCode(responseCode);
	        info.setResponseTextMessage(responseTextMessage);
	        verifyRespMap = indAuthService.indAuthVerify(info);
	        System.out.println("verifyRespMap:"+verifyRespMap);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
